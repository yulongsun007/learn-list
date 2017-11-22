package win.yulongsun.demo.all.net.nio.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author Sun.YuLong on 2017/11/22.
 */
public class JdkNioClientSocketChannelCase {
    public static void main(String[] args) throws IOException {
        //
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        //
        // 该方法实际没有建立连接，只有在channel.finishConnect();后才建立真正连接；
        socketChannel.connect(new InetSocketAddress(9999));
        //
        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        while (true) {
            selector.select();
            //
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isConnectable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    if (channel.isConnectionPending()) {
                        // 如果正在建立连接，则完成连接
                        channel.finishConnect();
                    }
                    //
                    channel.configureBlocking(false);
                    //
                    channel.write(ByteBuffer.wrap(new String("client has connected,").getBytes()));
                    // 将通道设置读权限
                    channel.register(selector, SelectionKey.OP_READ);
                } else {
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer    buffer  = ByteBuffer.allocate(100);
                    channel.read(buffer);
                    byte[] data = buffer.array();
                    System.out.println("client read::" + new String(data) + ",position::" + data.length);
                }
            }
        }
    }
}
