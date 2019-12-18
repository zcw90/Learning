package zcw.com.basic.socket;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * Created by 朱城委 on 2019/8/26.<br><br>
 */
public class SocketDemo {

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException {
        X509TrustManager x509TrustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };

        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new TrustManager[] { x509TrustManager }, null);

        try {
//            Socket socket = new Socket("127.0.0.1", 8888);
//            SSLSocket sslSocket = (SSLSocket) sslContext.getSocketFactory().createSocket("www.baidu.com", 80);

            Socket sslSocket = new Socket("www.baidu.com", 80);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(sslSocket.getOutputStream()));
            writer.write("GET / HTTP/1.1\r\n");
            writer.write("Host: www.baidu.com\r\n");
            writer.write("\r\n");
            writer.flush();

            InputStream inputStream = sslSocket.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

            byte[] buffer = new byte[1024];
            int count = 0;
            while ((count = bufferedInputStream.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, count, "UTF-8"));
            }

            bufferedInputStream.close();
            writer.close();
            sslSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
