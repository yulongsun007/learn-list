package win.yulongsun.demo.net.netty3.example;

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
                pipeline.addLast("myOutHandler", new MyOutStreamHandler());
                return pipeline;
            }
        });
        serverBootstrap.bind(new InetSocketAddress(6666));
        System.out.println("server start");

    }
}

//
class MyServerHandler extends SimpleChannelUpstreamHandler {

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        System.out.println("in===="+Thread.currentThread().getId());
        new Thread(new Runnable() {
            @Override
            public void run() {
                ctx.getChannel().write("111");
                System.out.println("sub thread===="+Thread.currentThread().getId());
            }
        }).start();
    }


//    @Override
//    public void handleUpstream(ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
//        super.handleUpstream(ctx, e);
//        ctx.getChannel().write("write");
//        System.out.println("in ==="+Thread.currentThread().getId());
//    }
}
class MyOutStreamHandler extends SimpleChannelDownstreamHandler{
    @Override
    public void handleDownstream(ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
        System.out.println("out===="+Thread.currentThread().getId());
        super.handleDownstream(ctx, e);
    }

}
