package zcw.com.compile.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import zcw.com.compile.lexer.Lexer;
import zcw.com.compile.parser.Parser;

/**
 * Created by 朱城委 on 2020/5/25.<br><br>
 */
public class Main {
    public static int count = 0;
    public static String test = "";

    public static void main(String[] args) throws IOException {
        File file = new File("lib_compile\\test_input.txt");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        inputStream.read(bytes, 0, (int) file.length());

        test = new String(bytes);
        test = test.replace("\r\n", "\n");
        System.out.println(test);

        Lexer lex = new Lexer();
        Parser parser = new Parser(lex);
        parser.program();
        System.out.println("\n");
    }
}
