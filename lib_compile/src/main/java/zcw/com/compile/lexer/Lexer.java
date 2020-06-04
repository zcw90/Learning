package zcw.com.compile.lexer;

import java.io.IOException;
import java.util.Calendar;
import java.util.Hashtable;

import zcw.com.compile.main.Main;
import zcw.com.compile.symbols.Type;

/**
 * Created by 朱城委 on 2020/5/21.<br><br>
 */
public class Lexer {
    public static int line = 1;
    private char peek = ' ';
    private Hashtable<String, Word> words = new Hashtable<>();

    void reserve(Word t) {
        words.put(t.lexeme, t);
    }

    public Lexer() {
        reserve(new Word("if", Tag.IF));
        reserve(new Word("else", Tag.ELSE));
        reserve(new Word("while", Tag.WHILE));
        reserve(new Word("do", Tag.DO));
        reserve(new Word("break", Tag.BREAK));
        reserve(Word.True);
        reserve(Word.False);
        reserve(Type.Int);
        reserve(Type.Char);
        reserve(Type.Bool);
        reserve(Type.Float);
    }

    void reahch() throws IOException {
//        peek = (char)System.in.read();
        peek = Main.test.charAt(Main.count++);
    }

    boolean reahch(char c) throws IOException {
        reahch();
        if(peek != c) {
            return false;
        }

        peek = ' ';
        return true;
    }

    public Token scan() throws IOException {
        // 跳过空白符
        for( ; ; reahch()) {
            if(peek == ' ' || peek == '\t') {
                continue;
            }
            else if(peek == '\n') {
                line = line + 1;
            }
            else {
                break;
            }
        }

        // 预读一个字符，判断是否为&&、||、==、!=、<=、>=
        switch (peek) {
            case '&':
                if(reahch('&')) {
                    return Word.and;
                }
                else {
                    return new Token('&');
                }

            case '|':
                if(reahch('|')) {
                    return Word.or;
                }
                else {
                    return new Token('|');
                }

            case '=':
                if(reahch('=')) {
                    return Word.eq;
                }
                else {
                    return new Token('=');
                }

            case '!':
                if(reahch('=')) {
                    return Word.ne;
                }
                else {
                    return new Token('!');
                }

            case '<':
                if(reahch('=')) {
                    return Word.le;
                }
                else {
                    return new Token('<');
                }

            case '>':
                if(reahch('=')) {
                    return Word.ge;
                }
                else {
                    return new Token('>');
                }
        }

        // 获取数字输入
        if(Character.isDigit(peek)) {
            int v = 0;

            do {
                v = v * 10 + Character.digit(peek, 10);
                reahch();
            }
            while (Character.isDigit(peek));

            // 处理小数
            if(peek != '.') {
                return new Num(v);
            }

            float x = v;
            float d = 10;
            for(;;) {
                reahch();
                if(!Character.isDigit(peek)) {
                    break;
                }

                x = x + Character.digit(peek, 10) / d; d = d * 10;
            }

            return new Real(x);
        }

        // 获取标识符
        if(Character.isLetter(peek)) {
            StringBuffer b = new StringBuffer();
            do {
                b.append(peek);
                reahch();
            }
            while (Character.isLetterOrDigit(peek));

            String s = b.toString();
            Word w = words.get(s);
            if(w != null) {
                return w;
            }

            w = new Word(s, Tag.ID);
            words.put(s, w);
            return w;
        }

        Token t = new Token(peek);
        peek = ' ';
        return t;
    }
}
