package win.yulongsun.demo.middleware.netty3.server.handler;

import org.jboss.netty.channel.*;
import org.jboss.netty.handler.timeout.IdleState;
import org.jboss.netty.handler.timeout.IdleStateEvent;

/**
 * @author Sun.YuLong .
 */
public class Netty3HeartBeatServerHandler extends SimpleChannelHandler {
    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        System.out.println("server::messageReceived::" + e.getMessage());
        super.messageReceived(ctx, e);
    }

    @Override
    public void handleUpstream(final ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
        if (e instanceof IdleStateEvent && ((IdleStateEvent) e).getState() == IdleState.ALL_IDLE) {
            ChannelFuture channelFuture = ctx.getChannel().write("timer out, you will close");
            channelFuture.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    ctx.getChannel().close();
                }
            });
        } else {
            super.handleUpstream(ctx, e);
        }
    }
}
