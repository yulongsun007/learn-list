package win.yulongsun.demo.all.net.netty.codec.javaserializable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**序列化码流大小测试
 *
 * @author Sun.Yulong on 2017/8/28.
 */
public class TestUserInfo {

    public static void main(String[] args) throws IOException {
        UserInfo info = new UserInfo();
        info.buildUserID(100).buildUserName("Sun.Yulong");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream    oos = new ObjectOutputStream(bos);
        oos.writeObject(info);
        oos.flush();
        oos.close();
        byte[] bytes = bos.toByteArray();
        System.out.println("jdk序列化码流长度=" + bytes.length);
        bos.close();
        System.out.println("===========================");
        //
        System.out.println("二进制序列化码流长度=" + info.codec().length);
    }
}
