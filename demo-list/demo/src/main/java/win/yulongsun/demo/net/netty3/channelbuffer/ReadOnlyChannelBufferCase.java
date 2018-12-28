package win.yulongsun.demo.net.netty3.channelbuffer;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.buffer.ReadOnlyChannelBuffer;
import org.junit.Assert;
import org.junit.Test;

import java.nio.ReadOnlyBufferException;

/**
 * @author Sun.YuLong on 2017/11/20.
 */
public class ReadOnlyChannelBufferCase {


    @Test/*(expected = ReadOnlyBufferException.class)*/
    public void testReadOnlyChannelBuffer() {
        ChannelBuffer         buffer                = ChannelBuffers.buffer(10);
        ReadOnlyChannelBuffer readOnlyChannelBuffer = new ReadOnlyChannelBuffer(buffer);
        readOnlyChannelBuffer.writeInt(1);
    }
}
