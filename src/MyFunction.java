import java.util.ArrayList;

public class MyFunction {
    public String name;//函数名
    public boolean lib;//是否为库函数
    public boolean para; //是否带参数
    public ArrayList<String> params ;//参数列表
    public String retType;//返回值类型

    public MyFunction(String name, boolean lib, boolean param, String retType){
        this.name = name;
        this.lib = lib;
        this.para = param;
        //如果有参数，初始化参数列表
        if(param){
            params = new ArrayList<String>();
        }
        this.retType = retType;
    }
}
