package win.yulongsun.demo.basic.juc.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author Sun.YuLong on 2017/10/23.
 */
public class ThreadPoolCase {
    public static void main(String[] args) {

        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 10, 10, TimeUnit.MINUTES,
                new LinkedBlockingQueue<>(100), threadFactory);
        LinkedBlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
        poolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    blockingQueue.take();
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
            }
        });
//        try {
//            System.out.println(poolExecutor.awaitTermination(10L, TimeUnit.SECONDS));
            poolExecutor.shutdownNow();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
