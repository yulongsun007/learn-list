package win.yulongsun.demo.netty3.heartbeat;


import org.jboss.netty.bootstrap.Bootstrap;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.io.IOException;

/**
 * @author Sun.YuLong on 2017/11/29.
 */
public class SimpleHeartBeatServer {
    public static void main(String[] args) throws IOException {
        Bootstrap server = new ServerBootstrap();
        server.setFactory(new NioServerSocketChannelFactory());
        server.setPipelineFactory(new ChannelPipelineFactory() {
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
//                pipeline.addLast("heartbeatHandler", new HeartBeatHandler());
                return pipeline;
            }
        });
    }
}
