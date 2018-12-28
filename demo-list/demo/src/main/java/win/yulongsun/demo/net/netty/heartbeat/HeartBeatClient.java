package win.yulongsun.demo.net.netty.heartbeat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import win.yulongsun.demo.net.netty.protocol.NettyMessageDecoder;
import win.yulongsun.demo.net.netty.protocol.NettyMessageEncoder;

import java.net.InetSocketAddress;

/**
 * @author Sun.Yulong on 2017/8/28.
 */
public class HeartBeatClient {
    public static void main(String[] args) {
        NioEventLoopGroup group     = new NioEventLoopGroup();
        Bootstrap         bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new NettyMessageDecoder(1024 * 1024, 4, 4));
                        ch.pipeline().addLast("MessageEncoder", new NettyMessageEncoder());
                        ch.pipeline().addLast("ReadTimeoutHandler", new ReadTimeoutHandler(50));
                        ch.pipeline().addLast("LoginAuthHandler", new LoginAuthReqHandler());
                        ch.pipeline().addLast("HeartBeatHandler", new HeartBeatReqHandler());
                    }
                });

        try {
            ChannelFuture future = bootstrap.connect(new InetSocketAddress(HeartBeatConstant.REMOTE_IP, HeartBeatConstant.REMOTE_PORT)).sync();
//            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
