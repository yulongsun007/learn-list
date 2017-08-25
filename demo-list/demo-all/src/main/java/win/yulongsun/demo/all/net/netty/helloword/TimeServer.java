package win.yulongsun.demo.all.net.netty.helloword;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.util.Date;

/**
 * Created by sunyl21830 on 2017/7/10.
 */
public class TimeServer {

    public void bind(int port) {
        //1. Configure Server
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();//处理服务端接收客户端连接
        NioEventLoopGroup workGroup = new NioEventLoopGroup();//处理网络读写通讯
        //2.
        ServerBootstrap b = new ServerBootstrap();             //辅助工具类：用于服务器通道的一些配置
        b.group(bossGroup, workGroup)   //
                .channel(NioServerSocketChannel.class)         //指定NIO模式
                .option(ChannelOption.SO_BACKLOG, 1024)  //设置TCP缓冲区
                .option(ChannelOption.SO_SNDBUF, 32 * 1024) //设置发送缓冲大小
                .option(ChannelOption.SO_RCVBUF, 32 * 1024) //设置接收缓冲大小
                .option(ChannelOption.SO_KEEPALIVE, true)   //保持连接
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        //3. 配置具体数据接收方法的处理
                        ch.pipeline().addLast(
//                                new FixedLengthFrameDecoder(5),
//                                new StringDecoder(),
                                new LoggingHandler(LogLevel.INFO),
                                new TimeServerHandler());
                    }
                });
        try {
            //4. 绑定端口，同步等待成功
            ChannelFuture future = b.bind(port).sync();
            //5. 等待服务监听端口关闭
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }

    public class TimeServerHandler extends ChannelHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf buf = (ByteBuf) msg;
            byte[] req = new byte[buf.readableBytes()];
            buf.readBytes(req);
            String body = new String(req, "UTF-8");
            //输出查询指令
            System.out.println("The Time Server Receive Order :" + body);
            //回复Client
            String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
            ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
            ChannelFuture future = ctx.writeAndFlush(resp);
            //
            //当写完之后主动关闭通道
//            future.addListener(ChannelFutureListener.CLOSE);

        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            ctx.flush();
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            ctx.close();
        }
    }

    public static void main(String[] args) {
        new TimeServer().bind(8080);

    }
}
