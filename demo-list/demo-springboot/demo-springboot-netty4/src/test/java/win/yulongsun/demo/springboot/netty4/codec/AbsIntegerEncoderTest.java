package win.yulongsun.demo.springboot.netty4.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Assert;
import org.junit.Test;
import win.yulongsun.demo.springboot.netty4.codec.AbsIntegerEncoder;


/**
 * @author Sun.YuLong on 2018/2/28.
 */
public class AbsIntegerEncoderTest {
    @Test
    public void encode() throws Exception {
        //创建一个能容纳10个int的ByteBuf
        ByteBuf buf = Unpooled.buffer();
        for (int i = 1; i < 10; i++) {
            buf.writeInt(i * -1);
        }
        //
        EmbeddedChannel embeddedChannel = new EmbeddedChannel(new AbsIntegerEncoder());
        //
        Assert.assertTrue(embeddedChannel.writeOutbound(buf));
        //
        Assert.assertTrue(embeddedChannel.finish());
        //读取出站数据
        for (int i = 1; i < 10; i++) {
            Assert.assertEquals(i, embeddedChannel.readOutbound());
        }
        Assert.assertNull(embeddedChannel.readOutbound());


    }

}