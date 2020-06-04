package zcw.com.compile.lexer;

/**
 * Created by 朱城委 on 2020/5/21.<br><br>
 */
public class Num extends Token {
    public final int value;

    public Num(int value) {
        super(Tag.NUM);

        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
