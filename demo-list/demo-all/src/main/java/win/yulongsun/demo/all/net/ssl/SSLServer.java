package win.yulongsun.demo.all.net.ssl;

import com.sun.net.httpserver.*;
import com.sun.net.httpserver.spi.HttpServerProvider;

import javax.net.ssl.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.security.SecureRandom;

/**
 * Https通讯过程
 *          Client                      Server
 *          |       1.say hello            |
 *          |----------------------------->|
 *          |                              |
 *          |  2. 获取 server public key    |
 *          |<-----------------------------|
 *          |                              |
 *          | 3.使用server Public Key加密，并携带client public key.
 *          | ---------------------------->|
 *          |                              |
 *          | 4. server通过client public key加密发送给client
 *          |<-----------------------------|
 *          |                              |
 *
 * 1. client向server发出加密通讯请求.
 *
 * 2.
 *
 *
 * -------------------------
 * 1、关键类：
 * KeyStore:
 * KeyManagerFactory:
 *
 * @author Sun.Yulong on 2017/9/4.
 */
public class SSLServer {

    private static final int PORT = 8888;

    public static void main(String[] args) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("d:/keystore/cebunionpayclient.keystore"), "Client123456".toCharArray());
        // 秘钥初始化
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
        keyManagerFactory.init(keyStore, "Client123456".toCharArray());
        KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();      //秘钥管理器
        // 证书初始化
        keyStore = KeyStore.getInstance("JKS");
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
        trustManagerFactory.init(keyStore);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();  //证书管理器
        // SSLContext初始化
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagers, trustManagers, new SecureRandom());
        //
        HttpsConfigurator conf = new HttpsConfigurator(sslContext) {
            @Override
            public void configure(HttpsParameters httpsParameters) {
//                super.configure(httpsParameters);
                SSLParameters defaultSSLParameters = this.getSSLContext().getDefaultSSLParameters();
                //设置认证client要求
                defaultSSLParameters.setNeedClientAuth(false);
                //
                httpsParameters.setSSLParameters(defaultSSLParameters);
            }
        };
        //
        HttpServerProvider serverProvider = HttpServerProvider.provider();
        HttpsServer        httpServer     = serverProvider.createHttpsServer(new InetSocketAddress(PORT), 20);//todo
        httpServer.setHttpsConfigurator(conf);
        httpServer.createContext("/test", new HttpServerHandler());
        httpServer.setExecutor(null);
        httpServer.start();
    }

    static class HttpServerHandler implements HttpHandler {

        public void handle(HttpExchange httpExchange) throws IOException {
            InputStream    requestBody = httpExchange.getRequestBody();
            BufferedReader reader      = new BufferedReader(new InputStreamReader(requestBody));
            String         line        = "";
            StringBuffer   buffer      = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            String reqStr = buffer.toString();
            System.out.println("Received Client :" + reqStr);
            requestBody.close();
            //
            OutputStream responseBody = httpExchange.getResponseBody();
            responseBody.write("Server has Received".getBytes());
            responseBody.flush();
            responseBody.close();
        }
    }
}
