import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class errorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
                            String msg, RecognitionException e) {
        super.syntaxError(recognizer,offendingSymbol,line,charPositionInLine,msg,e);
        System.out.println(offendingSymbol);
        System.out.println(msg);
        System.exit(2);
    }

}
