package win.yulongsun.demo.net.netty.protocol;

/**
 * 自定义数据结构
 *
 * @author Sun.Yulong on 2017/8/28.
 */
public class NettyMessage {

    private Header header;
    private Object body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
