package win.yulongsun.demo.basic.juc.concurrent.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Sun.YuLong on 2018/4/10.
 */
public class AtomicIntegerTest {

    private static volatile int value = 0;

    /**
     * volatile不能保证线程安全,不能保证原子性
     *
     * @throws InterruptedException
     */
    @Test
    public void testVolatile() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            int x = 0;
            while (x < 50) {
                int temp = value;
                System.out.println(Thread.currentThread().getName() + ":" + temp);
                value += 1;
                x++;
            }

        }, "t1");
        Thread t2 = new Thread(() -> {
            int x = 0;
            while (x < 55) {
                int temp = value;
                System.out.println(Thread.currentThread().getName() + ":" + temp);
                value += 1;
                x++;
            }

        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        /**
         * 结果片段：
         * t1:73
         * t2:74
         * t1:75
         * t2:76
         * t2:78
         * t2:79
         * t2:80
         * t1:77
         * t2:81
         * t1:82
         * t2:83
         * t1:84 //t1从84开始了，前面还只有82
         * t1:86
         * t1:87
         * t1:88
         * t1:89
         * t1:90
         */
    }

    /**
     * AtomicInteger可以保证线程安全
     * 1、可见性
     * 2、原子性
     */
    private AtomicInteger atomicInteger = new AtomicInteger();

    @Test
    public void testAtomicInteger() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            int x = 0;
            while (x < 50) {
                int temp = atomicInteger.getAndIncrement();
                System.out.println(Thread.currentThread().getName() + ":" + temp);
                x++;
            }

        }, "t1");
        Thread t2 = new Thread(() -> {
            int x = 0;
            while (x < 50) {
                int temp = atomicInteger.getAndIncrement();
                System.out.println(Thread.currentThread().getName() + ":" + temp);
                x++;
            }

        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        /**
         * 部分结果
         * t1:73
         * t2:74
         * t1:75
         * t2:76
         * t1:77
         * t2:78
         * t2:80
         * t2:81
         * t2:82
         * t2:83
         * t2:84
         * t2:85
         * t2:86
         * t2:87
         * t2:88
         * t2:89
         * t2:90
         * t2:91
         * t2:92
         * t2:93
         * t2:94
         * t1:79
         * t1:95
         * t1:96
         * t1:97
         * t1:98
         * t1:99
         */
    }
}
