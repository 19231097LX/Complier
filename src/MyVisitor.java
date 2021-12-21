import java.util.ArrayList;
import java.util.HashMap;

//部分错误类型声明
//4——声明变量已存在   5——引用变量不存在  6——变量赋值类型不符合  7——调用函数不存在
public class MyVisitor extends miniSysYBaseVisitor<String>{
    public int register = 1;//寄存器编号
    public String libFuncDecl = "";//库函数声明输出内容
    public String regSign = "%";//局部变量符号
    public String content = "";//编译器输出内容
    public String retType;//用于递归分析时记录当前函数返回值类型

    //为了实现符号表的作用范围，使用arrayList来存储所有符号表，符号表本身用hashmap存储
    public ArrayList<HashMap<String, Item>> mapTable = new ArrayList<>();
    //用于指向/保存符号表深度
    public int tablePtr = 0;
    //保存库函数调用
    public HashMap<String, MyFunction> libFunctions = new HashMap<>();
    public MyVisitor() {
        super();
        //初始化第一张符号表
        this.mapTable.add(new HashMap<String, Item>());
        //初始化库函数对应调用语句
        //不处理括号ver
        MyFunction getint = new MyFunction("getint", true, false, "i32");
        MyFunction putint = new MyFunction("putint", true, true, "void");
        MyFunction getch = new MyFunction("getch", true, false, "i32");
        MyFunction putch = new MyFunction("putch", true, true, "void");
        MyFunction getarray = new MyFunction("getarray", true, false, "i32");
        MyFunction putarray = new MyFunction("putarray", true, true, "void");
        libFunctions.put("getint", getint);
        libFunctions.put("putint", putint);
        libFunctions.put("getch", getch);
        libFunctions.put("putch", putch);
        libFunctions.put("getarray", getarray);
        libFunctions.put("putarray", putarray);
    }
    //编译器输出llvm
    public String getContent() {
        System.out.println(content);
        return content;
    }
    @Override
    public String visitCompUnit(miniSysYParser.CompUnitContext ctx) {
        System.out.println("visitCompUnit");
        visitChildren(ctx);
        return null;
    }

    @Override
    public String visitFuncDef(miniSysYParser.FuncDefContext ctx) {
        System.out.println("visitFuncDef");
        //处理库函数声明
        String getint = "declare i32 @getint()\n";
        String getch = "declare i32 @getch()\n";
        String putint = "declare void @putint(i32)\n";
        String putch = "declare void @putch(i32)\n";
        String getarray = "declare i32 @getarray()\n";
        String putarray = "declare void @putarray(i32)\n";
        this.content += getint;
        this.content += getch;
        this.content += getarray;
        this.content += putint;
        this.content += putch;
        this.content += putarray;

        //处理本函数
        String tmp = "define dso_local ";
        tmp += visit(ctx.funcType());
        tmp += (" @" + ctx.Ident().getText() + "(" + ")");
        this.content += tmp;
        visit(ctx.block());
        return null;
    }

    @Override
    public String visitFuncType(miniSysYParser.FuncTypeContext ctx) {
        System.out.println("visitFuncType");
        String type = "";
        if (ctx.INT() != null) {
            type += "i32";
        }
        this.retType = type;
        return type;
    }

    @Override
    public String visitBlock(miniSysYParser.BlockContext ctx) {
        System.out.println("visitBlock");
        this.content += "{\n";
        visitChildren(ctx);
        this.content += "}";
        return null;
    }

    @Override
    public String visitBlockItem(miniSysYParser.BlockItemContext ctx) {
        System.out.println("visitBlockItem");
        return visitChildren(ctx);
    }

    @Override
    public String visitStmt(miniSysYParser.StmtContext ctx) {
        System.out.println("visitStmt");
        return visitChildren(ctx);
    }

    @Override
    public String visitRetStatement(miniSysYParser.RetStatementContext ctx) {
        System.out.println("visitRetStatement");
        String tmp = "    ret " + this.retType +" "+ visit(ctx.exp()) + "\n";
        this.content += tmp;
        return null;
    }
    //处理number
    @Override
    public String visitNum(miniSysYParser.NumContext ctx) {
        System.out.println("visitNum");
        String num = ctx.Number().getText();
        int rnum = 0;
        if (num.charAt(0) == '0' && num.length() >1 ) {
            if ( num.charAt(1) == 'x' || num.charAt(1) == 'X') rnum = Integer.valueOf(num.substring(2), 16);
            else rnum = Integer.valueOf(num.substring(1), 8);
        } else rnum = Integer.valueOf(num, 10);
//        int reg = register++;
//        this.content += regSign + reg +"= alloca i32";
//        this.content += "store i32 " + rnum + ", i32*" + regSign + reg;
//        return reg;}
        return String.valueOf(rnum);
    }
    @Override
    public String visitExpStatement(miniSysYParser.ExpStatementContext ctx) {
        System.out.println("visitExpStatement");
        return visitChildren(ctx);
    }

