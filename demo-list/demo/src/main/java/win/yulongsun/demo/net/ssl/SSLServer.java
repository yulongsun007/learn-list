package win.yulongsun.demo.net.ssl;

import com.sun.net.httpserver.*;
import com.sun.net.httpserver.spi.HttpServerProvider;

import javax.net.ssl.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.security.SecureRandom;

/**
 * 1、Https通讯过程
 *          Client                      Server
 *          |       1.say hello            |
 *          |----------------------------->|
 *          |                              |
 *          |  2. 获取 server public key    |
 *          |<-----------------------------|
 *          |                              |
 *          | 3.使用server Public Key加密随机数，并携带client public key.
 *          | ---------------------------->|
 *          |                              |
 *          | 4. server通过client public key加密发送给client
 *          |<-----------------------------|
 *          |                              |
 *
 *
 * SSL握手五步：
 * 1. Client向Server发出加密通讯请求.Client给出[协议版本号、客户端随机数(Client random)、客户端支持的加密方法]
 *
 * 2. Server确认双方使用的加密算法，并给出数字证书、以及一个服务器端随机数(Server random).
 *
 * 3. Client确认数字证书有效，然后生成一个新的随机数(Pre-master secret),并使用证书中的公钥，加密这个随机数，发送给Server.
 *
 * 4. Server使用自己的私钥，解密Client发过来的随机数(即Pre-master secret).
 *
 * 5. Client和Server根据约定的加密算法，使用前面三个随机数，生成"对话密钥"(session key),用来加密接下来的整个对话过程.
 * <p>
 * <p>
 * -------------------------
 * 2、关键类：
 * KeyStore: 加载keystore. 需要keystore的密码.
 * KeyManagerFactory: 加载key. 需要key的密码.
 * TrustManagerFactory：加载证书. 不需要密码.
 * SSLContext：设置ssl
 * HttpsConfigurator:
 *
 *
 * @author Sun.Yulong on 2017/9/4.
 */
public class SSLServer {

    private static final int PORT             = 8888;
    private static final int PARALLEL_REQ_NUM = 20;//并发请求数

    public static void main(String[] args) throws Exception {
        doStartServer();
    }

    /**1、加载私钥
     * 2、加载证书
     * 3、SSL上下文初始化
     * 4、配置路径，启动服务
     * @throws Exception
     */
    private static void doStartServer() throws Exception {
        //1.
        // 加载私钥keyStore
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream(Config.Server.privateKeystorePath), Config.Server.privateKeystorePwd.toCharArray());
        // 秘钥初始化
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
        keyManagerFactory.init(keyStore, Config.Server.privateKeyPwd.toCharArray());
        // TODO: 2017/9/5 多个key
        //2.
        // 加载证书keystore
        keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream(Config.Server.cerPath), Config.Server.cerPwd.toCharArray());
        // 证书初始化
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
        trustManagerFactory.init(keyStore);     // 证书初始化不需要密码
        //3.
        // SSLContext初始化
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());//秘钥管理器、证书管理器、随机数
        //
        HttpsConfigurator conf = new HttpsConfigurator(sslContext) {
            @Override
            public void configure(HttpsParameters httpsParameters) {
                // super.configure(httpsParameters);
                SSLParameters defaultSSLParameters = this.getSSLContext().getDefaultSSLParameters();
                //设置认证client要求
                defaultSSLParameters.setNeedClientAuth(false);
                //
                httpsParameters.setSSLParameters(defaultSSLParameters);
            }
        };
        //
        HttpServerProvider serverProvider = HttpServerProvider.provider();
        HttpsServer        httpServer     = serverProvider.createHttpsServer(new InetSocketAddress(PORT), PARALLEL_REQ_NUM);
        httpServer.setHttpsConfigurator(conf);
        httpServer.createContext("/test", new HttpServerHandler()); //https://127.0.0.1:8888/test
        httpServer.setExecutor(null);
        httpServer.start();
        System.out.println("server start");
    }

    static class HttpServerHandler implements HttpHandler {

        public void handle(HttpExchange httpExchange) throws IOException {
            // 接受客户端信息
            InputStream    requestBody = httpExchange.getRequestBody();
            BufferedReader reader      = new BufferedReader(new InputStreamReader(requestBody));
            String         line        = "";
            StringBuffer   buffer      = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            String reqStr = buffer.toString();
            System.out.println("Received From Client is :" + reqStr);
            requestBody.close();
            // 返回消息给服务器端
            byte[] respByte = "Server has Received".getBytes();
            httpExchange.sendResponseHeaders(HttpsURLConnection.HTTP_OK, respByte.length);
            OutputStream responseBody = httpExchange.getResponseBody();
            responseBody.write(respByte);
            responseBody.flush();
            responseBody.close();
        }
    }
}
