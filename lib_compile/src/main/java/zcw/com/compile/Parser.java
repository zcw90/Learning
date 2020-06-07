package zcw.com.compile;

import java.io.IOException;

import zcw.com.compile.main.Main;

/**
 * Created by 朱城委 on 2020/5/20.<br><br>
 */
public class Parser {
    static int lookahead;

    public Parser() throws IOException {
//        lookahead = System.in.read();
        lookahead = Main.test.charAt(Main.count++);
    }

    void expr() throws IOException {
        term();
        while (true) {
            if(lookahead == '+') {
                match('+');
                term();
                System.out.write('+');
            }
            else if(lookahead == '-') {
                match('-');
                term();
                System.out.write('-');
            }
            else {
                return ;
            }
        }
    }

    void term() throws IOException {
        if(Character.isDigit((char)lookahead)) {
            System.out.write((char)lookahead);
            match(lookahead);
        }
        else {
            throw new Error("Syntax error");
        }
    }


    void match(int t) throws IOException {
        if(lookahead == t) {
//            lookahead = System.in.read();
            lookahead = Main.test.charAt(Main.count++);
        }
        else {
            throw new Error("syntax error");
        }
    }
}
