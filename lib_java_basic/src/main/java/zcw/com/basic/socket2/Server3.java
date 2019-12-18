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
public class Server3 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();

            // 输出流
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            // 输入流
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            new ServerRead(dataInputStream).start();
            new ServerWrite(dataOutputStream).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ServerRead extends Thread {
        private DataInputStream inputStream;

        public ServerRead(DataInputStream inputStream) {
            this.inputStream = inputStream;
        }

        @Override
        public void run() {
            String info;

            try {
                while (true) {
                    info = inputStream.readUTF();
                    System.out.println("客户端说：" + info);
                    if(info.equals("bye")) {
                        System.out.println("对方下线，退出程序。");
                        System.exit(0);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class ServerWrite extends Thread {
        private DataOutputStream outputStream;

        public ServerWrite(DataOutputStream outputStream) {
            this.outputStream = outputStream;
        }

        @Override
        public void run() {
            String info;

            // 读取键盘
            InputStreamReader streamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            try {
                while (true) {
                    info = bufferedReader.readLine();
                    outputStream.writeUTF(info);
                    if(info.equals("bye")) {
                        System.out.println("自己下线，退出程序。");
                        System.exit(0);
                    }
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
