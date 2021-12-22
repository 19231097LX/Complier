//符号表项目
public class Item {
    public String name;//表项内容
    public String register;//所存寄存器,当为全局变量时，存入的是全局的值。
    public boolean cons;//是否为常量
    public boolean init;//是否初始化
    public String type;//数据类型

    public Item(String name,String reg,boolean con,boolean ini,String type){
        this.name = name;
        this.register = reg;
        this.cons = con;
        this.init = ini;
        this.type = type;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public boolean isInit() {
        return init;
    }

    public void setInit(boolean init) {
        this.init = init;
    }
}