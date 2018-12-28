package win.yulongsun.demo.net.netty.codec.javaserializable;

import java.io.Serializable;
import java.nio.ByteBuffer;

/**
 * @author Sun.Yulong on 2017/8/28.
 */
public class UserInfo implements Serializable {

    private String userName;

    private int userID;


    public UserInfo buildUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserInfo buildUserID(int userID) {
        this.userID = userID;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    //二进制编码
    public byte[] codec() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        byte[]     value  = this.userName.getBytes();
        buffer.putInt(value.length);
        buffer.put(value);
        buffer.putInt(this.userID);
        buffer.flip();
        //
        byte[] result = new byte[buffer.remaining()];
        buffer.get(result);
        return result;
    }

    //二进制编码
    public byte[] codec(ByteBuffer buffer) {
        buffer.clear();
        byte[] value = this.userName.getBytes();
        buffer.putInt(value.length);
        buffer.put(value);
        buffer.putInt(this.userID);
        buffer.flip();
        //
        byte[] result = new byte[buffer.remaining()];
        buffer.get(result);
        return result;
    }
}
