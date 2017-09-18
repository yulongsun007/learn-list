package win.yulongsun.demo.all.net.netty.frame.delimiter;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author Sun.Yulong on 2017/9/11.
 */
public class EchoClient {

    public static void main(String[] args) {
        NioEventLoopGroup group     = new NioEventLoopGroup();
        Bootstrap         bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {

                    }
                });

    }
}
