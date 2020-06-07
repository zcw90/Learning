package zcw.com.compile.inter;

/**
 * Created by 朱城委 on 2020/5/26.<br><br>
 */
public class Break extends Stmt {
    Stmt stmt;

    public Break() {
        if(Stmt.Enclosing == Stmt.Null) {
            error("unenclosed break");
        }
        stmt = Stmt.Enclosing;
    }

    @Override
    public void gen(int b, int a) {
        emit("goto L" + stmt.after);
    }
}
