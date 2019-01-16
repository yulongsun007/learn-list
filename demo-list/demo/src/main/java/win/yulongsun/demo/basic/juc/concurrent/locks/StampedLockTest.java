package win.yulongsun.demo.basic.juc.concurrent.locks;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.Collectors;

/**
 * 100 threads
 * 99 threads need Read
 * 1  threads need Write
 * <p>
 * StampedLock中的API包含了ReentrantLock、ReadWriteLock的基本功能
 * <p>
 * <p>
 * https://blog.takipi.com/java-8-stampedlocks-vs-readwritelocks-and-synchronized/
 *
 * @author Sun.YuLong on 2018/6/12.
 * @since JDK1.8
 */
public class StampedLockTest {
    private static StampedLock LOCK = new StampedLock();

    private static ArrayList<Long> DATA = new ArrayList<>();


    /**
     * 乐观读、悲观写
     *
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable readTask = () -> {
            for (; ; )
                read();
        };
        Runnable writeTask = () -> {
            for (; ; )
                write();
        };
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(writeTask);
    }

//    private static void read() {
//        long stamped = -1;
//        try {
//            //读 悲观锁
//            stamped = LOCK.readLock();
//            Optional.of(
//                    DATA.stream().map(String::valueOf).collect(Collectors.joining("#", "R-", ""))
//            ).ifPresent(System.out::println);
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            LOCK.unlock(stamped);
//        }
//    }

    private static void write() {
        long stamped = -1;
        try {
            //写 悲观锁
            stamped = LOCK.writeLock();
            DATA.add(System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlockWrite(stamped);
        }
    }

    private static void read() {
        // tryOptimisticRead 乐观读
        long stamped = LOCK.tryOptimisticRead();
        try {
            Optional<String> optional = Optional.of(DATA.stream().map(String::valueOf).collect(Collectors.joining("#", "R-", "")));
            if (!LOCK.validate(stamped)) { //如果读的时候没有发生写，则validate返回的是true
                stamped = LOCK.readLock(); //悲观读锁
                //重读
                optional = Optional.of(DATA.stream().map(String::valueOf).collect(Collectors.joining("#", "R-", "")));
            }
            optional.ifPresent(System.out::println);
            //
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock(stamped);
        }
    }


}
