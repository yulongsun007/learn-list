package win.yulongsun.demo.net.netty.heartbeat;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import win.yulongsun.demo.net.netty.protocol.Header;
import win.yulongsun.demo.net.netty.protocol.NettyMessage;

import java.util.concurrent.TimeUnit;

/**
 * 心跳消息的目的是:检测链路的可用性,因此不需要携带消息体
 *
 * @author Sun.Yulong on 2017/8/28.
 */
public class HeartBeatReqHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        NettyMessage message = (NettyMessage) msg;
        if (message.getHeader() != null && message.getHeader().getType() == MessageType.LOGIN_RESP.value()) {
            // TODO: 2017/8/28
            ctx.executor().scheduleAtFixedRate(new HeartBeatTask(ctx), 0, 5000, TimeUnit.MILLISECONDS);
            System.out.println("Client receive server heart beat message :-->" + message);
        } else {
            ctx.fireChannelRead(msg);
        }
    }

    private class HeartBeatTask implements Runnable {
        private final ChannelHandlerContext ctx;

        public HeartBeatTask(ChannelHandlerContext ctx) {
            this.ctx = ctx;
        }

        @Override
        public void run() {
            //build heartbeat
            NettyMessage message = new NettyMessage();
            Header       header  = new Header();
            header.setType(MessageType.HEARTBEAT_REQ.value());
            message.setHeader(header);
            //
            ctx.writeAndFlush(message);
            System.out.println("Client send heart beat message :-->" + message);
        }
    }
}
