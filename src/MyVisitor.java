import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//部分错误类型声明
//4——声明变量已存在   5——引用变量不存在  6——变量赋值类型不符合  7——调用函数不存在  8——全局变量赋值不为常量表达式。 9--块跳转出错
public class MyVisitor extends miniSysYBaseVisitor<String>{
    public int register = 1;//寄存器编号
    public String regSign = "%";//寄存器局部变量符号
    public String content = "";//编译器输出内容
    public String globalContent = "";//全局变量
    public String retType;//用于递归分析时记录当前函数返回值类型
    public int block = 1;//用于基本的编号
    private int type=32;//用于判断是否需要在判断cond时候将i32转换为i1
    private boolean returned=false;//用于辅助判断条件跳转的输出
    private boolean isBreak=false;//用于辅助判断条件跳转的输出
    private boolean isContinue=false;//用于辅助判断条件跳转的输出
    private boolean isSettingGlobal = false;
    private List<Integer> initDimension=new LinkedList<>();//用于初始化数组变量纬度
    private Item initArray=new Item();//用于初始化数组变量
    private int tmpDime=0;//用于initArray
    private int ind=0;
    private int nodeValue = 0;//保存节点值
    public boolean isPriE = true;
    public int expLevel = 0;
    public int isAnd=0;

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
        String Smemset = "declare void @memset(i32*, i32, i32)\n";
        this.content += Sgetint;
        this.content += Sgetch;
        this.content += Sgetarray;
        this.content += Sputint;
        this.content += Sputch;
        this.content += Sputarray;
        this.content += Smemset;
    }
    private void appendInitArrayV() {
        int sum = initArray.values.size();
        if (this.tablePtr == 0) {
            this.globalContent+="[";
            for (int j = 0; j < sum; j++) {
                this.globalContent+=" i32 "+initArray.values.get(j);
                if (j != sum - 1)
                    this.globalContent+=",";
            }
            this.globalContent+="]\n";
        }
    }
    private void appendInitArray(Item id,int demi){
        int num=1;
        for(int i=0;i<id.dimension.size();i++){
            num*=id.dimension.get(i);
        }
        if(this.tablePtr==0) {
            this.globalContent += " [" + num + " x i32] ";
        }
        else {
            this.content += " [" + num + " x i32] ";
        }
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
        nodeValue=rnum;
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
                int numLhs,numRhs,numAns;
                String lhs = visit(ctx.addExp());
                numLhs = nodeValue;
                String rhs = visit(ctx.mulExp());
                numRhs = nodeValue;
                if (ctx.ADD() != null) {
                    numAns = numLhs + numRhs;
                    nodeValue=numAns;
                }
                else {
                    numAns = numLhs - numRhs;
                    nodeValue=numAns;
                }
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
                    if (ctx.ADD() != null) {
                        return Integer.toString(numAns);
                    }
                    else {
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
                int numLhs,numRhs,numAns;
                String lhs = visit(ctx.mulExp());
                numLhs = nodeValue;
                String rhs = visit(ctx.unaryExp());
                numRhs = nodeValue;
                if (ctx.MUL() != null) {
                    numAns = numLhs * numRhs;
                } else if (ctx.DIV() != null) {
                    numAns = numLhs / numRhs;
                }
                // MOD 运算
                else {
                    numAns = numLhs % numRhs;
                }
                nodeValue=numAns;
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
                    if (ctx.MUL() != null) {
                        return Integer.toString(numAns);
                    } else if (ctx.DIV() != null) {
                        return Integer.toString(numAns);
                    }
                    // MOD 运算
                    else {
                        return Integer.toString(numAns);
                    }
                }
        }
    }

    @Override
    public String visitAssignStatement(miniSysYParser.AssignStatementContext ctx) {
        System.out.println("visitAssignStatement");
        String lval = ctx.lVal().Ident().getText();
        //从此层对应的符号表开始循环遍历之前的层直到找到对应的Item
        Item tmp = null;
        for(int i=this.tablePtr;i>=0;i--){
            tmp = this.mapTable.get(i).get(lval);
            if(tmp != null) break;
        }
        String llvm;
        //先确认目标存在且不为常量
        if (tmp != null && !tmp.cons) {
            if (!tmp.isInit()) tmp.setInit(true);
            if(tmp.dimension.size()==0) {
                if (tmp.getRegister().charAt(0) == '%') {
                    String expReg = visit(ctx.exp());
                    llvm = "    store i32 " + expReg + ", i32* " + tmp.register + "\n";
                    tmp.value = nodeValue;
                    this.content += llvm;
                } else {
                    String expReg = visit(ctx.exp());
                    llvm = "    store i32 " + expReg + ", i32* @" + tmp.name + "\n";
                    tmp.value = nodeValue;
                    this.content += llvm;
                }
            }
            else {
                this.isPriE=false;
                String lvalReg= visit(ctx.lVal());
                this.isPriE=true;
                String expReg = visit(ctx.exp());
                this.content+= "    store i32 " + expReg + ", i32* " + lvalReg + "\n";
            }
        } else System.exit(5);
        return null;
    }
    @Override
    public String visitPriE(miniSysYParser.PriEContext ctx) {
        System.out.println("visitPriE");
        String ret=visitChildren(ctx);
        return ret;
    }

    //专门用于处理二元+-,只有UnaryOpExp的标识符为-才分配寄存器返回。否则返回对子节点的访问结果。
    @Override
    public String visitUnaryOpExp(miniSysYParser.UnaryOpExpContext ctx) {
        System.out.println("visitUnaryOpExp");
        String ret = visit(ctx.unaryExp());
        if(isSettingGlobal){
            String retS=ret;
            if (ctx.sign.getType() == miniSysYParser.SUB) {
                retS = "-"+ret;
                nodeValue = -nodeValue;
            }
            else if (ctx.sign.getType() == miniSysYParser.NOT) {
                retS = "!"+ret;
                if (nodeValue != 0) nodeValue = 0;
                else nodeValue = 1;
            }
            return retS;
        }
        else {
            if (ctx.sign.getType() == miniSysYParser.SUB) {
                String reg = this.regSign + register++;
                String tmp = "    " + reg + " = sub i32 0, " + ret + "\n";
                this.content += tmp;
                nodeValue = -nodeValue;
                return reg;
            } else if (ctx.sign.getType() == miniSysYParser.NOT) {
                String reg = this.regSign + register++;
                String tmp = "    " + reg + " = icmp eq i32 " + ret + ",0\n";
                this.content += tmp;
                String reg2 = this.regSign + register++;
                String tmp2 = "    " + reg2 + " = zext i1 " + reg + " to i32\n";
                this.content += tmp2;
                if (nodeValue != 0) nodeValue = 0;
                else nodeValue = 1;
                return reg2;
            }
            return ret;
        }
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
        String lval = ctx.Ident().getText();
        //从此层对应的符号表开始循环遍历之前的层直到找到对应的Item
        Item tmp = null;
        for(int i=this.tablePtr;i>=0;i--){
            tmp = this.mapTable.get(i).get(lval);
            if(tmp != null) break;
        }
        String llvm;
        //使用数组元素赋值
        if(tmp==null) System.exit(5);
        if(tmp.values.size()!=0){
            if(tmp.dimension.size()!=ctx.exp().size()){
                System.exit(12);//维度不匹配
            }else {
                int index=0,num;
                String newReg = this.regSign + this.register++;
                this.content += "    " + newReg + " = add i32 0,0\n";
                int lastR=this.register-1;
                int retRegister=this.register;//返回的寄存器
                for (int j=0;j<ctx.exp().size();j++){
                    expLevel++;
                    String expReg=visit(ctx.exp(j));
                    num=1;
                    for(int k=j+1;k<ctx.exp().size();k++){
                        num*=tmp.dimension.get(k);
                    }
                    if(!tmp.cons) {
                        String reg1 = this.regSign + this.register++;
                        this.content += "    " + reg1 + " = mul i32 " + num + "," + expReg + "\n";
                        String reg2 = this.regSign + this.register++;
                        String reg3 = this.regSign + (this.register - 2);
                        this.content += "    " + reg2 + " = add i32 %" + lastR + "," + reg3 + "\n";
                        lastR = this.register - 1;
                    }
                    retRegister=this.register-1;//存放着保存着数组元素下标数组的地址
                    index+=num*nodeValue;
                    expLevel--;
                }
                if(!tmp.cons) {
                    String reg1 = this.regSign + this.register++;
                    this.content += "    " + reg1 + " = getelementptr [" + tmp.values.size() + " x i32],[" + tmp.values.size() + " x i32]* ";
                    if (!this.isSettingGlobal) {
                        if (tmp.getRegister().charAt(0) == '%') {
                            llvm = tmp.register;
                            this.content += llvm;
                        } else {
                            llvm = "@" + tmp.name;
                            this.content += llvm;
                        }
                    } else System.exit(8);
                    this.content += ",i32 0,i32 %" + retRegister + "\n";
                    if(isPriE||expLevel>0){
                        newReg = this.regSign + this.register++;
                        this.content += "    " + newReg + " = load i32, i32* " + reg1 + "\n";
                        if(this.isAnd>0){
                            String reg2=this.regSign + this.register++;
                            this.content += "    " + reg2 + " = zext i32 " + newReg + " to i1\n";
                            newReg=reg2;
                        }
                    }
                    else newReg=reg1;
                    return newReg;
                }
                else if(tmp.cons){
                    //TODO 常量数组的取值
                    nodeValue=tmp.values.get(index);
//                    String tmpReg = this.regSign + this.register++;
//                    this.content += "    store i32 " + nodeValue + ", i32* " + tmpReg + "\n";
                    newReg = Integer.toString(nodeValue);
                }
                return newReg;
            }
        }
        else{
            //先确认目标存在且已经有初始化值
            if (tmp != null && tmp.init) {
                if(!this.isSettingGlobal) {
                    String newReg = this.regSign + this.register++;
                    if(tmp.getRegister().charAt(0) == '%') {
                        llvm = "    " + newReg + " = load i32, i32* " + tmp.getRegister() + "\n";
                        this.content += llvm;
                        nodeValue=tmp.value;
                        return newReg;
                    }
                    else {
                        llvm = "    " + newReg + " = load i32, i32* @" + tmp.name + "\n";
                        this.content += llvm;
                        nodeValue=tmp.value;
                        return newReg;
                    }
                }
                else {
                    if(tmp.cons) {
                        nodeValue=tmp.value;
                        return tmp.getRegister();
                    }
                    else System.exit(8);
                }
            } else System.exit(5);
        }

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
            if(ctx.constExp().size()==0) {
                if (this.tablePtr == 0) {
                    String tmp2 = "";
                    tmp2 += ("@" + ctx.Ident().getText() + " = dso_local global i32 ");
                    this.isSettingGlobal = true;
                    String tmpValue = visit(ctx.constInitVal());
                    tmp2 += tmpValue + "\n";
                    this.globalContent += tmp2;
                    this.isSettingGlobal = false;
                    tmp = new Item(IdentName, tmpValue, true, true, "i32");
                    tmp.setInit(true);
                    tmp.value = nodeValue;
                    this.mapTable.get(this.tablePtr).put(IdentName, tmp);
                } else {
                    String newReg = this.regSign + this.register++;
                    //输出llvm代码alloca
                    llvm = "    " + newReg + " = alloca i32\n";
                    this.content += llvm;
                    tmp = new Item(IdentName, newReg, true, true, "i32");
                    tmp.setInit(true);
                    this.mapTable.get(this.tablePtr).put(IdentName, tmp);
                    String expReg = visit(ctx.constInitVal());
                    llvm = "    store i32 " + expReg + ", i32* " + newReg + "\n";
                    tmp.value = nodeValue;
                    this.content += llvm;
                }
            }
            else {
                int num=1;
                tmp = new Item(IdentName, "", true, true, "i32");
                this.mapTable.get(this.tablePtr).put(IdentName, tmp);
                for (int j=0;j<ctx.constExp().size();j++){
                    this.isSettingGlobal = true;
                    String demiReg=visit(ctx.constExp(j));
                    this.isSettingGlobal = false;
                    int demi=Integer.parseInt(demiReg);
                    if(demi<=0){
                        System.exit(10);//数组维度为非正数
                    }
                    tmp.dimension.add(demi);
                    num*=demi;
                }
                for(int j=0;j<num;j++){
                    tmp.values.add(0);
                }
                initArray=tmp;
                for(int i=0;i<initArray.dimension.size();i++){
                    initDimension.add(0);
                }
                if(this.tablePtr == 0) {
                    this.isSettingGlobal=true;
                    visit(ctx.constInitVal());
                    this.isSettingGlobal=false;
                }
                else visit(ctx.constInitVal());
                tmp.init=true;
                initArray=new Item();
                initDimension=new LinkedList<>();
            }
        } else System.exit(4);
        this.tmpDime=0;
        return null;
    }

    @Override
    public String visitConstInitVal(miniSysYParser.ConstInitValContext ctx) {
        System.out.println("visitConstInitVal");
        if(ctx.children.size()==1){
            String expReg=visit(ctx.constExp());
            //TODO 是否要加@?
            if(this.tablePtr==0&&(expReg.charAt(0)=='%'||expReg.charAt(0)=='@')){
                System.exit(11);
            }
            if(initDimension.size()!=0){
                int index=0;
                for (int j=0;j<initDimension.size()-1;j++){
                    int num=1;
                    for (int k=j+1;k<initDimension.size();k++){
                        num*=initArray.dimension.get(k);
                    }
                    index+=num*initDimension.get(j);
                }
                initArray.values.remove(index+ind);
                initArray.values.add(index+ind,nodeValue);
            }
            return expReg;
        }else {
            int i;
            tmpDime++;
            for(i=0;i<ctx.constInitVal().size();i++) {
                ind = i;
                visit(ctx.constInitVal(i));
                if (ctx.constInitVal(i).children.size() != 1)
                    tmpDime--;
                int tmp = initDimension.get(tmpDime - 1);
                initDimension.remove(tmpDime - 1);
                initDimension.add(tmpDime - 1, tmp + 1);
                for (int j = tmpDime; j < initDimension.size(); j++) {
                    initDimension.remove(j);
                    initDimension.add(j, 0);
                }
                ind = 0;
            }
        }
        return null;
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
            if(ctx.constExp().size()==0) {
                if (this.tablePtr == 0) {
                    String tmp2 = "";
                    tmp2 += ("@" + ctx.Ident().getText() + " = dso_local global i32 ");
                    if (ctx.initVal() != null) {
                        this.isSettingGlobal = true;
                        String tmpValue = visit(ctx.initVal());
                        tmp2 += tmpValue + "\n";
                        this.globalContent += tmp2;
                        this.isSettingGlobal = false;
                        tmp = new Item(IdentName, tmpValue, false, true, "i32");
                        tmp.setInit(true);
                        tmp.value=nodeValue;
                        this.mapTable.get(this.tablePtr).put(IdentName, tmp);
                    } else {
                        tmp2 += "0\n";
                        this.globalContent += tmp2;
                        tmp = new Item(IdentName, "0", false, true, "i32");
                        tmp.setInit(true);
                        tmp.value=0;
                        this.mapTable.get(this.tablePtr).put(IdentName, tmp);
                    }
                } else {
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
                        tmp.value=nodeValue;
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
            }
            else{
                int num=1;
                tmp = new Item(IdentName, "", false, false, "i32");
                this.mapTable.get(this.tablePtr).put(IdentName, tmp);
                for (int j=0;j<ctx.constExp().size();j++){
                    this.isSettingGlobal = true;
                    String demiReg=visit(ctx.constExp(j));
                    this.isSettingGlobal = false;
                    int demi=Integer.parseInt(demiReg);
                    if(demi<=0){
                        System.exit(10);//数组维度为非正数
                    }
                    tmp.dimension.add(demi);
                    num*=demi;
                }
                for(int j=0;j<num;j++){
                    tmp.values.add(0);
                }
                if (this.tablePtr == 0) {
                    tmp.register="@"+tmp.name;
                    this.globalContent += "@" + ctx.Ident().getText() + " = dso_local global ";
                    initArray=tmp;
                    appendInitArray(tmp,0);
                    if(ctx.initVal()!=null){
                        for(int i=0;i<initArray.dimension.size();i++){
                            initDimension.add(0);
                        }
                        visit(ctx.initVal());//会将数组的初始化值填入initArray.values中
                        appendInitArrayV();
                        tmp.setInit(true);
                        initArray=new Item();
                        initDimension=new LinkedList<>();
                    }else{
                        this.globalContent+=" zeroinitializer\n";
                    }
                }else {
                    String newReg = this.regSign + this.register++;
                    tmp.register = newReg;
                    initArray=tmp;
                    this.content+= "    "+newReg+" = alloca ";
                    appendInitArray(tmp,0);
                    this.content+="\n";
                    String reg1 = this.regSign + this.register++;
                    this.content+="    "+reg1+" = getelementptr ["+tmp.values.size()+" x i32],["+tmp.values.size()+" x i32]* "+tmp.register+",i32 0,i32 0\n";
                    this.content+="    call void @memset(i32* %"+(this.register-1)+", i32 0, i32 "+4*tmp.values.size()+")\n";
                    if(ctx.initVal()!=null){
                        tmp.setInit(true);
                        for(int i=0;i<initArray.dimension.size();i++){
                            initDimension.add(0);
                        }
                        visit(ctx.initVal());
                        appendInitArrayV();
                        initArray=new Item();
                        initDimension=new LinkedList<>();
                    }
                }
            }
        } else System.exit(4);
        this.tmpDime=0;
        return null;
    }

    @Override
    public String visitInitVal(miniSysYParser.InitValContext ctx) {
        System.out.println("visitInitVal");
        if(ctx.children.size()==1){
            String expReg=visit(ctx.exp());
            //TODO 是否要加@?
            if(this.tablePtr==0&&(expReg.charAt(0)=='%'||expReg.charAt(0)=='@')){
                System.exit(11);
            }
            if(initDimension.size()!=0){
                int index=0;
                for (int j=0;j<initDimension.size()-1;j++){
                    int num=1;
                    for (int k=j+1;k<initDimension.size();k++){
                        num*=initArray.dimension.get(k);
                    }
                    index+=num*initDimension.get(j);
                }
                index+=ind;
                if(this.tablePtr!=0){
                    String reg1 = this.regSign+this.register++;
                    this.content+="    "+reg1+"= getelementptr ["+initArray.values.size()+" x i32],["+initArray.values.size()+" x i32]* ";
                    this.content+=initArray.register;
                    this.content+=",i32 0,i32 "+index+"\n";
                    this.content+="    store i32 "+expReg+", i32* "+reg1+"\n";
                }
                initArray.values.remove(index);
                initArray.values.add(index,nodeValue);
            }
            else {
                return expReg;
            }
        }else {
            int i;
            tmpDime++;
            for(i=0;i<ctx.initVal().size();i++) {
                ind = i;
                visit(ctx.initVal(i));
                if (ctx.initVal(i).children.size() != 1)
                    tmpDime--;
                int tmp = initDimension.get(tmpDime - 1);
                initDimension.remove(tmpDime - 1);
                initDimension.add(tmpDime - 1, tmp + 1);
                for (int j = tmpDime; j < initDimension.size(); j++) {
                    initDimension.remove(j);
                    initDimension.add(j, 0);
                }
                ind = 0;
            }
        }
        return null;
        //return visitChildren(ctx);
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
                this.isAnd++;
                String lhs = visit(ctx.lAndExp());
                String rhs = visit(ctx.eqExp());
                String reg = this.regSign + register++;
                String tmp = "";
                tmp = "    " + reg + " = and i1 " + lhs + ", " + rhs + "\n";
                this.content += tmp;
                this.isAnd--;
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
            if(!returned&&!isBreak&&!isContinue){
                this.content +="    br label %b" +deBlock+ "\n";
            }
            returned = false;isBreak=false;isContinue=false;
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
            if(!returned&&!isBreak&&!isContinue){
                this.content +="    br label %b" +deBlock+ "\n";
            }
            returned = false;isBreak=false;isContinue=false;
            this.content +="b" +elseBlock+ ":\n";
            visit(ctx.children.get(6));
            if(!returned&&!isBreak&&!isContinue){
                this.content +="    br label %b" +deBlock+ "\n";
            }
            returned = false;isBreak=false;isContinue=false;
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
            String reg2;
            if(this.type==32){
                reg2 = this.regSign + register++;
                llvm = "    " + reg2 + " = icmp ne i32 " + condReg2 + ",0\n";
                this.content += llvm;
            }
            else {
                reg2 = condReg2;
            }
            this.type=32;
            this.content +="    br i1 " +reg2+ ",label %b" +ifBlock+ ",label %b" +deBlock+ "\n";
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
            System.exit(9);
        this.content +="    br label %b" +breakTos.get(breakTos.size()-1)+ "\n";
        this.isBreak=true;
        return null;
    }
    @Override
    public String visitContinueStatement(miniSysYParser.ContinueStatementContext ctx) {
        System.out.println("visitContinueStatement");
        if(continueTos.size()==0)
            System.exit(9);
        this.content +="    br label %b" +continueTos.get(continueTos.size()-1)+ "\n";
        this.isContinue=true;
        return null;
    }
}
