package win.yulongsun.demo.middleware.netty3.server;


import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;
import win.yulongsun.demo.middleware.netty3.server.handler.Netty3HeartBeatServerHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author Sun.YuLong on 2017/11/29.
 */
public class Netty3HeartBeatServer {
    public static void main(String[] args) throws IOException {
        ServerBootstrap server = new ServerBootstrap();
        server.setFactory(new NioServerSocketChannelFactory());
        server.setPipelineFactory(new ChannelPipelineFactory() {
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
                //timer 读超时时间、写超时时间、读写超时时间
//                pipeline.addLast("idleStateHandler", new IdleStateHandler(new HashedWheelTimer(), 5, 5, 10));
                pipeline.addLast("stringDecoder", new StringDecoder());
                pipeline.addLast("stringEncoder", new StringEncoder());
                pipeline.addLast("heartbeatServerHandler", new Netty3HeartBeatServerHandler());
                return pipeline;
            }
        });
        server.bind(new InetSocketAddress(8888));
        System.out.println("server start::8888");
    }
}
