package win.yulongsun.demo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Sun.YuLong on 2018/8/16.
 */
public class RabbitProducer {

    private static final String IP = "10.20.29.103";
    private static final int PORT = 5672;

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(IP);
        factory.setPort(PORT);
        factory.setUsername("guest");
        factory.setPassword("123456");
        //
        Connection connection = factory.newConnection();
        Channel    channel    = connection.createChannel();
//        channel.exchangeDe
    }
}
