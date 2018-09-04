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

    private static final String IP   = "10.20.29.103";
    private static final int    PORT = 5672;

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(IP);
        factory.setPort(PORT);
        factory.setUsername("guest");
        factory.setPassword("123456");
        // 创建连接
        Connection connection = factory.newConnection();
        // 创建信道
        Channel channel = connection.createChannel();
        // 创建交换器
        channel.exchangeDeclare("exchange-name", "direct", true, false, null);
        // 创建队列
        channel.queueDeclare("queue-name", true, false, false, null);
        // 将交换器和队列通过路由键绑定
        channel.queueBind("queue-name", "exchange-name", "routingkey-name");
        //
//        channel.basicPublish();


    }
}
