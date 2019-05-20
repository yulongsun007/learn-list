package win.yulongsun.demo.middleware.netty3.client;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;
import win.yulongsun.demo.middleware.netty3.client.handler.Netty3HeartBeatClientHandler;

import java.net.InetSocketAddress;

/**
 * @author Sun.YuLong on 2017/11/29.
 */
public class Netty3HeartBeatClient {

    public static void main(String[] args) {
        ClientBootstrap clientBootstrap = new ClientBootstrap();
        clientBootstrap.setFactory(new NioClientSocketChannelFactory());
        clientBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
                pipeline.addLast("stringDecoder", new StringDecoder());
                pipeline.addLast("stringEncoder", new StringEncoder());
                pipeline.addLast("heartBeatClientHandler", new Netty3HeartBeatClientHandler());
                return pipeline;
            }
        });
        clientBootstrap.connect(new InetSocketAddress(8888));
    }
}
