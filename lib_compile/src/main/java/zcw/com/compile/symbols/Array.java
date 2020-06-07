package zcw.com.compile.symbols;

import zcw.com.compile.lexer.Tag;

/**
 * Created by 朱城委 on 2020/5/26.<br><br>
 */
public class Array extends Type {
    public Type of;
    public int size = 1;

    public Array(int sz, Type p) {
        super("[]", Tag.INDEX, sz * p.width);
        size = sz;
        of = p;
    }

    public String toString() {
        return "[" + size + "] " + of.toString();
    }
}
