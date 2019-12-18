package zcw.com.basic.socket2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 朱城委 on 2019/8/21.<br><br>
 */
public class Server1 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while(true) {
                Socket socket = serverSocket.accept();
                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

                dataOutputStream.writeUTF("你好，客户端地址信息：" + socket.getInetAddress() +
                    "\t客户端通信端口：" + socket.getPort());
                dataOutputStream.writeUTF("i'm a server ,my name is hongten！");

                dataOutputStream.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
