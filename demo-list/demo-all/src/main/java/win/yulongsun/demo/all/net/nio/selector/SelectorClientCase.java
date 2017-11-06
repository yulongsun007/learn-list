package win.yulongsun.demo.all.net.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @author Sun.YuLong on 2017/11/6.
 */
public class SelectorClientCase {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8000));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
