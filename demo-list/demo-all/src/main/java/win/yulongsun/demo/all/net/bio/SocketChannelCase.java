package win.yulongsun.demo.all.net.bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * http://ifeve.com/socket-channel/
 *
 * SocketChannelCase:
 * 1、是什么?
 *      连接到TCP的管道。
 * 2、创建方式
 *      2.1 打开一个SocketChannel并连接到服务器上。
 *      2.2 一个新连接到达ServerSocketChannel时，会创建一个SocketChannel
 * 3、操作：
 *      3.1 从SocketChannel读取数据
 *      3.2 往SocketChannel写数据
 * (*)4、非阻塞模式
 *
 *
 *
 * Created by Sun.Yulong on 2017/8/2.
 */
public class SocketChannelCase {
    public static void main(String[] args) {
        try {
            // 打开SocketChannel
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));

            //从SocketChannel读取数据
            ByteBuffer buf = ByteBuffer.allocate(48);
            int read = socketChannel.read(buf);//返回值表示读了多少字节进buffer.如果返回-1,表示读到了流的末尾。
            System.out.println(read);

            //往SocketChannel写数据
            String newData = "data";
            buf = ByteBuffer.allocate(48);
            buf.put(newData.getBytes());
            buf.flip(); //
            while (buf.hasRemaining()){ //
                socketChannel.write(buf);   //write方法无法保证能写多少字节到channel中，所以循环调用，知道buffer中没有要写的字节为止。
            }

            // 关闭SocketChannel
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
