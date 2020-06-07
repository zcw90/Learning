package zcw.com.compile.lexer;

/**
 * Created by 朱城委 on 2020/5/25.<br><br>
 */
public class Real extends Token {
    private final float value;

    public Real(float v) {
        super(Tag.REAL);
        value = v;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
