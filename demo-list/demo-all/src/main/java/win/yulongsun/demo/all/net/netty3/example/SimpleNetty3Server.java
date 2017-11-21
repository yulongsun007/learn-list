package win.yulongsun.demo.all.net.netty3.example;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;

/**
 * @author Sun.YuLong on 2017/10/30.
 */
public class SimpleNetty3Server {
    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.setFactory(new NioServerSocketChannelFactory());
        serverBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
                pipeline.addLast("decoder", new StringDecoder());
                pipeline.addLast("encoder", new StringEncoder());
                pipeline.addLast("myServerHandler", new MyServerHandler());
                return pipeline;
            }
        });
        serverBootstrap.bind(new InetSocketAddress(6666));
        System.out.println("server start");

    }
}

//
class MyServerHandler extends SimpleChannelHandler {

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        System.out.println("messageReceived");
        String message = (String) e.getMessage();
        System.out.println(message);
        super.messageReceived(ctx, e);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        System.out.println("exceptionCaught");
        super.exceptionCaught(ctx, e);
    }

    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("channelConnected");
        super.channelConnected(ctx, e);
    }

    @Override
    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("channelDisconnected");
        super.channelDisconnected(ctx, e);
    }

    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("channelClosed");
        super.channelClosed(ctx, e);
    }
}
