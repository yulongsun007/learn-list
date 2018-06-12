package win.yulongsun.demo.java.juc.concurrent.locks;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * 使用Condition实现生产者消费者
 * <p>
 * 多线程模式下
 *
 * @author Sun.YuLong on 2018/4/10.
 */
public class ConditionTest {

    private static final Lock LOCK = new ReentrantLock();

    private static final Condition PRODUCER_COND = LOCK.newCondition();

    private static final Condition CONSUMER_COND = LOCK.newCondition();

    private static final LinkedList<Long> POOL = new LinkedList<>();

    public static final int MAX_CAPACITY = 100;

    public static void main(String[] args) {
//        IntStream.range(0, 6).boxed().forEach(ConditionTest::beginProduce);
//        IntStream.range(0, 10).boxed().forEach(ConditionTest::beginConsume);
        for (int i = 0; i < 6; i++) {
            ConditionTest.beginProduce(i);
        }
        for (int i = 0; i < 10; i++) {
            ConditionTest.beginConsume(i);
        }
    }


    private static void beginProduce(int i) {
        new Thread(() -> {
            for (; ; ) {
                produce();
                sleep(2);
            }
        }, "P-" + i).start();
    }

    private static void beginConsume(int i) {
        new Thread(() -> {
            for (; ; ) {
                consume();
                sleep(3);
            }
        }, "C-" + i).start();
    }

    private static void produce() {
        try {
            LOCK.lock();
            //缓存满了
            while (POOL.size() >= MAX_CAPACITY) {
                PRODUCER_COND.await();
            }
            //
            long value = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "-P-" + value);
            POOL.addLast(value);
            //
            CONSUMER_COND.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }


    private static void consume() {
        try {
            LOCK.lock();
            while (POOL.isEmpty()) {
                CONSUMER_COND.await();
            }
            //
            Long value = POOL.removeFirst();
            System.out.println(Thread.currentThread().getName() + "-C-" + value);
            //
            PRODUCER_COND.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }

    private static void sleep(long i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
