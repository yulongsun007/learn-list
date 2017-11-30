package win.yulongsun.demo.heartbeat.codec.marshalling;

import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.Marshaller;

/**
 * 编码
 *
 * @author Sun.Yulong on 2017/8/29.
 */
public class SimpleMarshallingEncoder {

    private static final byte[] LENGTH_PLACEHOLDER = new byte[4];
    Marshaller marshaller;

    public SimpleMarshallingEncoder(Marshaller marshaller) {
//        this.marshaller = MarshallingCodecFactory.buildMarshalling();
    }

    protected void encode(Object msg, ByteBuf out) {
        int lengthPosi = out.writerIndex();
        out.writeBytes(LENGTH_PLACEHOLDER);
//        new ChannelBufferByteOutput(out);
    }

}
