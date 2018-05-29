package win.yulongsun.demo.java.juc.unsafe;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Sun.YuLong on 2018/4/8.
 */
public class UnSafeTest {


    //------------------------------------------------------------------------
    // 1.通过Unsafe内置的getUnsafe()获取对象，异常
    //------------------------------------------------------------------------
    @Test
    public void testGetUnsafe() {
        Unsafe unsafe = Unsafe.getUnsafe();
        System.out.println(unsafe);
        /**
         * Exception in thread "main" java.lang.SecurityException: Unsafe
         * 	at sun.misc.Unsafe.getUnsafe(Unsafe.java:90)
         * 	at win.yulongsun.demo.java.juc.unsafe.UnSafeTest.main(UnSafeTest.java:11)
         */
    }


    //------------------------------------------------------------------------
    // 2. 通过反射获取theUnsafe
    //------------------------------------------------------------------------
    //通过反射获取theUnsafe
    @Test
    public void testGetUnsafeByReflect() {
        Unsafe unsafe = getUnsafe();
        System.out.println(unsafe);
        /**
         *sun.misc.Unsafe@6ae40994
         */
    }

    private static Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            //访问私有
            field.setAccessible(true);
            //因为获取的是静态方法，所以传null
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //------------------------------------------------------------------------
    // 3.测试各种Counter方案性能对比
    //------------------------------------------------------------------------

    interface Counter {
        void increment();

        Long getCounter();
    }

    class CounterRunnable implements Runnable {

        private Counter counter;
        private int     num;

        public CounterRunnable(Counter counter, int num) {
            this.counter = counter;
            this.num = num;
        }

        public void run() {
            for (int i = 0; i < num; i++) {
                counter.increment();
            }
        }
    }

    class StupidCounter implements Counter {
        private Long counter = 0L;

        public void increment() {
            counter++;
        }

        public Long getCounter() {
            return counter;
        }
    }

    class SyncCounter implements Counter {

        private Long counter = 0L;

        public synchronized void increment() {
            counter++;
        }

        public Long getCounter() {
            return counter;
        }
    }

    class LockCounter implements Counter {

        private       Long counter = 0L;
        private final Lock lock    = new ReentrantLock();

        public void increment() {
            try {
                lock.lock();
                counter++;
            } finally {
                lock.unlock();
            }
        }

        public Long getCounter() {
            return counter;
        }
    }

    class AtomicCounter implements Counter {

        private AtomicLong atomicLong = new AtomicLong();

        public void increment() {
            atomicLong.incrementAndGet();
        }

        public Long getCounter() {
            return atomicLong.get();
        }
    }

    class CasCounter implements Counter {

        private Long counter = 0L;

        private Unsafe unsafe;

        private long offset;

        public CasCounter() throws NoSuchFieldException {
            unsafe = getUnsafe();//拿出unsafe
            offset = unsafe.objectFieldOffset(CasCounter.class.getDeclaredField("counter"));
        }

        public void increment() {
            long current = counter;
            while (!unsafe.compareAndSwapLong(this, offset, current, current + 1)) {
                current = counter;
            }
        }

        public Long getCounter() {
            return counter;
        }
    }

    @Test
    public void testCounter() throws InterruptedException, NoSuchFieldException {
        /**
         * 测试数据基于jdk1.8.0
         *
         * StupidCounter:
         *  result is 8474462
         *  time is 384
         *
         * SyncCounter:
         *   result is 10000000
         *   time is 559
         *
         * LockCounter:
         *  result is 10000000
         *  time is 666
         *
         *AtomicCounter:
         *  result is 10000000
         *  time is 511
         *
         */
        long            start           = System.currentTimeMillis();
        Counter         counter         = new CasCounter();
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new CounterRunnable(counter, 10000));
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        long end = System.currentTimeMillis();
        System.out.println("result is " + counter.getCounter());
        System.out.println("time is " + (end - start));

    }


}
