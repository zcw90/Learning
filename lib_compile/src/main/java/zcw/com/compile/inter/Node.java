package zcw.com.compile.inter;

import zcw.com.compile.lexer.Lexer;

/**
 * Created by 朱城委 on 2020/5/21.<br><br>
 */
public class Node {
    int lexline = 0;

    static int labels = 0;

    Node() {
        lexline = Lexer.line;
    }

    void error(String s) {
        throw new Error("near line " + lexline + ": " + s);
    }

    public int newlabel() {
        return ++labels;
    }

    public void emitlabel(int i) {
        System.out.print("L" + i + ":");
    }

    public void emit(String s) {
        System.out.println("\t" + s);
    }
}
