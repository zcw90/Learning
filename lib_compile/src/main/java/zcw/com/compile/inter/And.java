package zcw.com.compile.inter;

import zcw.com.compile.lexer.Token;

/**
 * Created by 朱城委 on 2020/5/26.<br><br>
 */
public class And extends Logical {
    public And(Token tok, Expr x1, Expr x2) {
        super(tok, x1, x2);
    }

    @Override
    public void jumping(int t, int f) {
        int label = f != 0 ? f : newlabel();
        expr1.jumping(0, label);
        expr2.jumping(t, f);
        if(f == 0) {
            emitlabel(label);
        }
    }
}
