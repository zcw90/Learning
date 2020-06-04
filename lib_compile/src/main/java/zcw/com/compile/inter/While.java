package zcw.com.compile.inter;

import zcw.com.compile.symbols.Type;

/**
 * Created by 朱城委 on 2020/5/26.<br><br>
 */
public class While extends Stmt {
    Expr expr;
    Stmt stmt;

    public While() {
        expr = null;
        stmt = null;
    }

    public void init(Expr x, Stmt s) {
        expr = x;
        stmt = s;
        if(expr.type != Type.Bool) {
            expr.error("boolean required in while");
        }
    }

    @Override
    public void gen(int b, int a) {
        after = a;
        expr.jumping(0, a);
        int label = newlabel();
        emitlabel(label);
        stmt.gen(label, b);
        emit("goto L" + b);
    }
}
