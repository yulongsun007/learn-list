package win.yulongsun.demo.heartbeat.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;


/**
 * LengthFieldBasedFrameDecoder支持TCP的半包和粘包处理.
 *
 * @author Sun.Yulong on 2017/8/28.
 */
public class SimpleMessageDecoder extends LengthFieldBasedFrameDecoder {
    public SimpleMessageDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength);
    }

//    @Override
//    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
//        ByteBuf frame = (ByteBuf) super.decode(ctx, in);
//    }
}
