package zcw.com.compile.lexer;

/**
 * Created by 朱城委 on 2020/5/21.<br><br>
 */
public class Token {
    public final int tag;

    public Token(int tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "" + (char)tag;
    }
}
