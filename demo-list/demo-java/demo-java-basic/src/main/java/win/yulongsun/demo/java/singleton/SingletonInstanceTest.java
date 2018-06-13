package win.yulongsun.demo.java.singleton;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author Sun.YuLong on 2018/6/13.
 */
public class SingletonInstanceTest {

    private static SingletonInstanceTest instance0;

    /**
     * 懒汉式
     * <p>
     * 线程不安全
     *
     * @return
     */
    public static SingletonInstanceTest getInstance0() {
        if (instance0 == null) {
            instance0 = new SingletonInstanceTest();
        }
        return instance0;
    }

    @Test
    public void testGetInstance0() {
        CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new Thread(new GetTask0(latch), i + "").start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
    }

    class GetTask0 implements Runnable {
        private CountDownLatch latch;

        public GetTask0(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-" + SingletonInstanceTest.getInstance0());
        }
    }


    //////////////////////////////////////////////////////////////

    private static SingletonInstanceTest instance1;

    public static SingletonInstanceTest getInstance1() {
        if (instance1 == null) {
            synchronized (SingletonInstanceTest.class) {
                if (instance1 == null) {
                    instance1 = new SingletonInstanceTest();
                }
            }
        }
        return instance1;
    }


    @Test
    public void testGetInstance1() {
        CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 100; i++) {
            new Thread(new GetTask1(), i + "").start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        latch.countDown();
    }

    class GetTask1 implements Runnable {
        private CountDownLatch latch;

//        public GetTask1(CountDownLatch latch) {
//            this.latch = latch;
//        }

        @Override
        public void run() {
//            try {
//                latch.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + "-" + SingletonInstanceTest.getInstance1());
        }
    }

}
