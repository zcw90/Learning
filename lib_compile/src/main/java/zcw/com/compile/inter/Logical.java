package zcw.com.compile.inter;

import zcw.com.compile.lexer.Token;
import zcw.com.compile.symbols.Type;

/**
 * Created by 朱城委 on 2020/5/26.<br><br>
 */
public class Logical extends Expr {
    public Expr expr1;
    public Expr expr2;

    Logical(Token tok, Expr x1, Expr x2) {
        super(tok, null);
        expr1 = x1;
        expr2 = x2;
        type = check(expr1.type, expr2.type);
        if(type == null) {
            error("type error");
        }
    }

    public Type check(Type p1, Type p2) {
        if(p1 == Type.Bool && p2 == Type.Bool) {
            return Type.Bool;
        }
        else {
            return null;
        }
    }

    @Override
    public Expr gen() {
        int f = newlabel();
        int a = newlabel();
        Temp temp = new Temp(type);
        this.jumping(0, f);
        emit(temp.toString() + " = true");
        emit("goto L" + a);
        emitlabel(f);
        emit(temp.toString() + " = false");
        emitlabel(a);
        return temp;
    }

    @Override
    public String toString() {
        return expr1.toString() + " " + op.toString() + " " + expr2.toString();
    }
}
