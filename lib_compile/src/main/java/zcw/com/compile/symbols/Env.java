package zcw.com.compile.symbols;

import java.util.Hashtable;

import zcw.com.compile.inter.Id;
import zcw.com.compile.lexer.Token;

/**
 * Created by 朱城委 on 2020/5/21.<br><br>
 */
public class Env {
    private Hashtable<Token, Id> table;

    protected Env prev;

    public Env(Env p) {
        table = new Hashtable<>();
        prev = p;
    }

    public void put(Token w, Id i) {
        table.put(w, i);
    }

    public Id get(Token w) {
        for(Env e = this; e != null; e = e.prev) {
            Id found = e.table.get(w);
            if(found != null) {
                return found;
            }
        }

        return null;
    }
}
