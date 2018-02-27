package win.yulongsun.demo.springboot.netty4;

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
@Qualifier("serverHandler")
@ChannelHandler.Sharable
public class MessageHandler extends MessageToMessageCodec<String, String> {
    protected void encode(ChannelHandlerContext ctx, String msg, List<Object> out) throws Exception {
        System.out.println("encode:" + msg);
    }

    protected void decode(ChannelHandlerContext ctx, String msg, List<Object> out) throws Exception {
        System.out.println("decode:" + msg);
        ctx.write("hah");
        ctx.fireChannelInactive();
    }
}
