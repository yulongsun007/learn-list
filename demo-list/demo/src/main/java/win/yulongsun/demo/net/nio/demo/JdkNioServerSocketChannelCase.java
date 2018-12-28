package win.yulongsun.demo.net.nio.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * http://ifeve.com/server-socket-channel/
 * <p>
 * 1、ServerSocketChannel是什么?
 * 监听新进来TCP连接的Channel.
 * <p>
 * 2、操作
 * 2.1、监听新连接.
 * <p>
 * 3、非阻塞模式
 * 在非阻塞模式下,accept()方法会立即返回，如果没有新进来的连接，返回的是null.
 * Created by Sun.YuLong on 2017/8/23.
 */
public class JdkNioServerSocketChannelCase {

    public static void main(String[] args) throws IOException {
        // 创建一个ServerSocket通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 设置该通道为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //
        serverSocketChannel.socket().bind(new InetSocketAddress(9999));
        // 创建通道管理器
        Selector selector = Selector.open();
        // 将通道和通道管理器绑定，并为该通道监听SelectionKey.OP_ACCEPT事件
        // 当事件到达时， selector.select()会返回，否则阻塞；
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            //
            selector.select();
            //
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                // 客户端请求连接
                if (key.isAcceptable()) {
                    ServerSocketChannel server        = (ServerSocketChannel) key.channel();
                    SocketChannel       socketChannel = server.accept();
                    //
                    socketChannel.configureBlocking(false);
                    //
                    socketChannel.write(ByteBuffer.wrap(new String("server is accept,server send a message to client").getBytes()));
                    // 连接建立成功后，为了接收客户端消息，需要将该通道设置为可读
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    // 获得可读事件
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer    buffer        = ByteBuffer.allocate(100);
                    socketChannel.read(buffer);
                    System.out.println("server read::" + new String(buffer.array()) + ",buffer position::" + buffer.position());
                    //
                    socketChannel.write(ByteBuffer.wrap(new String("server has read the message,and give a response").getBytes()));
                }
            }
        }

        // 关闭ServerSocketChannel
//        serverSocketChannel.close();
    }
}
