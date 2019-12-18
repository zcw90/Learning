package zcw.com.basic.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/**
 * Created by 朱城委 on 2019/8/12.<br><br>
 */
public class StreamTest {
    public static void main(String[] args) throws IOException {
        StreamTest test = new StreamTest();
//        test.copyFile("./Android常用操作.txt", "./Android常用操作2.txt");
//        test.copyFileWordForWord("./Android常用操作.txt", "./Android常用操作2.txt");
//        test.copyFile("D:/IT/专业电子书/深入理解计算机系统_第3版.pdf", "D:/IT/专业电子书/深入理解计算机系统_第3版2.pdf");
        test.copyFileChar("./Android常用操作.txt", "./Android常用操作2.txt");
    }

    public void copyFile(String sourceFileName, String destFileName) throws IOException {
        File sourceFile = new File(sourceFileName);
        if(!sourceFile.exists()) {
            sourceFile.createNewFile();
        }

        File destFile = new File(destFileName);
        if(!destFile.exists()) {
            destFile.createNewFile();
        }

        FileInputStream inputStream = new FileInputStream(sourceFile);
        FileOutputStream outputStream = new FileOutputStream(destFile, true);
        byte[] buffer = new byte[8192];
        int length;
        long total = 0;

        while ((length = inputStream.read(buffer)) != -1) {
            total += length;
            outputStream.write(buffer, 0, length);
            System.out.println("已经复制 " + length + "/" + total + " 字节");
        }
        System.out.println("=====");
        System.out.println("文件总大小：" + total + "子节");

        inputStream.close();
        outputStream.close();
    }

    public void copyFileWordForWord(String sourceFileName, String destFileName) throws IOException {
        File sourceFile = new File(sourceFileName);
        if(!sourceFile.exists()) {
            sourceFile.createNewFile();
        }

        File destFile = new File(destFileName);
        if(!destFile.exists()) {
            destFile.createNewFile();
        }

        FileInputStream inputStream = new FileInputStream(sourceFile);
        FileOutputStream outputStream = new FileOutputStream(destFile, true);
        long total = 0;
        int data;

        while ((data = inputStream.read()) != -1) {
            total ++;
            outputStream.write(data);
            System.out.println("已经复制 " + total + " 字节");
        }
        System.out.println("=====");
        System.out.println("文件总大小：" + total + "子节");

        inputStream.close();
        outputStream.close();
    }

    public void copyFileChar(String sourceFileName, String destFileName) throws IOException {
        File sourceFile = new File(sourceFileName);
        if(!sourceFile.exists()) {
            sourceFile.createNewFile();
        }

        File destFile = new File(destFileName);
        if(!destFile.exists()) {
            destFile.createNewFile();
        }

        FileReader reader = new FileReader(sourceFile);
        FileWriter writer = new FileWriter(destFile);
        System.out.println(reader.getEncoding());
        System.out.println(writer.getEncoding());
//        InputStreamReader reader = new InputStreamReader(new FileInputStream(sourceFile), "GB18030");
//        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(destFile), "GB18030");

        char[] buffer = new char[8192];
        int length;
        int total = 0;
        while((length = reader.read(buffer)) != -1) {
            total += length;
            writer.write(buffer, 0, length);
            System.out.println("已经复制 " + total + " 字符");
        }
        System.out.println("=====");
        System.out.println("文件总大小：" + total + "子字符");

        reader.close();
        writer.close();
    }
}
