package win.yulongsun.demo.net.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**http://ifeve.com/channels/
 *
 * 1、通道是什么?
 *      可以从通道读取数据到缓冲区
 *      可以从缓冲区写入数据到通道。
 *
 * 2、通道和流的区别？
 *      ① 通道是双向的。流是单向的。
 *      ② 通道可以异步读写。
 *
 * 3、 通道的实现类
 *      FileChannel         从文件中读写数据
 *      DatagramChannel     通过UDP读写网络中的数据
 *      SocketChannel       通过TCP读写网络中的数据
 *      ServerSocketChannel 监听新进来的TCP连接。对于每一个新进来的连接都会创建一个SocketChannel
 *
 *
 * Created by Sun.Yulong on 2017/8/23.
 */
public class ChannelCase {

    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("", "rw");
        // 创建Channel
        FileChannel channel = file.getChannel();
        // 获取缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(48);
        // 通道讲数据写入缓冲区
        int read = channel.read(buffer);
        while (read != -1) {
            while (buffer.hasRemaining()) {
                System.out.println(buffer.get());
            }
        }
        //
        file.close();

    }

}
