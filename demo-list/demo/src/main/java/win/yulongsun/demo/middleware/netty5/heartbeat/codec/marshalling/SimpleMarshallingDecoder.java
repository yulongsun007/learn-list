package win.yulongsun.demo.middleware.netty5.heartbeat.codec.marshalling;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.marshalling.MarshallingDecoder;
import win.yulongsun.demo.middleware.netty5.marshalling.MarshallingCodecFactory;

/**
 * @author Sun.Yulong on 2017/8/29.
 */
public class SimpleMarshallingDecoder {


    private final MarshallingDecoder marshallingDecoder;

    public SimpleMarshallingDecoder() {
        marshallingDecoder = MarshallingCodecFactory.buildMarshallingDecoder();
    }


    protected Object decode(ByteBuf byteBuf) {
        int objSize = byteBuf.readInt();
        ByteBuf buf = byteBuf.slice(byteBuf.readerIndex(), objSize);
//        new ChannelBufferByteInput(buf);
        return null;
    }

}
