package zcw.com.compile.inter;

import zcw.com.compile.symbols.Type;

/**
 * Created by 朱城委 on 2020/5/21.<br><br>
 */
public class If extends Stmt {
    Expr expr;
    Stmt stmt;

    public If(Expr x, Stmt s) {
        expr = x;
        stmt = s;
        if(expr.type != Type.Bool) {
            expr.error("boolean required in if");
        }
    }

    @Override
    public void gen(int b, int a) {
        int label = newlabel();
        expr.jumping(0, a);
        emitlabel(label);
        stmt.gen(label, a);
    }
}
