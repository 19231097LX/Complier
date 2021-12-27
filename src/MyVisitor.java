import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//部分错误类型声明
//4——声明变量已存在   5——引用变量不存在  6——变量赋值类型不符合  7——调用函数不存在  8——全局变量赋值不为常量表达式。
public class MyVisitor extends miniSysYBaseVisitor<String>{
    public int register = 1;//寄存器编号
    public String regSign = "%";//寄存器局部变量符号
    public String content = "";//编译器输出内容
    public String globalContent = "";//全局变量
    public String retType;//用于递归分析时记录当前函数返回值类型
    public int block = 1;//用于基本的编号
    private int type=32;//用于判断是否需要在判断cond时候将i32转换为i1
    private boolean returned=false;//用于辅助判断条件跳转的输出
    private boolean isSettingGlobal = false;

    //为了实现符号表的作用范围，使用arrayList来存储所有符号表，符号表本身用hashmap存储
    public ArrayList<HashMap<String, Item>> mapTable = new ArrayList<>();
    //用于指向/保存符号表深度
    public int tablePtr = 0;//0为全局变量
    //保存库函数调用
    public HashMap<String, MyFunction> libFunctions = new HashMap<>();
    private List<Integer> continueTos=new LinkedList<>();//用于记录接下来可能出现的 break 和 continue，。
    private List<Integer> breakTos=new LinkedList<>();//在其出现以后生成一个临时的占位符，并将这个占位符的位置存储到容器中，在退出这个函数前遍历这个容器，将那些位置替换为正确的跳转
    public MyVisitor() {
        super();
        //初始化第一张符号表
        this.mapTable.add(new HashMap<String, Item>());
        //初始化库函数对应调用语句
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
        String Sgetint = "declare i32 @getint()\n";
        String Sgetch = "declare i32 @getch()\n";
        String Sputint = "declare void @putint(i32)\n";
        String Sputch = "declare void @putch(i32)\n";
        String Sgetarray = "declare i32 @getarray()\n";
        String Sputarray = "declare void @putarray(i32)\n";
        this.content += Sgetint;
        this.content += Sgetch;
        this.content += Sgetarray;
        this.content += Sputint;
        this.content += Sputch;
        this.content += Sputarray;
    }
    //编译器输出llvm
    public String getContent() {
        System.out.println(this.globalContent+this.content);
        return this.globalContent+this.content;
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
        String tmp = "define dso_local ";
        tmp += visit(ctx.funcType());
        tmp += (" @" + ctx.Ident().getText() + "(" + "){\n");
        this.content += tmp;
        visit(ctx.block());
        this.content += "}\n";
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
        //进入基本块新建符号表，符号表指针加1
        this.mapTable.add(new HashMap<String, Item>());
        this.tablePtr++;
        visitChildren(ctx);
        //退出基本块移除符号表，符号表指针减一
        this.mapTable.remove(this.tablePtr);
        this.tablePtr--;
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
        this.returned = true;
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
                if(!this.isSettingGlobal) {
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
                else {
                    int numLhs,numRhs,numAns;
                    numLhs = Integer.parseInt(lhs);
                    numRhs = Integer.parseInt(rhs);
                    if (ctx.ADD() != null) {
                        numAns = numLhs + numRhs;
                        return Integer.toString(numAns);
                    }
                    else {
                        numAns = numLhs - numRhs;
                        return Integer.toString(numAns);
                    }
                }
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
                if(!this.isSettingGlobal) {
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
                else {
                    int numLhs,numRhs,numAns;
                    numLhs = Integer.parseInt(lhs);
                    numRhs = Integer.parseInt(rhs);
                    if (ctx.MUL() != null) {
                        numAns = numLhs * numRhs;
                        return Integer.toString(numAns);
                    } else if (ctx.DIV() != null) {
                        numAns = numLhs / numRhs;
                        return Integer.toString(numAns);
                    }
                    // MOD 运算
                    else {
                        numAns = numLhs % numRhs;
                        return Integer.toString(numAns);
                    }
                }
        }
    }

    @Override
    public String visitAssignStatement(miniSysYParser.AssignStatementContext ctx) {
        System.out.println("visitAssignStatement");
        String lval = ctx.lVal().getText();
        //从此层对应的符号表开始循环遍历之前的层直到找到对应的Item
        Item tmp = null;
        for(int i=this.tablePtr;i>=0;i--){
            tmp = this.mapTable.get(i).get(lval);
            if(tmp != null) break;
        }
        String llvm;
        //TODO 处理给全局变量赋值。
        //先确认目标存在且不为常量
        if (tmp != null && !tmp.cons) {
            if (!tmp.isInit()) tmp.setInit(true);
            if(tmp.getRegister().charAt(0) == '%') {
                String expReg = visit(ctx.exp());
                llvm = "    store i32 " + expReg + ", i32* " + tmp.register + "\n";
                this.content += llvm;
            }
            else {
                String expReg = visit(ctx.exp());
                llvm = "    store i32 " + expReg + ", i32* @" + tmp.name + "\n";
                this.content += llvm;
            }
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
        else if (ctx.sign.getType() == miniSysYParser.NOT){
            String reg = this.regSign + register++;
            String tmp = "    " + reg + " = icmp eq i32 " + ret + ",0\n";
            this.content += tmp;
            String reg2 = this.regSign + register++;
            String tmp2 = "    " + reg2 + " = zext i1 " + reg + " to i32\n";
            this.content += tmp2;
            return reg2;
        }
        return ret;
    }
    //处理调用的库函数
    @Override
    public String visitLibfunc(miniSysYParser.LibfuncContext ctx) {
        System.out.println("visitLibfunc");
        String libfunc = ctx.Ident().getText();
        //仅能调用存在的库函数
        String tmp, para = "";//参数字符串
        MyFunction func = this.libFunctions.get(libfunc);
        //函数存在
        if (func != null) {
            if (func.para){//是否含有参数
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
        //从此层对应的符号表开始循环遍历之前的层直到找到对应的Item
        Item tmp = null;
        for(int i=this.tablePtr;i>=0;i--){
            tmp = this.mapTable.get(i).get(lval);
            if(tmp != null) break;
        }
        String llvm;
        //先确认目标存在且已经有初始化值
        if (tmp != null && tmp.init) {
            if(!this.isSettingGlobal) {
                String newReg = this.regSign + this.register++;
                if(tmp.getRegister().charAt(0) == '%') {
                    llvm = "    " + newReg + " = load i32, i32* " + tmp.getRegister() + "\n";
                    this.content += llvm;
                    return newReg;
                }
                else {
                    llvm = "    " + newReg + " = load i32, i32* @" + tmp.name + "\n";
                    this.content += llvm;
                    return newReg;
                }
            }
            else {
                if(tmp.cons) {
                    return tmp.getRegister();
                }
                else System.exit(8);
            }
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
//        if (!this.mapTable.get(this.tablePtr).containsKey(IdentName) && !this.mapTable.get(0).containsKey(IdentName) ) {
        if (!this.mapTable.get(this.tablePtr).containsKey(IdentName)) {
            if(this.tablePtr==0){
                String tmp2 = "";
                tmp2 += ("@" + ctx.Ident().getText() + " = dso_local global i32 ");
                //TODO 设置全局量isSettingGlobal的值并做处理。
                this.isSettingGlobal = true;
                String tmpValue = visit(ctx.constInitVal());
                tmp2 += tmpValue + "\n";
                this.globalContent += tmp2;
                this.isSettingGlobal = false;
                tmp = new Item(IdentName, tmpValue, true, true, "i32");
                tmp.setInit(true);
                this.mapTable.get(this.tablePtr).put(IdentName, tmp);
            }
            else {
                String newReg = this.regSign + this.register++;
                //输出llvm代码alloca
                llvm = "    " + newReg + " = alloca i32\n";
                this.content += llvm;
                tmp = new Item(IdentName, newReg, true, true, "i32");
                tmp.setInit(true);
                this.mapTable.get(this.tablePtr).put(IdentName, tmp);
                String expReg = visit(ctx.constInitVal());
                llvm = "    store i32 " + expReg + ", i32* " + newReg + "\n";
                this.content += llvm;
            }
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
        Item tmp;
        String llvm;
        //先确认目标不存在 这里是为了区分以后的全局变量和局部变量都不重名
//        if (!this.mapTable.get(this.tablePtr).containsKey(IdentName) && !this.mapTable.get(0).containsKey(IdentName) ) {
        if (!this.mapTable.get(this.tablePtr).containsKey(IdentName)) {
            if(this.tablePtr==0){
                String tmp2 = "";
                tmp2 += ("@" + ctx.Ident().getText() + " = dso_local global i32 ");
                //TODO 设置全局量isSettingGlobal的值并做处理。
                if(ctx.initVal() != null) {
                    this.isSettingGlobal = true;
                    String tmpValue = visit(ctx.initVal());
                    tmp2 += tmpValue + "\n";
                    this.globalContent += tmp2;
                    this.isSettingGlobal = false;
                    tmp = new Item(IdentName, tmpValue, false, true, "i32");
                    tmp.setInit(true);
                    this.mapTable.get(this.tablePtr).put(IdentName, tmp);
                }
                //TODO  全局变量未初始化要主动赋值为0
                else {
                    tmp2 +="0\n";
                    this.globalContent += tmp2;
                    tmp = new Item(IdentName, "0", false, true, "i32");
                    tmp.setInit(true);
                    this.mapTable.get(this.tablePtr).put(IdentName, tmp);
                }
            }
            else {
                String newReg;
                //判断是否要进行初始化
                if (ctx.initVal() != null) {
                    newReg = this.regSign + this.register++;
                    //输出llvm代码alloca
                    llvm = "    " + newReg + " = alloca i32\n";
                    this.content += llvm;
                    tmp = new Item(IdentName, newReg, false, true, "i32");
                    tmp.setInit(true);
                    this.mapTable.get(this.tablePtr).put(IdentName, tmp);
                    String expReg = visit(ctx.initVal());
                    llvm = "    store i32 " + expReg + ", i32* " + newReg + "\n";
                    this.content += llvm;
                    //add item
                } else {
                    newReg = this.regSign + this.register++;
                    tmp = new Item(IdentName, newReg, false, false, "i32");
                    tmp.setInit(false);
                    this.mapTable.get(this.tablePtr).put(IdentName, tmp);
                    //输出llvm代码alloca
                    llvm = "    " + newReg + " = alloca i32\n";
                    this.content += llvm;
                }
            }
        } else System.exit(4);
        return null; }

    @Override
    public String visitInitVal(miniSysYParser.InitValContext ctx) {
        System.out.println("visitInitVal");
        return visitChildren(ctx);
    }
    @Override
    public String visitRelExp(miniSysYParser.RelExpContext ctx) {
        System.out.println("visitRelExp");
        System.out.println(ctx.children.size());
        switch (ctx.children.size()) {
            case 1:
                return visitChildren(ctx);
            default:
                String lhs = visit(ctx.relExp());
                String rhs = visit(ctx.addExp());
                String reg = this.regSign + register++;
                String tmp = "";
                if(ctx.sign.getType() == miniSysYParser.GR){
                    tmp = "    " + reg + " = icmp sgt i32 " + lhs + ", " + rhs + "\n";
                }
                else if (ctx.sign.getType() == miniSysYParser.LR){
                    tmp = "    " + reg + " = icmp slt i32 " + lhs + ", " + rhs + "\n";
                }
                else if (ctx.sign.getType() == miniSysYParser.LE){
                    tmp = "    " + reg + " = icmp sle i32 " + lhs + ", " + rhs + "\n";
                }
                else if(ctx.sign.getType() == miniSysYParser.GE){
                    tmp = "    " + reg + " = icmp sge i32 " + lhs + ", " + rhs + "\n";
                }
                this.content += tmp;
                this.type = 1;
                return reg;
        }
    }

    @Override
    public String visitEqExp(miniSysYParser.EqExpContext ctx) {
        System.out.println("visitEqExp");
        switch (ctx.children.size()) {
            case 1:
                return visitChildren(ctx);
            default:
                String lhs = visit(ctx.eqExp());
                String rhs = visit(ctx.relExp());
                String reg = this.regSign + register++;
                String tmp = "";
                if(ctx.sign.getType() == miniSysYParser.EQUAL){
                    tmp = "    " + reg + " = icmp eq i32 " + lhs + ", " + rhs + "\n";
                }
                else if (ctx.sign.getType() == miniSysYParser.NOTEQUAL){
                    tmp = "    " + reg + " = icmp ne i32 " + lhs + ", " + rhs + "\n";
                }
                this.content += tmp;
                this.type = 1;
                return reg;
        }
    }
    @Override
    public String visitLAndExp(miniSysYParser.LAndExpContext ctx) {
        System.out.println("visitLAndExp");
        switch (ctx.children.size()) {
            case 1:
                return visitChildren(ctx);
            default:
                String lhs = visit(ctx.lAndExp());
                String rhs = visit(ctx.eqExp());
                String reg = this.regSign + register++;
                String tmp = "";
                tmp = "    " + reg + " = and i1 " + lhs + ", " + rhs + "\n";
                this.content += tmp;
                return reg;
        }
    }

    @Override
    public String visitLOrExp(miniSysYParser.LOrExpContext ctx) {
        System.out.println("visitLOrExp");
        switch (ctx.children.size()) {
            case 1:
                return visitChildren(ctx);
            default:
                String lhs = visit(ctx.lOrExp());
                String rhs = visit(ctx.lAndExp());
                String reg = this.regSign + register++;
                String tmp = "";
                tmp = "    " + reg + " = or i1 " + lhs + ", " + rhs + "\n";
                this.content += tmp;
                return reg;
        }
    }
    @Override
    public String visitCondStatement(miniSysYParser.CondStatementContext ctx) {
        System.out.println("visitCondStatement");
        int ifBlock;
        int deBlock;
        String llvm;
        String reg;
        System.out.println("childrenSize:"+ctx.children.size());
        if (ctx.children.size() == 5) {
            String condReg = visit(ctx.cond());
            System.out.println("childrenSize:"+ctx.children.size());
            ifBlock=++block;
            deBlock=++block;
            if(this.type==32){
                reg = this.regSign + register++;
                llvm = "    " + reg + " = icmp ne i32 " + condReg + ",0\n";
                this.content += llvm;
            }
            else {
                reg = condReg;
            }
            this.type=32;
            this.content +="    br i1 " +reg+ ",label %b" +ifBlock+ ",label %b" +deBlock+ "\n";
            this.content +="b" +ifBlock+ ":\n";
            visit(ctx.children.get(4));
            if(!returned){
                this.content +="    br label %b" +deBlock+ "\n";
            }
            returned = false;
            this.content +="b" +deBlock+ ":\n";
            return null;
        }
        else if(ctx.children.size() == 7){
            String condReg = visit(ctx.cond());
            ifBlock=++block;
            int elseBlock=++block;
            deBlock=++block;
            if(this.type==32){
                reg = this.regSign + register++;
                llvm = "    " + reg + " = icmp ne i32 " + condReg + ",0\n";
                this.content += llvm;
            }
            else {
                reg = condReg;
            }
            this.type=32;
            this.content +="    br i1 " +reg+ ",label %b" +ifBlock+ ",label %b" +elseBlock+ "\n";
            this.content +="b" +ifBlock+ ":\n";
            visit(ctx.children.get(4));
            if(!returned){
                this.content +="    br label %b" +deBlock+ "\n";
            }
            returned = false;
            this.content +="b" +elseBlock+ ":\n";
            visit(ctx.children.get(6));
            if(!returned){
                this.content +="    br label %b" +deBlock+ "\n";
            }
            returned = false;
            this.content +="b" +deBlock+ ":\n";
            return null;
        }
        else return null;
    }
    @Override
    public String visitCond(miniSysYParser.CondContext ctx) {
        System.out.println("visitCond");
        return visitChildren(ctx);
    }
    @Override
    public String visitWhileStatement(miniSysYParser.WhileStatementContext ctx) {
        System.out.println("visitWhileStatement");
        int ifBlock;
        int deBlock;
        String llvm;
        String reg;
        String condReg = visit(ctx.cond());
        ifBlock=++block;
        deBlock=++block;
        continueTos.add(ifBlock);
        breakTos.add(deBlock);
        if(this.type==32){
            reg = this.regSign + register++;
            llvm = "    " + reg + " = icmp ne i32 " + condReg + ",0\n";
            this.content += llvm;
        }
        else {
            reg = condReg;
        }
        this.type=32;
        this.content +="    br i1 " +reg+ ",label %b" +ifBlock+ ",label %b" +deBlock+ "\n";
        this.content +="b" +ifBlock+ ":\n";
        visit(ctx.children.get(4));
        if(!returned){
            String condReg2 = visit(ctx.cond());
            if(this.type==32){
                reg = this.regSign + register++;
                llvm = "    " + reg + " = icmp ne i32 " + condReg + ",0\n";
                this.content += llvm;
            }
            else {
                reg = condReg2;
            }
            this.type=32;
            this.content +="    br i1 " +reg+ ",label %b" +ifBlock+ ",label %b" +deBlock+ "\n";
        }
        returned = false;
        continueTos.remove(continueTos.size()-1);
        breakTos.remove(breakTos.size()-1);
        this.content +="b" +deBlock+ ":\n";
        return null;
    }
    @Override
    public String visitBreakStatement(miniSysYParser.BreakStatementContext ctx) {
        System.out.println("visitBreakStatement");
        if(breakTos.size()==0)
            System.exit(8);
        this.content +="    br label %b" +breakTos.get(breakTos.size()-1)+ "\n";
        return null;
    }
    @Override
    public String visitContinueStatement(miniSysYParser.ContinueStatementContext ctx) {
        System.out.println("visitContinueStatement");
        if(continueTos.size()==0)
            System.exit(8);
        this.content +="    br label %b" +continueTos.get(continueTos.size()-1)+ "\n";
        return null;
    }
}
