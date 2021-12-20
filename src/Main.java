import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String a = "src/input.txt";
        String b="src/output.txt";
        //args[0]
        CharStream inputStream = CharStreams.fromFileName(args[0]); // 获取输入流
        miniSysYLexer lexer = new miniSysYLexer(inputStream);//词法分析器
        CommonTokenStream tokenStream = new CommonTokenStream(lexer); // 获取词法分析 token 流
        miniSysYParser parser = new miniSysYParser(tokenStream);//语法分析器
        errorListener el = new errorListener();//移除antlr原有错误处理并加上定义的错误处理使得词法、语法分析出错时编译器以非0值退出。
        parser.removeErrorListeners();
        parser.addErrorListener(el);
        miniSysYParser.CompUnitContext tree = parser.compUnit();
        MyVisitor visitor = new MyVisitor();
//        visitor.init(args[1]);
        visitor.visit(tree);
        //args[1]
        FileWriter fw = new FileWriter(args[1]);
        fw.write(visitor.getContent());
        fw.close();
//        ParseTree tree = parser.compUnit(); // 获取语法树的根节点
//        System.out.println(tree.toStringTree(parser)); // 打印字符串形式的语法树
    }
}
