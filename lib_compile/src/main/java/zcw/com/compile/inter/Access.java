package zcw.com.compile.inter;

import zcw.com.compile.lexer.Tag;
import zcw.com.compile.lexer.Word;
import zcw.com.compile.symbols.Type;

/**
 * Created by 朱城委 on 2020/5/26.<br><br>
 */
public class Access extends Op {
    public Id array;
    public Expr index;

    public Access(Id a, Expr i, Type p) {
        super(new Word("[]", Tag.INDEX), p);
        array = a;
        index = i;
    }

    @Override
    public Expr gen() {
        return new Access(array, index.reduce(), type);
    }

    @Override
    public void jumping(int t, int f) {
        emitjumps(reduce().toString(), t, f);
    }

    @Override
    public String toString() {
        return array.toString() + " [ " + index.toString() + " ]";
    }
}
