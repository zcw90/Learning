package zcw.com.basic.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
 * Created by 朱城委 on 2019/8/21.<br><br>
 */
public class Client {
    // 定义要连接的服务器名和端口号
    private static final int DEFAULT_PORT = 54321;
    private static final String DEFAULT_HOST = "localhost";

    public static void main(String args[]) {
        SSLSocket socket = null;
        // 使用默认的方式获取工厂实例
        SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try {
            // 连接服务端的端口，完成握手过程
            socket = (SSLSocket) sf.createSocket(DEFAULT_HOST, DEFAULT_PORT);
            socket.startHandshake();
            System.out.println("Connected to " + DEFAULT_HOST + ":" + DEFAULT_PORT + " !");
            // 从控制台输入要发送给服务端的文字
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Writer writer = new OutputStreamWriter(socket.getOutputStream());
            // 可以反复向服务端发送消息
            boolean done = false;
            while (!done) {
                System.out.print("Send Message: ");
                String line = reader.readLine();
                if (line != null) {
                    writer.write(line + "\n");
                    writer.flush();
                } else {
                    done = true;
                }
            }
            socket.close();
        } catch (Exception e) {
            System.out.println("Connection failed: " + e);
            try {
                socket.close();
            } catch (IOException ioe) {
            }
            socket = null;
        }
    }
}
