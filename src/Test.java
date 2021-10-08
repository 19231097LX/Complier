import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static String[] tokenName = {"if", "else", "while", "break", "continue", "return", "=", ";", "(", ")", "{", "}", "+", "*", "/", "<", ">", "=="};
    public static String[] tokenOut = {"If", "Else", "While", "Break", "Continue", "Return", "Assign", "Semicolon", "LPar", "RPar",
            "LBrace", "RBrace", "Plus", "Mult", "Div", "Lt", "Gt", "Eq"};
    public static Character[] symbols = {'=', '>', '<', '+', '*', '/', '(', ')', '{', '}', '_', ';'};
    public static List<String> tokenNameList = Arrays.asList(tokenName);

    public static boolean isLetter(char ch){
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    public static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static void printNI(int flag, StringBuilder word) {
        if (word.length() != 0) {
            if (flag==1)
                System.out.println("Number(" + word + ")");
            if (flag==2) {
                int index = tokenNameList.indexOf(word.toString());
                if (index != -1)
                    System.out.println(tokenOut[index]);
                else
                    System.out.println("Ident(" + word + ")");
            }
        }
    }

    public static void judge(String s) {
        int index = tokenNameList.indexOf(s);
        if (index != -1) {
            System.out.println(tokenOut[index]);
        } else {
            boolean number = false;
            boolean ident = false;
            int flag = 0;//1-number，2-ident
            StringBuilder word = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {//筛出出现了token表中没有的其他符号的词
                if (!(Character.isLetterOrDigit(s.charAt(j)) || Arrays.asList(symbols).contains(s.charAt(j)))) {
                    System.out.println("Err");
                    System.exit(0);
                }
            }
            for (int j = 0; j < s.length(); j++) {
                if (Character.isLetterOrDigit(s.charAt(j)) || s.charAt(j) == '_') {
                    final boolean b = isLetter(s.charAt(j)) || s.charAt(j) == '_';
                    if (word.length() == 0) {//标识符首位不能为数字
                        if (Character.isDigit(s.charAt(j)))
                            flag = 1;
                        else if (b)
                            flag = 2;
                        word.append(s.charAt(j));
                    } else {
                        if (Character.isDigit(s.charAt(j)))
                            word.append(s.charAt(j));
                        else if (b) {
                            if (flag==2)
                                word.append(s.charAt(j));
                            if (flag==1) {
                                System.out.println("Number(" + word + ")");
                                word = new StringBuilder();
                                word.append(s.charAt(j));
                                flag=2;
                            }
                        }
                    }
                }
                else {
                    printNI(flag, word);
                    word = new StringBuilder();
                    flag=0;
                    if (j < s.length() - 1 && s.charAt(j) == '=' && s.charAt(j + 1) == '=') {
                        System.out.println("Eq");
                        if (j == s.length() - 2) {
                            break;
                        }
                        j++;
                    } else if (!(Character.isLetterOrDigit(s.charAt(j)) || s.charAt(j) == '_')) {
                        String s1 = String.valueOf(s.charAt(j));
                        int index1 = tokenNameList.indexOf(s1);
                        System.out.println(tokenOut[index1]);
                    }
                }

            }
            printNI(flag, word);
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str;

        while ((str = bufferedReader.readLine()) != null) {
            String[] a = str.split("\\n|\\s");
            for (int i = 0; i < a.length; i++) {
                judge(a[i]);
            }
        }
    }
}
