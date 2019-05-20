package win.yulongsun.demo.spring.core.jdk;

import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Sun.YuLong on 2018/4/19.
 */
public class JdkProxyTest {

    @Test
    public void testCreateClass() throws IOException {
        JdkClass clazz = new JdkClass();
        generateClassFile(clazz.getClass(), "JdkProxy");

    }


    public void generateClassFile(Class clazz, String proxyName) throws IOException {
        byte[] clazzFile = ProxyGenerator.generateProxyClass(proxyName, clazz.getInterfaces());
        String path      = clazz.getResource(".").getPath();
        System.out.println("path::" + path);
        FileOutputStream fileOutputStream = new FileOutputStream(path + proxyName + ".class");
        fileOutputStream.write(clazzFile);
        fileOutputStream.close();
    }
}
