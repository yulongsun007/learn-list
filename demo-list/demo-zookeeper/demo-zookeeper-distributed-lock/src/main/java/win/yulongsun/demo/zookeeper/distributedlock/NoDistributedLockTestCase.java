package win.yulongsun.demo.zookeeper.distributedlock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/** 不使用分布式锁
 * @author Sun.YuLong on 2018/1/22.
 */
public class NoDistributedLockTestCase {
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //
                    SimpleDateFormat format  = new SimpleDateFormat("HH:mm:ss|SSS");
                    String           orderNo = format.format(new Date());
                    System.out.println("order no is ::" + orderNo);

                }
            }).start();
        }
        countDownLatch.countDown();
    }
}
