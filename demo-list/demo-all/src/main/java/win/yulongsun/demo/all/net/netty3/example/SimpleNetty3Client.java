package win.yulongsun.demo.all.net.netty3.example;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.Scanner;

/**
 * @author Sun.YuLong on 2017/11/21.
 */
public class SimpleNetty3Client {
    public static void main(String[] args) {
        ClientBootstrap bootstrap = new ClientBootstrap();
        //socket工厂
        bootstrap.setFactory(new NioClientSocketChannelFactory());
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
                pipeline.addLast("decoder", new StringDecoder());
                pipeline.addLast("encoder", new StringEncoder());
                pipeline.addLast("myClientHandler", new MyClientHandler());
                return pipeline;
            }
        });
        Channel channel = bootstrap.connect(new InetSocketAddress(6666)).getChannel();
        System.out.println("client start");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入");
            channel.write(scanner.next());
        }
    }
}

class MyClientHandler extends SimpleChannelHandler {
    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        super.messageReceived(ctx, e);
    }

    @Override
    public void handleDownstream(ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
        super.handleDownstream(ctx, e);

    }
}

