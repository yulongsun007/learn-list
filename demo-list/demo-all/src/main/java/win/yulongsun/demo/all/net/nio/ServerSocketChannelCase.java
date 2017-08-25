package win.yulongsun.demo.all.net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**http://ifeve.com/server-socket-channel/
 *
 * 1、ServerSocketChannel是什么?
 *      监听新进来TCP连接的Channel.
 *
 * 2、操作
 *      2.1、监听新连接.
 *
 * 3、非阻塞模式
 *      在非阻塞模式下,accept()方法会立即返回，如果没有新进来的连接，返回的是null.
 * Created by Sun.Yulong on 2017/8/23.
 */
public class ServerSocketChannelCase {

    public static void main(String[] args) {
        try {
            // 打开ServerSocketChannel
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(9999));
//            serverSocketChannel.configureBlocking(false);//非阻塞模式
            //在非阻塞模式下,accept()方法会立即返回，如果没有新进来的连接，返回的是null

            // 监听新进来的连接
            while (true) {
                SocketChannel socketChanne1 = serverSocketChannel.accept();
                if (socketChanne1 != null) {
                    //....
                }
            }

            // 关闭ServerSocketChannel
//            serverSocketChannel.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
