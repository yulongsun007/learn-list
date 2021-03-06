package win.yulongsun.demo.all.net.netty.protocol;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息头
 *
 * @author Sun.Yulong on 2017/8/28.
 */
public class Header {
    private int  length;//消息长度
    private long sessionID;//会话ID
    private byte type;//消息类型
    private byte priority;//消息优先级
    private Map<String, Object> attachment = new HashMap<String, Object>();//附件

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public long getSessionID() {
        return sessionID;
    }

    public void setSessionID(long sessionID) {
        this.sessionID = sessionID;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte getPriority() {
        return priority;
    }

    public void setPriority(byte priority) {
        this.priority = priority;
    }
}
