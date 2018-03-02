package win.yulongsun.demo.springboot.netty4.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author Sun.YuLong on 2018/3/2.
 */
public class MySimpleChannelInboundHandler extends SimpleChannelInboundHandler<Object> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) {
        System.out.println(msg.toString());
    }
}
