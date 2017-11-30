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
//            ClientBootstrap bootstrap = new ClientBootstrap();
//            //socket工厂
//            bootstrap.setFactory(new NioClientSocketChannelFactory());
//            bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
//                @Override
//                public ChannelPipeline getPipeline() throws Exception {
//                    ChannelPipeline pipeline = Channels.pipeline();
//                    pipeline.addLast("decoder", new StringDecoder());
//                    pipeline.addLast("encoder", new StringEncoder());
//                    pipeline.addLast("myClientHandler", new MyClientHandler());
//                    return pipeline;
//                }
//            });
////            Channel channel = bootstrap.connect(new InetSocketAddress(6666)).getChannel();
//            System.out.println("client start");
////            Scanner scanner = new Scanner(System.in);
////        while (true) {
////            System.out.println("请输入");
////            channel.write(scanner.next());
////            channel.write("123");
////        }
//        for (int i = 0; i < 10; i++) {
//            Channel channel2 = bootstrap.connect(new InetSocketAddress(6666)).getChannel();
//            System.out.println("clienti2 start");
//            channel2.write(i+"");
//
//        }
        for (int i = 0; i < 10; i++) {
            new MyThread().start();
        }

    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
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
        System.out.println("client start");
        Channel channel = bootstrap.connect(new InetSocketAddress(6610)).getChannel();
        channel.write("0954332238004   8888    00999000000805564381A02710447                                                                                          B420160308046105          2350000000000000001372421197112010010            006中国交行                                                    6216261000000000018         全渠道                                                      15620171103                                      1410010                                        40005392                                                 313227000012                              1111     20171109150001           380001644466A                                000000190001                              055                                                                                                                                                                                                                                                                                 ");
//        channel.close();
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

