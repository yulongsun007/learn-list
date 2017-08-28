package win.yulongsun.demo.all.net.netty.protocol;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;


/**
 * LengthFieldBasedFrameDecoder支持TCP的半包和粘包处理.
 *
 * @author Sun.Yulong on 2017/8/28.
 */
public class NettyMessageDecoder extends LengthFieldBasedFrameDecoder {
    public NettyMessageDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength);
    }

}
