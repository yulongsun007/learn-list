package win.yulongsun.demo.net.netty.heartbeat;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import win.yulongsun.demo.net.netty.protocol.Header;
import win.yulongsun.demo.net.netty.protocol.NettyMessage;

/**
 * @author Sun.Yulong on 2017/8/28.
 */
public class LoginAuthReqHandler extends ChannelHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        //通道激活，三次握手成功之后。
        //构造握手请求消息发送给服务端
        NettyMessage message = new NettyMessage();
        Header       header  = new Header();
        header.setType(MessageType.LOGIN_REQ.value());
        message.setHeader(header);
        //
        ctx.writeAndFlush(message);
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        //对握手应答消息进行处理
        NettyMessage message = (NettyMessage) msg;
        if (message.getHeader() != null && message.getHeader().getType() == MessageType.LOGIN_RESP.value()) {
            //判断是否认证成功
            byte loginResult = (byte) message.getBody();
            if (loginResult != (byte) 0) {
                //握手失败,关闭链路
                ctx.close();
            } else {
                ctx.fireChannelRead(msg);
                System.out.println("Login is ok :" + message);
            }
        } else {
            ctx.fireChannelRead(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        ctx.fireExceptionCaught(cause);
    }
}
