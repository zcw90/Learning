package zcw.com.compile.inter;

/**
 * Created by 朱城委 on 2020/5/21.<br><br>
 */
public class Stmt extends Node {
    public static Stmt Null = new Stmt();

    public static Stmt Enclosing = Stmt.Null;

    int after = 0;

    public Stmt() {

    }

    public void gen(int b, int a) {

    }
}
