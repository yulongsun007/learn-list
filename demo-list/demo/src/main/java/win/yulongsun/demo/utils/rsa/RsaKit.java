package win.yulongsun.demo.utils.rsa;


import com.sun.xml.internal.messaging.saaj.util.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by yulongsun on 2016/4/25.
 */
public class RsaKit {

    private static final String DEFAULT_ENCODE = "UTF-8";
    private static RSAPublicKey  rsaPublicKey;
    private static RSAPrivateKey rsaPrivateKey;
    private static KeyFactory    keyFactory;
    private static Cipher        cipher;

    public static void main(String[] args) throws Exception {
    }

    public RsaKit() {
        //1. 初始化密钥
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(512);
            KeyPair keyPair = keyPairGenerator.generateKeyPair(); //Pair:对
            //
            rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
            System.out.println("Public Key:\n" + Base64.encode(rsaPrivateKey.getEncoded()));
            //
            rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
            System.out.println("Private Key:\n" + Base64.encode(rsaPublicKey.getEncoded()));
            //
            keyFactory = KeyFactory.getInstance("RSA");
            cipher = Cipher.getInstance("RSA");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // 私钥加密,公钥解密
    ///////////////////////////////////////////////////////////////////////////
    // 2.1 私钥加密
    private static String privateKeyEncode(String key) throws Exception {
        long begin = System.nanoTime();
        //
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
        PrivateKey          privateKey          = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        //
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] result = cipher.doFinal(key.getBytes(DEFAULT_ENCODE));
        //
        long   end         = System.nanoTime();
        String finalResult = new String(result, DEFAULT_ENCODE);
        System.out.println(String.format("私钥加密:[%s],用时[%s]ms", finalResult, (end - begin)));
        return finalResult;
    }

    // 2.2 公钥解密
    private static String publicKeyDecode(String value) throws Exception {
        long begin = System.nanoTime();
        //
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
        PublicKey          publicKey          = keyFactory.generatePublic(x509EncodedKeySpec);
        //
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] result = cipher.doFinal(value.getBytes(DEFAULT_ENCODE));
        //
        long   end         = System.nanoTime();
        String finalResult = new String(result, DEFAULT_ENCODE);
        System.out.println(String.format("公钥解密:[%s],用时[%s]ms", finalResult, (end - begin)));
        return finalResult;
    }


    ///////////////////////////////////////////////////////////////////////////
    // 公钥加密，私钥解密
    ///////////////////////////////////////////////////////////////////////////
    // 3.1 公钥加密
    private static String publicKeyEncoder(String key) throws Exception {
        long begin = System.nanoTime();
        //
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
        PublicKey          publicKey1         = keyFactory.generatePublic(x509EncodedKeySpec);
        //
        cipher.init(Cipher.ENCRYPT_MODE, publicKey1);
        byte[] result = cipher.doFinal(key.getBytes());
        //
        long   end         = System.nanoTime();
        String finalResult = new String(result, DEFAULT_ENCODE);
        System.out.println(String.format("公钥加密:[%s],用时[%s]ms", finalResult, (end - begin)));
        return finalResult;
    }

    //3.2 私钥解密
    private static String privateKeyDecode(String value) throws Exception {
        long begin = System.nanoTime();
        //
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
        PrivateKey          privateKey1         = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        //
        cipher.init(Cipher.DECRYPT_MODE, privateKey1);
        byte[] result = cipher.doFinal(value.getBytes(DEFAULT_ENCODE));
        //
        long   end         = System.nanoTime();
        String finalResult = new String(result, DEFAULT_ENCODE);
        System.out.println(String.format("私钥解密:[%s],用时[%s]ms", finalResult, (end - begin)));
        return finalResult;
    }


}
