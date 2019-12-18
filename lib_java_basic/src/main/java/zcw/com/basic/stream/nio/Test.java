package zcw.com.basic.stream.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 朱城委 on 2019/8/13.<br><br>
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Test test = new Test();

//        test.readFile("./Android常用操作.txt");
//        test.writeFile("C:/Users/zhuch/Desktop/test.txt");
//        test.copyFile("D:/IT/专业电子书/深入理解计算机系统_第3版.pdf", "E:/深入理解计算机系统_第3版2.pdf");
        test.copyFile("D:/软件/win10-64-zyb.iso", "E:/win10-64-zyb.iso");
    }

    public void readFile(String fileName) throws IOException {
        FileInputStream inputStream = new FileInputStream(fileName);
        FileChannel channel = inputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);

        System.out.println(new String(buffer.array(), "GB18030"));
    }

    public void writeFile(String fileName) throws IOException {
        File file = new File(fileName);
        if(!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream outputStream = new FileOutputStream(file, true);
        FileChannel channel = outputStream.getChannel();
        FileChannel channel1 = outputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        for(String string : getData(20)) {
            buffer.put(string.getBytes());
        }

        buffer.flip();
        channel.write(buffer);
        buffer.flip();
        channel1.write(buffer);
    }

    public void copyFile(String srcFilePath, String dstFilePath) throws IOException {
        File srcFile = new File(srcFilePath);
        if(!srcFile.exists()) {
            System.out.println("源文件不存在");
            return ;
        }

        File dstFile = new File(dstFilePath);
        if(!dstFile.exists()) {
            dstFile.createNewFile();
        }

        FileInputStream inputStream = new FileInputStream(srcFile);
        FileOutputStream outputStream = new FileOutputStream(dstFile);
        FileChannel readChannel = inputStream.getChannel();
        FileChannel writeChannel = outputStream.getChannel();

        long total = srcFile.length();
        long copy = 0;
        ByteBuffer buffer = ByteBuffer.allocate(8192);
        long start = System.currentTimeMillis();
        while (true) {
            int end = readChannel.read(buffer);
            copy += end;
            if(end == -1) {
                break;
            }

            buffer.flip();
            writeChannel.write(buffer);
            buffer.clear();

            System.out.println("正在复制文件...(" + copy + "/" + total + ")");
        }

        System.out.println("Copy Time: " + (System.currentTimeMillis() - start) + "ms");
        inputStream.close();
        outputStream.close();
        readChannel.close();
        writeChannel.close();
    }

    private List<String> getData(int lines) {
        List<String> list = new ArrayList<>();

        if(lines <= 0) {
            return list;
        }

        String string = "这是一句测试的话";
        for(int i = 0; i < lines; i++) {
            list.add(string + i + "\r\n");
        }

        return list;
    }
}
