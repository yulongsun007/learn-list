package win.yulongsun.demo.middleware.netty5.marshalling;

import io.netty.handler.codec.marshalling.DefaultMarshallerProvider;
import io.netty.handler.codec.marshalling.DefaultUnmarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallingDecoder;
import io.netty.handler.codec.marshalling.MarshallingEncoder;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;

/**
 * Marshalling 编解码工厂
 *
 * @author Sun.Yulong on 2017/9/3.
 */
public class MarshallingCodecFactory {

    private static MarshallerFactory        factory       = null;
    private static MarshallingConfiguration configuration = null;

    static {
        //  serial:: 创建java序列化工厂
        factory = Marshalling.getProvidedMarshallerFactory("serial");
        configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
    }

    //创建解码器
    public static MarshallingDecoder buildMarshallingDecoder() {
        DefaultUnmarshallerProvider provider = new DefaultUnmarshallerProvider(factory, configuration);
        MarshallingDecoder          decoder  = new MarshallingDecoder(provider, 1024);
        return decoder;
    }

    //创建编码器
    public static MarshallingEncoder buildMarshallingEncoder() {
        DefaultMarshallerProvider provider = new DefaultMarshallerProvider(factory, configuration);
        MarshallingEncoder        encoder  = new MarshallingEncoder(provider);
        return encoder;
    }

}
