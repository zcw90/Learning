package zcw.com.basic.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.net.ssl.SSLSocket;

/**
 * Created by 朱城委 on 2019/8/21.<br><br>
 */
public class ClientConnection implements Runnable {
    private Socket clientSocket = null;

    public ClientConnection(SSLSocket sslsocket) {
        clientSocket = sslsocket;
    }

    public void run() {
        BufferedReader reader = null;
        // 将接收到的来自客户端的文字打印出来
        try {
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    System.out.println("Communication end.");
                    break;
                }
                System.out.println("Receive message: " + line);
            }
            reader.close();
            clientSocket.close();
        } catch (IOException ioExp) {
            ioExp.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
