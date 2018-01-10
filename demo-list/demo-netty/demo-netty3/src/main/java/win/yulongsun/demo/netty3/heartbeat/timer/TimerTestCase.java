package win.yulongsun.demo.netty3.heartbeat.timer;

import org.jboss.netty.util.HashedWheelTimer;
import org.jboss.netty.util.Timeout;
import org.jboss.netty.util.TimerTask;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @author Sun.YuLong on 2018/1/10.
 */
public class TimerTestCase {

    @Test
    public void test() {
        //tickDuration: tick时长，也就是多久转一格
        //ticksPerWheel: 一圈有多少格(tick)
        HashedWheelTimer timer = new HashedWheelTimer(1, TimeUnit.SECONDS,10);
        timer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("task::" + timeout.getTimer());
            }
        }, 3, TimeUnit.SECONDS);
    }


    @Test
    public void test1() throws Exception {
        DateTimeFormatter formatter        = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        HashedWheelTimer  hashedWheelTimer = new HashedWheelTimer(100, TimeUnit.MILLISECONDS,10);
        System.out.println("start:" + LocalDateTime.now().format(formatter));
        hashedWheelTimer.newTimeout(timeout -> {
            System.out.println("task :" + LocalDateTime.now().format(formatter));
        }, 3, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }
}
