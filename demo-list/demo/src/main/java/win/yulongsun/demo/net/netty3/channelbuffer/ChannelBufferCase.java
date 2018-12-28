package win.yulongsun.demo.net.netty3.channelbuffer;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.buffer.ReadOnlyChannelBuffer;

/**
 * @author Sun.YuLong on 2017/11/20.
 */
public class ChannelBufferCase {

    public static void main(String[] args) {

        ChannelBuffer buffer = ChannelBuffers.buffer(10);
        System.out.println("readable bytes:" + buffer.readableBytes()); //0
        System.out.println("readable index:" + buffer.readerIndex());   //0
        System.out.println("writable bytes:" + buffer.writableBytes()); //10
        System.out.println("writable index:" + buffer.writerIndex());   //0
        //
        buffer.writeInt(1);
        System.out.println("================= buffer.writeInt(1);=====================");
        System.out.println("readable bytes:" + buffer.readableBytes()); //4
        System.out.println("readable index:" + buffer.readerIndex());   //0
        System.out.println("writable bytes:" + buffer.writableBytes()); //6
        System.out.println("writable index:" + buffer.writerIndex());   //4
        //
        buffer.writeInt(2);
        System.out.println("================= buffer.writeInt(2); again================");
        System.out.println("readable bytes:" + buffer.readableBytes()); //8
        System.out.println("readable index:" + buffer.readerIndex());   //0
        System.out.println("writable bytes:" + buffer.writableBytes()); //2
        System.out.println("writable index:" + buffer.writerIndex());   //8
        //
        int readInt = buffer.readInt();
        System.out.println("=================== buffer.readInt();=======================");
        System.out.println("readInt:" + readInt); //1
        System.out.println("readable bytes:" + buffer.readableBytes()); //4
        System.out.println("readable index:" + buffer.readerIndex());   //4
        System.out.println("writable bytes:" + buffer.writableBytes()); //2
        System.out.println("writable index:" + buffer.writerIndex());   //8
        //
        buffer.discardReadBytes();
        System.out.println("=================== buffer.discardReadBytes();==============");
        System.out.println("readable bytes:" + buffer.readableBytes()); //4
        System.out.println("readable index:" + buffer.readerIndex());   //0
        System.out.println("writable bytes:" + buffer.writableBytes()); //6
        System.out.println("writable index:" + buffer.writerIndex());   //4
        //
        buffer.resetReaderIndex();
        System.out.println("=================== buffer.resetReaderIndex();==============");
        System.out.println("readable bytes:" + buffer.readableBytes()); //4
        System.out.println("readable index:" + buffer.readerIndex());   //0
        System.out.println("writable bytes:" + buffer.writableBytes()); //6
        System.out.println("writable index:" + buffer.writerIndex());   //4
        buffer.resetWriterIndex();
        //
        buffer.resetWriterIndex();
        System.out.println("=================== buffer.resetWriterIndex();==============");
        System.out.println("readable bytes:" + buffer.readableBytes()); //0
        System.out.println("readable index:" + buffer.readerIndex());   //0
        System.out.println("writable bytes:" + buffer.writableBytes()); //10
        System.out.println("writable index:" + buffer.writerIndex());   //0


        ReadOnlyChannelBuffer readOnlyChannelBuffer = new ReadOnlyChannelBuffer(buffer);
        readOnlyChannelBuffer.writeInt(10);
    }
}
