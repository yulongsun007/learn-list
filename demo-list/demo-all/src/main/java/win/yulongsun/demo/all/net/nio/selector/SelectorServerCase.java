package win.yulongsun.demo.all.net.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

/**
 * http://ifeve.com/selectors/
 * <p>
 * 1、Selector是什么？
 * 选择器。检测NIO通道。
 * <p>
 * 2、
 * <p>
 * Created by Sun.Yulong on 2017/8/23.
 */
public class SelectorServerCase {

    public static void main(String[] args) throws IOException {
        //1. 创建Selector
        Selector selector = Selector.open();

        //2.将Channel注册到Selector
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        serverSocketChannel.socket().bind(new InetSocketAddress(8000));
        //
        for (; ; ) {
            selector.select();
            //
            for (Iterator<SelectionKey> iterator = selector.selectedKeys().iterator(); iterator.hasNext(); ) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                System.out.println(selectionKey.readyOps());
                if (selectionKey.isAcceptable()) {
                    //
                    System.out.println("Acceptor");
                    serverSocketChannel.accept();
                }
            }
        }
    }
}
