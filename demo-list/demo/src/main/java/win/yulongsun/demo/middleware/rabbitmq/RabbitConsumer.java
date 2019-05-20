package win.yulongsun.demo.middleware.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Sun.YuLong on 2018/8/16.
 */
public class RabbitConsumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection        connection = factory.newConnection();
        Channel           channel = connection.createChannel();
//        channel.basicConsume()
    }
}
