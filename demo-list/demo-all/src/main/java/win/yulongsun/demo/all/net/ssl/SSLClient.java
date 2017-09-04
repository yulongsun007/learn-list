package win.yulongsun.demo.all.net.ssl;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;

/**
 * @author Sun.Yulong on 2017/9/4.
 */
public class SSLClient {

    public static void main(String[] args) {

//        doPost();

    }

    private static void doPost(String urlStr, String port) throws Exception {
        URL                url           = new URL(urlStr);
        HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
        //
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
        KeyStore          keyStore          = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream(""), "".toCharArray());   //私钥
        //
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
        keyStore.load(new FileInputStream(""), "".toCharArray());   //证书
        trustManagerFactory.init(keyStore);
        //
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());
        //
        urlConnection.setSSLSocketFactory(context.getSocketFactory());
    }
}
