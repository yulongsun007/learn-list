package win.yulongsun.demo.spring.core.util;

import org.springframework.util.StopWatch;

/**
 * StopWatch
 * 作用 Spring提供的计数器
 * 使用场景 对于耗时任务的统计输出
 * @author Sun.YuLong on 2018/4/9.
 */
public class StopWatchTest {


    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch("测试任务");
        stopWatch.start("测试任务1");
        Thread.sleep(1000);
        stopWatch.stop();
        //
        stopWatch.start("测试任务2");
        Thread.sleep(2000);
        stopWatch.stop();
        //
        stopWatch.start("测试任务3");
        Thread.sleep(3000);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

        /**
         * StopWatch '测试任务': running time (millis) = 6001
         * -----------------------------------------
         * ms     %     Task name
         * -----------------------------------------
         * 01000  017%  测试任务1
         * 02001  033%  测试任务2
         * 03000  050%  测试任务3
         */
    }

}
