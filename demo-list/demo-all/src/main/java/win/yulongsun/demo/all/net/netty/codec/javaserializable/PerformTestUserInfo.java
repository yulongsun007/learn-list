package win.yulongsun.demo.all.net.netty.codec.javaserializable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

/**
 * 序列化性能测试
 *
 * @author Sun.Yulong on 2017/8/28.
 */
public class PerformTestUserInfo {


    public static void main(String[] args) throws IOException {
        int      count = 100 * 10000;   //100w
        UserInfo info  = new UserInfo();
        info.buildUserID(100).buildUserName("Sun.Yulong");
        // java serializable
        long                  startTime = System.currentTimeMillis();
        ByteArrayOutputStream bos       = new ByteArrayOutputStream();
        ObjectOutputStream    oos       = new ObjectOutputStream(bos);
        for (int i = 0; i < count; i++) {
            oos.writeObject(info);
            oos.flush();
            oos.close();
            bos.close();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("jdk序列化时间 = " + (endTime - startTime) + "ms");
        System.out.println("===========================");
        // byte array serializable
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            info.codec(buffer);
        }
        endTime = System.currentTimeMillis();
        System.out.println("二进制序列化时间 =" + (endTime - startTime) + "ms");
    }
}
