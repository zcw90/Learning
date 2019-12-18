package zcw.com.basic.socket;

import java.io.IOException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

/**
 * Created by 朱城委 on 2019/8/21.<br><br>
 */
public class Server {
    // 定义了监听端口号
    private final static int LISTEN_PORT=54321;

    public static void main(String args[]) throws IOException {
        SSLServerSocket serverSocket=null;
        SSLSocket clientSocket=null;
        // 使用默认方式获取套接字工厂实例
        SSLServerSocketFactory ssf=(SSLServerSocketFactory)SSLServerSocketFactory.getDefault();

        try{
            serverSocket=(SSLServerSocket)ssf.createServerSocket(LISTEN_PORT);
            // 设置不需要验证客户端身份
            serverSocket.setNeedClientAuth(false);
            System.out.println("SSLServer is listening on "+LISTEN_PORT+" port");
            // 循环监听端口，如果有客户端连入就新开一个线程与之通信
            while(true){
                // 接受新的客户端连接
                clientSocket=(SSLSocket)serverSocket.accept();
                ClientConnection clientConnection=new ClientConnection(clientSocket);
                // 启动一个新的线程
                Thread clientThread=new Thread(clientConnection);
                System.out.println("Client "+clientThread.getId()+" is connected");
                clientThread.run();
            }
        }catch(IOException ioExp){
            ioExp.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            serverSocket.close();
        }
    }
}
