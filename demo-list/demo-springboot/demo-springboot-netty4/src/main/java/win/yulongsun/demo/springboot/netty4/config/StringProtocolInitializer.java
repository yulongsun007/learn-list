package win.yulongsun.demo.springboot.netty4.config;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import io.netty.handler.logging.LoggingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import win.yulongsun.demo.springboot.netty4.codec.AbsIntegerEncoder;
import win.yulongsun.demo.springboot.netty4.codec.MessageHandler;
import win.yulongsun.demo.springboot.netty4.codec.MyLengthFieldBasedFrameDecoder;
import win.yulongsun.demo.springboot.netty4.codec.MySimpleChannelInboundHandler;

/**
 * Just a dummy protocol mainly to show the ServerBootstrap being initialized.
 *
 * @author Abraham Menacherry
 */
@Component
@Qualifier("springProtocolInitializer")
public class StringProtocolInitializer extends ChannelInitializer<SocketChannel> {

    @Autowired
    StringDecoder stringDecoder;

    @Autowired
    StringEncoder stringEncoder;

    @Autowired
    MessageHandler serverHandler;

    @Autowired
    AbsIntegerEncoder absIntegerEncoder;


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
//        pipeline.addLast("decoder", stringDecoder);
//        pipeline.addLast("log", new LoggingHandler());
        pipeline.addLast("decoder", new MyLengthFieldBasedFrameDecoder(1024 * 8, 0, 4, -4, 0));
        pipeline.addLast("handler", new MySimpleChannelInboundHandler());
//        pipeline.addLast("encoder", stringEncoder);
    }

    public StringDecoder getStringDecoder() {
        return stringDecoder;
    }

    public void setStringDecoder(StringDecoder stringDecoder) {
        this.stringDecoder = stringDecoder;
    }

    public StringEncoder getStringEncoder() {
        return stringEncoder;
    }

    public void setStringEncoder(StringEncoder stringEncoder) {
        this.stringEncoder = stringEncoder;
    }

    public MessageHandler getServerHandler() {
        return serverHandler;
    }

    public void setServerHandler(MessageHandler serverHandler) {
        this.serverHandler = serverHandler;
    }

}  