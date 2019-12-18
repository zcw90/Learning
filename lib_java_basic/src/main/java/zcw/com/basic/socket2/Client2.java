package zcw.com.basic.socket2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 朱城委 on 2019/8/21.<br><br>
 */
public class Client2 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);

            // 输出流
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            // 输入流
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            // 读取键盘
            InputStreamReader streamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(streamReader);

            String info;
            while(true) {
                info = bufferedReader.readLine();
                dataOutputStream.writeUTF(info);
                if(info.equalsIgnoreCase("bye")) {
                    break;
                }

                info = dataInputStream.readUTF();
                System.out.println("服务端说：" + info);
                if(info.equalsIgnoreCase("bye")) {
                    break;
                }
            }

            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
