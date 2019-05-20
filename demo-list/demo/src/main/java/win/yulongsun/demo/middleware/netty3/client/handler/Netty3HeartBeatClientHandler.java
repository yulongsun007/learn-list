package win.yulongsun.demo.middleware.netty3.client.handler;

import org.jboss.netty.channel.*;

/**
 * @author Sun.YuLong on 2017/11/30.
 */
public class Netty3HeartBeatClientHandler extends SimpleChannelHandler {

    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        super.channelConnected(ctx, e);
        System.out.println("client::channelConnected");
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        super.messageReceived(ctx, e);
        ctx.getChannel().write("client say hello");
        System.out.println("client::messageReceived");
    }
}
