package zcw.com.basic.socket2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 朱城委 on 2019/8/21.<br><br>
 */
public class Client3 {
    private static AtomicInteger INDEX = new AtomicInteger(1);

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);

            // 输出流
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            // 输入流
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            new ClientWrite(dataOutputStream, INDEX.getAndIncrement()).start();
            new ClientRead(dataInputStream).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientRead extends Thread {
        private DataInputStream inputStream;

        public ClientRead(DataInputStream inputStream) {
            this.inputStream = inputStream;
        }

        @Override
        public void run() {
            String info;

            try {
                while (true) {
                    info = inputStream.readUTF();
                    System.out.println("服务端说：" + info);
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

    static class ClientWrite extends Thread {
        private DataOutputStream outputStream;
        private int id;

        public ClientWrite(DataOutputStream outputStream, int id) {
            this.outputStream = outputStream;
            this.id = id;
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
                    outputStream.writeUTF(id + "-" + info);
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
