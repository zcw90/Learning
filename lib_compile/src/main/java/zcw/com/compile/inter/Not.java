package zcw.com.compile.inter;

import zcw.com.compile.lexer.Token;

/**
 * Created by 朱城委 on 2020/5/26.<br><br>
 */
public class Not extends Logical {
    public Not(Token tok, Expr x2) {
        super(tok, x2, x2);
    }

    @Override
    public void jumping(int t, int f) {
        expr2.jumping(f, t);
    }

    @Override
    public String toString() {
        return op.toString() + " " + expr2.toString();
    }
}
