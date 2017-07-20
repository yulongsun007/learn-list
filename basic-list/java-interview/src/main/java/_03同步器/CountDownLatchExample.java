package main.java._03同步器;

import java.util.concurrent.CountDownLatch;

/**
 * @author by sunyulong on 2017/1/第五部分.
 *         计数闩
 */
public class CountDownLatchExample {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);


        new Runner(latch, "A").start();
        new Runner(latch, "B").start();
        new Runner(latch, "C").start();
        for (int i = 3; i > 0; i--) {
            System.out.println(i);
            latch.countDown();      //计数减一
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Runner extends Thread {

    CountDownLatch latch;


    public Runner(CountDownLatch latch, String name) {
        this.latch = latch;
        setName(name);
    }

    @Override
    public void run() {
        super.run();
        try {
            latch.await();
            System.out.println(getName() + " do something ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
