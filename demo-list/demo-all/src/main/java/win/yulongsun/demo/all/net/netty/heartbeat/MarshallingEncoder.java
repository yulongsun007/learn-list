package win.yulongsun.demo.all.net.netty.heartbeat;

import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.Marshaller;
import win.yulongsun.demo.all.net.netty.codec.marshalling.MarshallingCodecFactory;

/**
 * 编码
 *
 * @author Sun.Yulong on 2017/8/29.
 */
public class MarshallingEncoder {

    private static final byte[] LENGTH_PLACEHOLDER = new byte[4];
    Marshaller marshaller;

    public MarshallingEncoder(Marshaller marshaller) {
//        this.marshaller = MarshallingCodecFactory.buildMarshalling();
    }

    protected void encode(Object msg, ByteBuf out) {
        int lengthPosi = out.writerIndex();
        out.writeBytes(LENGTH_PLACEHOLDER);
//        new ChannelBufferByteOutput(out);
    }

}
