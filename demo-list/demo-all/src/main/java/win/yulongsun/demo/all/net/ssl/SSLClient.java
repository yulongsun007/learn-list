package win.yulongsun.demo.all.net.ssl;

import javax.net.ssl.*;
import java.io.*;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;

/**
 * @author Sun.Yulong on 2017/9/4.
 */
public class SSLClient {

    public static void main(String[] args) {

        try {
            String result = doPost("https://127.0.0.1:8888/test", "client say hello");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String doPost(String urlStr, String req) throws Exception {
        URL                url           = new URL(urlStr);
        HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
        //1. 加载私钥
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream(Config.Client.privateKeystorePath), Config.Client.privateKeystorePwd.toCharArray());
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
        keyManagerFactory.init(keyStore, Config.Client.privateKeyPwd.toCharArray());
        // 2. 加载证书
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
        keyStore.load(new FileInputStream(Config.Client.cerPath), Config.Client.cerPwd.toCharArray());
        trustManagerFactory.init(keyStore);
        // 3. 设置SSL
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());
        // 4. 设置相关参数
        urlConnection.setHostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        });
        urlConnection.setSSLSocketFactory(context.getSocketFactory());
        urlConnection.setRequestMethod("POST");
        urlConnection.setDoInput(true);
        urlConnection.setDoOutput(true);
        OutputStream outputStream = urlConnection.getOutputStream();
        outputStream.write(req.getBytes());
        outputStream.flush();
        outputStream.close();
        // 5. 读取结果
        int responseCode = urlConnection.getResponseCode();
        if (responseCode == HttpsURLConnection.HTTP_OK) {
            InputStream    inputStream  = urlConnection.getInputStream();
            BufferedReader reader       = new BufferedReader(new InputStreamReader(inputStream));
            String         line         = null;
            StringBuffer   stringBuffer = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                stringBuffer.append(line);
            }
            System.out.println(stringBuffer.toString());
            return stringBuffer.toString();
        }
        return null;
    }
}
