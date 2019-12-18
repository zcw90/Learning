package zcw.com.basic.stream.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by 朱城委 on 2019/8/23.<br><br>
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        Test2 test = new Test2();

//        test.copyFileByDirectBuffer("D:/IT/专业电子书/深入理解计算机系统_第3版.pdf", "E:/深入理解计算机系统_第3版2.pdf");
//        test.copyFileByDirectBuffer2("D:/IT/专业电子书/深入理解计算机系统_第3版.pdf", "E:/深入理解计算机系统_第3版2.pdf");
//        test.copyFileByDirectBuffer("D:/软件/win10-64-zyb.iso", "E:/win10-64-zyb.iso");
//        test.copyFileByDirectBuffer2("D:/软件/win10-64-zyb.iso", "E:/win10-64-zyb.iso");
        test.copyFileByDirectBuffer3("D:/软件/win10-64-zyb.iso", "E:/win10-64-zyb.iso");
    }

    /**
     * 使用直接缓冲区复制文件，使用{@link ByteBuffer#allocateDirect(int)}。
     * @param srcFilePath 源文件
     * @param dstFilePath 目标文件
     * @throws IOException
     */
    private void copyFileByDirectBuffer(String srcFilePath, String dstFilePath) throws IOException {
        File srcFile = new File(srcFilePath);
        if(!srcFile.exists()) {
            System.out.println("源文件不存在");
            return ;
        }

        File dstFile = new File(dstFilePath);
        if(!dstFile.exists()) {
            dstFile.createNewFile();
        }

        // 获取通道
        FileInputStream inputStream = new FileInputStream(srcFile);
        FileOutputStream outputStream = new FileOutputStream(dstFile);
        FileChannel readChannel = inputStream.getChannel();
        FileChannel writeChannel = outputStream.getChannel();

        // 创建直接缓冲区
        ByteBuffer buffer = ByteBuffer.allocateDirect(8192);

        long total = srcFile.length();
        long copy = 0;
        long start = System.currentTimeMillis();
        while (true) {
            int end = readChannel.read(buffer);
            copy += end;
            if(end == -1) {
                break;
            }

            // 切换到写模式
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

    /**
     * 使用直接缓冲区复制文件，使用{@link MappedByteBuffer}，超过2G的文件会复制失败。
     * @param srcFilePath 源文件
     * @param dstFilePath 目标文件
     * @throws IOException
     */
    private void copyFileByDirectBuffer2(String srcFilePath, String dstFilePath) throws IOException {
        File srcFile = new File(srcFilePath);
        if(!srcFile.exists()) {
            System.out.println("源文件不存在");
            return ;
        }

        File dstFile = new File(dstFilePath);
        if(!dstFile.exists()) {
            dstFile.createNewFile();
        }

        // 获取通道
        FileChannel readChannel = FileChannel.open(Paths.get(srcFilePath), StandardOpenOption.READ);
        FileChannel writeChannel = FileChannel.open(Paths.get(dstFilePath), StandardOpenOption.READ, StandardOpenOption.WRITE);

        // 内存映射文件
        int size = 1024 * 1024;
        MappedByteBuffer inMapBuffer = readChannel.map(MapMode.READ_ONLY, 0, size);
        MappedByteBuffer outMapBuffer = writeChannel.map(MapMode.READ_WRITE, 0, size);

        byte[] buffer = new byte[size];
        long copy = 0;

        long start = System.currentTimeMillis();
        while (inMapBuffer.hasRemaining()) {
            int length = inMapBuffer.remaining() > size ? size : inMapBuffer.remaining();
            copy += length;

            System.out.println("已经复制：" + (copy / 1024) + "Kb");
            inMapBuffer.get(buffer, 0, length);
            outMapBuffer.put(buffer, 0, length);
        }
        System.out.println("Copy Time: " + (System.currentTimeMillis() - start) + "ms");

        readChannel.close();
        writeChannel.close();
    }

    /**
     * 使用直接缓冲区复制文件，使用{@link FileChannel}。
     * @param srcFilePath 源文件
     * @param dstFilePath 目标文件
     * @throws IOException
     */
    private void copyFileByDirectBuffer3(String srcFilePath, String dstFilePath) throws IOException {
        File srcFile = new File(srcFilePath);
        if(!srcFile.exists()) {
            System.out.println("源文件不存在");
            return ;
        }

        File dstFile = new File(dstFilePath);
        if(!dstFile.exists()) {
            dstFile.createNewFile();
        }

        // 获取通道
        FileChannel readChannel = FileChannel.open(Paths.get(srcFilePath), StandardOpenOption.READ);
        FileChannel writeChannel = FileChannel.open(Paths.get(dstFilePath), StandardOpenOption.READ, StandardOpenOption.WRITE);

        long position = 0;
        long size = readChannel.size();
        long start = System.currentTimeMillis();
        while(size > 0) {
            long count = readChannel.transferTo(position, size, writeChannel);
            if(count > 0) {
                position += count;
                size -= count;
            }
        }
        System.out.println("Copy Time: " + (System.currentTimeMillis() - start) + "ms");

        readChannel.close();
        writeChannel.close();
    }
}
