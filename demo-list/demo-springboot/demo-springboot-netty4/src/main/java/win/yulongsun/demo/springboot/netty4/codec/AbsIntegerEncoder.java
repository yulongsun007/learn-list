package win.yulongsun.demo.springboot.netty4.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 计算绝对值
 * @author Sun.YuLong on 2018/2/28.
 */
@Component
@ChannelHandler.Sharable
public class AbsIntegerEncoder extends MessageToMessageEncoder<ByteBuf> {

    @Override
    protected void encode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        while (msg.readableBytes() >=4) {
            int value = Math.abs(msg.readInt());
            out.add(value);
        }
    }
}
