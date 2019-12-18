package zcw.com.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by 朱城委 on 2019/8/27.<br><br>
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("./Relay2.dat");
        if(!file.exists()) {
            file.createNewFile();
        }

        BufferedReader reader = new BufferedReader(new FileReader("./Relay.dat"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("./Relay2.dat"));

        String result;
        StringBuilder builder = new StringBuilder();
        while ((result = reader.readLine()) != null) {
            for(int i = 0; i < result.length(); i++) {
                char ch = (char) (result.charAt(i) + 14);
                builder.append((char)(result.charAt(i) + 14));
            }

            writer.write(builder.toString() + "\r\n");
            builder.delete(0, builder.length());
        }
        reader.close();
        writer.close();

//        FileInputStream inputStream = new FileInputStream("./Relay.dat");
//        FileOutputStream outputStream = new FileOutputStream("./Relay2.dat");

//        byte[] buffer = new byte[1024];
//        byte value = 14;
//        int count;
//        while ((count = inputStream.read(buffer)) != -1) {
//            for(int i = 0; i < count; i++) {
//                buffer[i] = (byte) (buffer[i] + value);
//            }
//            outputStream.write(buffer, 0, count);
//        }
//
//        inputStream.close();
//        outputStream.close();
    }
}
