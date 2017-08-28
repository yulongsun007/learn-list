package win.yulongsun.demo.all.net.netty.heartbeat;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import win.yulongsun.demo.all.net.netty.protocol.Header;
import win.yulongsun.demo.all.net.netty.protocol.NettyMessage;

/**
 * @author Sun.Yulong on 2017/8/28.
 */
public class HeartBeatRespHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        NettyMessage message = (NettyMessage) msg;
        // 返回心跳应答消息
        if (message.getHeader() != null && message.getHeader().getType() == MessageType.HEARTBEAT_RESP.value()) {
            System.out.println("Receive client heart beat message :-->" + message);
            //
            NettyMessage heartBeat = buildHeartBeat();
            ctx.writeAndFlush(heartBeat);
            //
            System.out.println("Send heart beat response message to client :-->" + heartBeat);
        }
    }

    private NettyMessage buildHeartBeat() {
        NettyMessage message = new NettyMessage();
        Header       header  = new Header();
        header.setType(MessageType.HEARTBEAT_RESP.value()); //
        message.setHeader(header);
        return message;
    }
}
