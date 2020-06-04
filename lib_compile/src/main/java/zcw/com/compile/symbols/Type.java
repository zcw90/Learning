package zcw.com.compile.symbols;

import zcw.com.compile.lexer.Tag;
import zcw.com.compile.lexer.Word;

/**
 * Created by 朱城委 on 2020/5/25.<br><br>
 */
public class Type extends Word {
    public int width = 0;

    public static final Type Int = new Type("int", Tag.BASIC, 4);
    public static final Type Float = new Type("float", Tag.BASIC, 8);
    public static final Type Char = new Type("char", Tag.BASIC, 1);
    public static final Type Bool = new Type("bool", Tag.BASIC, 1);

    public Type(String s, int tag, int w) {
        super(s, tag);
        width = w;
    }

    public static boolean numeric(Type p) {
        if(p == Type.Char || p == Type.Int || p == Type.Float) {
            return true;
        }
        else {
            return false;
        }
    }

    public static Type max(Type p1, Type p2) {
        if(!numeric(p1) || !numeric(p2)) {
            return null;
        }
        else if(p1 == Type.Float || p2 == Type.Float) {
            return Type.Float;
        }
        else if(p1 == Type.Int || p2 == Type.Int) {
            return Type.Int;
        }
        else {
            return Type.Char;
        }
    }
}