    @Override
    public String visitExp(miniSysYParser.ExpContext ctx) {
        System.out.println("visitExp");
        return visitChildren(ctx);
    }

    @Override
    public String visitAddExp(miniSysYParser.AddExpContext ctx) {
        System.out.println("visitAddExp");
        switch (ctx.children.size()) {
            case 1:
                return visitChildren(ctx);
            default:
                String lhs = visit(ctx.addExp());
                String rhs = visit(ctx.mulExp());
                String reg = this.regSign + register++;
                String tmp;
                if (ctx.ADD() != null) {
                    tmp = "    " + reg + " = add i32 " + lhs + ", " + rhs + "\n";
                } else {
                    tmp = "    " + reg + " = sub i32 " + lhs + ", " + rhs + "\n";
                }
                this.content += tmp;
                return reg;
        }
    }
    @Override
    public String visitMulExp(miniSysYParser.MulExpContext ctx) {
        System.out.println("visitMulExp");
        switch (ctx.children.size()) {
            case 1:
                return visitChildren(ctx);
            default:
                String lhs = visit(ctx.mulExp());
                String rhs = visit(ctx.unaryExp());
                String reg = this.regSign + register++;
                String tmp;
                if (ctx.MUL() != null) {
                    tmp = "    " + reg + " = mul i32 " + lhs + ", " + rhs + "\n";
                } else if (ctx.DIV() != null) {
                    tmp = "    " + reg + " = sdiv i32 " + lhs + ", " + rhs + "\n";
                }
                // MOD 运算
                else {
                    tmp = "    " + reg + " = srem i32 " + lhs + ", " + rhs + "\n";
                }
                this.content += tmp;
                return reg;
        }
    }

    @Override
    public String visitAssignStatement(miniSysYParser.AssignStatementContext ctx) {
        System.out.println("visitAssignStatement");
        String lval = ctx.lVal().getText();
        String expReg = visit(ctx.exp());
        Item tmp = this.mapTable.get(this.tablePtr).get(lval);
        String llvm;
        String reg;
        //先确认目标存在且不为常量
        if (tmp != null && !tmp.cons) {
//            reg = this.regSign + register++;
//            tmp.setRegister(reg);
            if (!tmp.isInit()) tmp.setInit(true);
            //输出llvm代码！
            llvm = "    store i32 " + expReg + ", i32* " + tmp.register + "\n";
            this.content += llvm;
        } else System.exit(5);
        return null;
    }
    @Override
    public String visitPriE(miniSysYParser.PriEContext ctx) {
        System.out.println("visitPriE");
        return visitChildren(ctx);
    }

    //专门用于处理二元+-,只有UnaryOpExp的标识符为-才分配寄存器返回。否则返回对子节点的访问结果。
    @Override
    public String visitUnaryOpExp(miniSysYParser.UnaryOpExpContext ctx) {
        System.out.println("visitUnaryOpExp");
        String ret = visit(ctx.unaryExp());
        if (ctx.sign.getType() == miniSysYParser.SUB) {
            String reg = this.regSign + register++;
            String tmp = "    " + reg + " = sub i32 0, " + ret + "\n";
            this.content += tmp;
            return reg;
        }
        return ret;
    }
    //处理调用的库函数
    @Override
    public String visitLibfunc(miniSysYParser.LibfuncContext ctx) {
        System.out.println("visitLibfunc");
        String libfunc = ctx.Ident().getText();
        //仅能调用存在的库函数
        String tmp, para = "";
        MyFunction func = this.libFunctions.get(libfunc);
        //函数存在
        if (func != null) {
            if (func.para){
                String expReg = visit(ctx.funcRParams());
                para += ("i32 " + expReg);
            }
            tmp = "call " + func.retType + " @" + libfunc + "(" + para + ")\n";
            if (func.retType.equals("void")) content += ("    "+tmp);
            else{
                String reg = this.regSign + register++;
                content +=  ("    "+reg +" = ");
                content += tmp;
                return reg;
            }
            return tmp;
        }
        else System.exit(7);

        return visitChildren(ctx);
    }

    @Override
    public String visitFuncRParams(miniSysYParser.FuncRParamsContext ctx) {
        System.out.println("visitFuncRParams");
        return visitChildren(ctx);
    }

