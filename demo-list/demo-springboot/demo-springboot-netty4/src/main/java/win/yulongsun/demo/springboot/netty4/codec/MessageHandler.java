package win.yulongsun.demo.springboot.netty4.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Sun.YuLong on 2018/2/24.
 */
@Component
@ChannelHandler.Sharable
public class MessageHandler extends MessageToMessageCodec<ByteBuf, ByteBuf> {
    protected void encode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        System.out.println("encode:" + msg);
        out.add("encoder");

    }

    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        out.add(msg);
        System.out.println("decode:" + msg);
    }
}
