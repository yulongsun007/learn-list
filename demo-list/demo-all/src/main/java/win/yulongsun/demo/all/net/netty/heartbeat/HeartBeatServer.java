package win.yulongsun.demo.all.net.netty.heartbeat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import win.yulongsun.demo.all.net.netty.protocol.NettyMessageDecoder;
import win.yulongsun.demo.all.net.netty.protocol.NettyMessageEncoder;

/**
 * @author Sun.Yulong on 2017/8/28.
 */
public class HeartBeatServer {

    public static void main(String[] args) {
        NioEventLoopGroup bossGroup       = new NioEventLoopGroup();
        NioEventLoopGroup workGroup       = new NioEventLoopGroup();
        ServerBootstrap   serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workGroup)
                .option(ChannelOption.SO_BACKLOG, 100)
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel ch) throws Exception {
                        //todo
                        ch.pipeline().addLast(new NettyMessageDecoder(1024 * 1024, 4, 4));
                        ch.pipeline().addLast(new NettyMessageEncoder());
                        ch.pipeline().addLast("readTimeoutHandler", new ReadTimeoutHandler(50));
                        ch.pipeline().addLast(new LoginAuthRespHandler());
                        ch.pipeline().addLast("HeartBeatHandler", new HeartBeatRespHandler());
                    }
                });
        //
        try {
            serverBootstrap.bind(HeartBeatConstant.REMOTE_IP, HeartBeatConstant.REMOTE_PORT).sync();
            System.out.println("心跳服务器启动成功,IP:" + HeartBeatConstant.REMOTE_IP + ",PORT:" + HeartBeatConstant.REMOTE_PORT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
