package win.yulongsun.demo.net.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**http://ifeve.com/pipe/
 *
 * Pipe:是2个线程之间的"单向"数据连接。
 *
 *
 *             ________________Pipe______________
 *            |                                  |
 *            |                                  |
 * ThreadA----|-> Sink Channel --> Source Channel --> ThreadB
 *            |                                  |
 *            |__________________________________|
 *
 * 主要操作：
 *  1.向管道写数据
 *  2.从管道读数据
 *
 * Created by Sun.Yulong on 2017/8/23.
 */
public class PipeCase {
    public static void main(String[] args) {
        try {
            // 创建管道
            Pipe pipe = Pipe.open();
            // 向管道写数据
            Pipe.SinkChannel sinkChannel = pipe.sink();
            String data = "1";
            ByteBuffer buf = ByteBuffer.allocate(48);
            buf.put(data.getBytes());
            buf.flip();
            while (buf.hasRemaining()) {
                sinkChannel.write(buf);
            }
            // 从管道读数据
            Pipe.SourceChannel sourceChannel = pipe.source();
            buf = ByteBuffer.allocate(48);
            int read = sourceChannel.read(buf);  // read()返回的int就是告诉我们多少字节被读进了缓冲区
            System.out.println(read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
