package zcw.com.compile.inter;

import zcw.com.compile.lexer.Token;

/**
 * Created by 朱城委 on 2020/5/26.<br><br>
 */
public class Or extends Logical {
    public Or(Token tok, Expr x1, Expr x2) {
        super(tok, x1, x2);
    }

    @Override
    public void jumping(int t, int f) {
        int label = t != 0 ? t : newlabel();
        expr1.jumping(label, 0);
        expr2.jumping(t, f);
        if(t == 0) {
            emitlabel(label);
        }
    }
}