    @Override
    public String visitBraces(miniSysYParser.BracesContext ctx) {
        System.out.println("visitBraces");
        return visit(ctx.exp());
    }

    @Override
    public String visitLVal(miniSysYParser.LValContext ctx) {
        System.out.println("visitLVal");
        String lval = ctx.getText();
        Item tmp = this.mapTable.get(this.tablePtr).get(lval);
        String llvm;
        //先确认目标存在且已经有初始化值
        if (tmp != null && tmp.init) {
            String newReg = this.regSign + this.register++;
            //准备新寄存器 %3 = load i32, i32* %1
            //输出llvm代码！
            llvm = "    "+newReg+" = load i32, i32* " + tmp.getRegister() + "\n";
            this.content += llvm;
            return newReg;
        } else System.exit(5);
        return null;
    }

    @Override
    public String visitDecl(miniSysYParser.DeclContext ctx) {
        System.out.println("visitDecl");
        return visitChildren(ctx);
    }

    @Override
    public String visitConstDecl(miniSysYParser.ConstDeclContext ctx) {
        System.out.println("visitConstDecl");
        return visitChildren(ctx); }

    @Override
    public String visitBType(miniSysYParser.BTypeContext ctx) {
        System.out.println("visitBType");
        return visitChildren(ctx);
    }
    //先检查全局表内是否存在同名变量 再存
    @Override
    public String visitConstDef(miniSysYParser.ConstDefContext ctx) {
        System.out.println("visitConstDef");
        String IdentName = ctx.Ident().getText();
        Item tmp;
        String llvm;
        //先确认目标不存在 这里是为了区分以后的全局变量和局部变量都不重名
        if (!this.mapTable.get(this.tablePtr).containsKey(IdentName) && !this.mapTable.get(0).containsKey(IdentName) ) {
            String newReg = this.regSign + this.register++;
            //输出llvm代码alloca
            llvm= "    "+newReg + " = alloca i32\n";
            this.content += llvm;
            //i32 or int?
            tmp = new Item(IdentName,newReg,true,true,"i32");
            tmp.setInit(true);
            //0？
            this.mapTable.get(this.tablePtr).put(IdentName,tmp);
            //输出llvm代码store
            String expReg = visit(ctx.constInitVal());
            llvm = "    store i32 " + expReg + ", i32* " + newReg + "\n";
            this.content += llvm;
        } else System.exit(4);
        return null;
    }

    @Override
    public String visitConstInitVal(miniSysYParser.ConstInitValContext ctx) {
        System.out.println("visitConstInitVal");
        return visitChildren(ctx);
    }

    @Override
    public String visitConstExp(miniSysYParser.ConstExpContext ctx) {
        System.out.println("visitConstExp");
        return visitChildren(ctx);
    }

    @Override
    public String visitVarDecl(miniSysYParser.VarDeclContext ctx) {
        System.out.println("visitVarDecl");
        return visitChildren(ctx);
    }

    @Override
    public String visitVarDef(miniSysYParser.VarDefContext ctx) {
        System.out.println("visitVarDef");
        String IdentName = ctx.Ident().getText();
//        String expReg = visit(ctx.initVal());
        Item tmp;
        String llvm;
        //先确认目标不存在 这里是为了区分以后的全局变量和局部变量都不重名
        if (!this.mapTable.get(this.tablePtr).containsKey(IdentName) && !this.mapTable.get(0).containsKey(IdentName) ) {
            String newReg;
            //i32 or int?
            //判断是否初始化
            if(ctx.initVal()!= null){
                newReg = this.regSign + this.register++;
                //输出llvm代码alloca
                llvm= "    "+newReg + " = alloca i32\n";
                this.content += llvm;
                tmp = new Item(IdentName,newReg,false,true,"i32");
                tmp.setInit(true);
                this.mapTable.get(this.tablePtr).put(IdentName,tmp);
                String expReg = visit(ctx.initVal());
                //输出llvm代码store
                llvm = "    store i32 " + expReg + ", i32* " + newReg + "\n";
                this.content += llvm;
                //add item
            }
            else{
                newReg = this.regSign + this.register++;
                tmp = new Item(IdentName,newReg,false,false,"i32");
                tmp.setInit(false);
                this.mapTable.get(this.tablePtr).put(IdentName,tmp);
                //输出llvm代码alloca
                llvm= "    "+newReg + " = alloca i32\n";
                this.content += llvm;
            }

        } else System.exit(4);
        return null; }

    @Override
    public String visitInitVal(miniSysYParser.InitValContext ctx) {
        System.out.println("visitInitVal");
        return visitChildren(ctx);
    }
}
