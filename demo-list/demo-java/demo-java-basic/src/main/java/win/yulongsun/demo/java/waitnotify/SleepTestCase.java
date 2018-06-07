package win.yulongsun.demo.java.waitnotify;

import org.junit.Test;

/**
 * @author Sun.YuLong on 2018/6/4.
 */
public class SleepTestCase {

    @Test
    public void testThreadInterrupt() {
        Thread testA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("我要睡60s");
                    Thread.sleep(60 * 1000);
                    System.out.println("我醒啦");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("我被吵醒啦");
                }
            }
        }, "testA");
        testA.start();
        //
        testA.interrupt();
    }

}
