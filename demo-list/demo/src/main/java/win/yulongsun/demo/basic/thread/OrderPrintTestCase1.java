package win.yulongsun.demo.basic.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yulong.sun
 * @version OrderPrintTestCase1.java, v 0.1 2019-06-06 00:06 yulong.sun Exp $
 */
public class OrderPrintTestCase1 {


    public static void main(String[] args) {
        OrderPrintTestCase1 testCase1 = new OrderPrintTestCase1();
        Thread a = new Thread(()-> {testCase1.print(0);},"A");
        Thread b = new Thread(()-> {testCase1.print(1);},"B");
        Thread c = new Thread(()-> {testCase1.print(2);},"C");
        a.start();
        b.start();
        c.start();

    }

    private int indexCount = 0;
    private int mod = 3;
    private int loop = 10;
    private static ReentrantLock lock = new ReentrantLock(true);

    private void print(int threadIndex) {
        for (int i = 0; i < loop; ) {
            try {
                lock.lock();
                if (indexCount % mod == threadIndex) {
                    System.out.println(Thread.currentThread().getName());
                    indexCount++;
                    i++;
                }
            } finally {
                lock.unlock();
            }
        }
    }


    //--------------------------------------------------------------------------------
    //
    //--------------------------------------------------------------------------------

    /**
     * ReentrantLock lock = new ReentrantLock(true);
     * Thread a = new PrintThread(0, "A", lock);
     * Thread b = new PrintThread(1, "B", lock);
     * Thread c = new PrintThread(2, "C", lock);
     * a.start();
     * b.start();
     * c.start();
     * <p>
     * 有问题的写法
     * <p>
     * 0-A
     * 1-B
     * 3-A
     * 4-B
     * 6-A
     * 7-B
     * 9-A
     * 10-B
     * 2-C
     * 12-A
     * 13-B
     * 5-C
     * 15-A
     * 16-B
     * 8-C
     * 18-A
     * 19-B
     * 11-C
     * 21-A
     * 22-B
     * 14-C
     * 24-A
     * 25-B
     * 17-C
     * 27-A
     * 28-B
     * 20-C
     * 23-C
     * 26-C
     * 29-C
     * <p>
     * Process finished with exit code 0
     */
    static class PrintThread extends Thread {
        private int count = 0;
        private int mod = 3;
        private int loop = 30;
        private int threadIndex;
        //需要是同一把锁
        private ReentrantLock lock;

        public PrintThread(int threadIndex, String name, ReentrantLock lock) {
            super(name);
            this.threadIndex = threadIndex;
            this.lock = lock;
        }

        @Override
        public void run() {
            while (count < loop) {
                try {
                    lock.lock();
                    if (count % mod == threadIndex) {
                        System.out.println(count + "-" + Thread.currentThread().getName());
                    }
                    count++;
                } finally {
                    lock.unlock();
                }
            }
        }
    }

}
