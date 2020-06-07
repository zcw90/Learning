package zcw.com.compile.inter;

import zcw.com.compile.lexer.Token;
import zcw.com.compile.symbols.Type;

/**
 * Created by 朱城委 on 2020/5/26.<br><br>
 */
public class Expr extends Node {
    public Token op;
    public Type type;

    Expr(Token tok, Type p) {
        op = tok;
        type = p;
    }

    public Expr gen() {
        return this;
    }

    public Expr reduce() {
        return this;
    }

    public void jumping(int t, int f) {
        emitjumps(toString(), t, f);
    }

    public void emitjumps(String test, int t, int f) {
        if(t != 0 && f != 0) {
            emit("if " + test + " goto L" + t);
            emit("goto L" + f);
        }
        else if(t != 0) {
            emit("if " + test + " goto L" + t);
        }
        else if(f != 0) {
            emit("iffalse " + test + " goto L" + f);
        }
    }

    public String toString() {
        return op.toString();
    }
}
