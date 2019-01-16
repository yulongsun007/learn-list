package win.yulongsun.demo.basic.thread;

import org.junit.Test;

/**
 * @author Sun.YuLong on 2018/6/4.
 */
public class ThreadRunnableTestCase {

    @Test
    public void testThread() {
        TestThread thread1 = new TestThread();
        TestThread thread2 = new TestThread();
        TestThread thread3 = new TestThread();
        thread1.start();
        thread2.start();
        thread3.start();
        /**
         * Thread-1::5
         * Thread-1::4
         * Thread-2::5
         * Thread-0::5
         * Thread-0::4
         * Thread-0::3
         * Thread-0::2
         * Thread-0::1
         * Thread-2::4
         * Thread-1::3
         * Thread-2::3
         * Thread-1::2
         * Thread-2::2
         * Thread-1::1
         * Thread-2::1
         *
         * 数据不共享
         */
    }

    @Test
    public void testRunnable() {
        TestRunnable runnable = new TestRunnable();
        Thread       thread1  = new Thread(runnable);
        Thread       thread2  = new Thread(runnable);
        Thread       thread3  = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
        /**
         * Thread-0::5
         * Thread-0::4
         * Thread-1::5
         * Thread-0::3
         * Thread-0::1
         * Thread-1::2
         *
         * 数据共享
         */
    }

    class TestThread extends Thread {
        int i = 5;

        @Override
        public void run() {
            while (i > 0) {
                System.out.println(currentThread().getName() + "::" + i);
                i--;
            }
        }
    }


    class TestRunnable implements Runnable {
        volatile int i = 5;

        @Override
        public void run() {
            while (i > 0) {
                System.out.println(Thread.currentThread().getName() + "::" + i);
                i--;
            }
        }
    }
}
