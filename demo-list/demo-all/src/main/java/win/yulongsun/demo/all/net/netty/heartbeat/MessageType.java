package win.yulongsun.demo.all.net.netty.heartbeat;

/**
 * @author Sun.Yulong on 2017/8/28.
 */
public enum MessageType {
    BIZ_REQ((byte) 0),          //业务请求消息
    BIZ_RESP((byte) 1),         //业务响应消息

    ONE_WAY((byte) 2),          //业务ONE_WAY消息(既是发送消息,又是响应消息)

    LOGIN_REQ((byte) 3),        //握手请求消息
    LOGIN_RESP((byte) 4),       //握手响应消息

    HEARTBEAT_REQ((byte) 5),    //心跳请求消息
    HEARTBEAT_RESP((byte) 6);    //心跳响应消息

    private final byte value;

    MessageType(byte value) {
        this.value = value;
    }


    public byte value() {
        return this.value;
    }
}
