package win.yulongsun.demo.middleware.netty5.heartbeat.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * @author Sun.Yulong on 2017/8/28.
 */
public class SimpleMessageEncoder extends MessageToMessageEncoder<SimpleMessage> {
    protected void encode(ChannelHandlerContext ctx, SimpleMessage msg, List<Object> out) throws Exception {

    }
}
