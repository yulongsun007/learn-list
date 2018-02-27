package win.yulongsun.demo.springboot.netty4;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;  
import io.netty.channel.socket.SocketChannel;  
import io.netty.handler.codec.string.StringDecoder;  
import io.netty.handler.codec.string.StringEncoder;  
  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.beans.factory.annotation.Qualifier;  
import org.springframework.stereotype.Component;  
  
/** 
 * Just a dummy protocol mainly to show the ServerBootstrap being initialized. 
 *  
 * @author Abraham Menacherry 
 *  
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
  
    @Override  
    protected void initChannel(SocketChannel ch) throws Exception {  
        ChannelPipeline pipeline = ch.pipeline();  
        pipeline.addLast("decoder", stringDecoder);
        pipeline.addLast("handler", serverHandler);  
        pipeline.addLast("encoder", stringEncoder);
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