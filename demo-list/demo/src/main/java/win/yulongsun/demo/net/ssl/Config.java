package win.yulongsun.demo.net.ssl;

/**
 * @author Sun.Yulong on 2017/9/5.
 */
public interface Config {
    interface Client {
        //私钥库路径
        String privateKeystorePath = "d:/sylclient.keystore";
        //私钥库密码
        String privateKeystorePwd  = "sylclientstorepwd";
        //私钥密码
        String privateKeyPwd       = "sylclientkeypwd";
        //证书路径
        String cerPath             = "d:/sylclienttrust.keystore";
        //证书密码
        String cerPwd              = "sylclienttrustpwd";
    }

    interface Server {
        //私钥库路径
        String privateKeystorePath = "d:/sylserver.keystore";
        //私钥库密码
        String privateKeystorePwd  = "sylserverstorepwd";
        //私钥密码
        String privateKeyPwd       = "sylserverkeypwd";
        //证书路径
        String cerPath             = "d:/sylservertrust.keystore";
        //证书密码
        String cerPwd              = "sylservertrustpwd";
    }
}
