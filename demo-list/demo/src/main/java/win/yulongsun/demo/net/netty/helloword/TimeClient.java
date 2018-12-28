package win.yulongsun.demo.net.netty.helloword;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;


/**
 * Created by sunyl21830 on 2017/7/10.
 */
public class TimeClient {

    public void connect(int port, String host) {
        NioEventLoopGroup group     = new NioEventLoopGroup();
        Bootstrap         bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        //
                        socketChannel.pipeline().addLast(new TimeClientHandler());
                    }
                });

        try {
            //发起异步连接
            ChannelFuture future = bootstrap.connect(host, port).sync();
            //
            future.channel().writeAndFlush(Unpooled.copiedBuffer("QUERY TIME ORDER".getBytes()));
            //
            future.channel().flush();
            //等待客户端链路关闭
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }

    }

    private class TimeClientHandler extends ChannelHandlerAdapter {

//        private final ByteBuf firstMessage;

        public TimeClientHandler() {
//            byte[] req = "QUERY TIME ORDER".getBytes();
//            firstMessage = Unpooled.buffer(req.length);
//            firstMessage.writeBytes(req);
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            //管道激活的时候
//            ctx.writeAndFlush(firstMessage);
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            //当数据读取完之后
            ByteBuf buf = (ByteBuf) msg;
            byte[]  req = new byte[buf.readableBytes()];
            buf.readBytes(req);
            String body = new String(req, "UTF-8");
            System.out.println("Client is:" + body);
            //
            //异步关闭：客户端主动关闭连接
//            ctx.writeAndFlush("xxx").addListener(ChannelFutureListener.CLOSE);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            //exceptionCaught:当出现异常时
            ctx.close();
        }
    }

    public static void main(String[] args) {
        new TimeClient().connect(8080, "127.0.0.1");
    }
}
