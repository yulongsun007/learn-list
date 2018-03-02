package win.yulongsun.demo.springboot.netty4;

/**
 * @author Sun.YuLong on 2018/3/2.
 */
public class Message {
    String head;
    String body;

    public Message(String head, String body) {
        this.head = head;
        this.body = body;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Message{" +
                "head='" + head + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
