package win.yulongsun.demo.net.netty.protocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * @author Sun.Yulong on 2017/8/28.
 */
public class NettyMessageEncoder extends MessageToMessageEncoder<NettyMessage> {
    protected void encode(ChannelHandlerContext ctx, NettyMessage msg, List<Object> out) throws Exception {

    }
}
