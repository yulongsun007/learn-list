package win.yulongsun.demo.springboot.netty4.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.util.CharsetUtil;

import java.nio.ByteOrder;


/**
 * @author Sun.YuLong on 2018/2/28.
 */
public class MyLengthFieldBasedFrameDecoder extends LengthFieldBasedFrameDecoder {

    public static final String DEFAULT_CHARSET = "GBK";

    public MyLengthFieldBasedFrameDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength);
    }


    public MyLengthFieldBasedFrameDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip) {
        super( maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip);
    }
    /**
     * @param byteOrder           默认大端序
     * @param maxFrameLength      每个帧数据的最大长度
     * @param lengthFieldOffset   长度字段偏移位置
     * @param lengthFieldLength   长度字段长度
     * @param lengthAdjustment    修改长度字段中定义的值
     * @param initialBytesToStrip 解析时要跳过的字节数
     * @param failFast            默认为true 当frame长度超过maxFrameLength时立即抛出TooLongFrameException。false为读取完成之后才抛出异常
     */
    public MyLengthFieldBasedFrameDecoder(ByteOrder byteOrder, int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip, boolean failFast) {
        super(byteOrder, maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {

//        int     length   = in.readByte();
//        System.out.println(length);
        byte[] lengthByte = new byte[4];
        in.readBytes(lengthByte);
        String length = new String(lengthByte, DEFAULT_CHARSET);
        //
        byte[] bytes = new byte[in.readableBytes()];
        in.readBytes(bytes);
        String gbk = new String(bytes, DEFAULT_CHARSET);
        return super.decode(ctx, in);

    }

    @Override
    protected long getUnadjustedFrameLength(ByteBuf buf, int offset, int length, ByteOrder order) {
        return super.getUnadjustedFrameLength(buf, offset, length, order);
    }
}
