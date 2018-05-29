package win.yulongsun.demo.java.juc.concurrent.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author Sun.YuLong on 2018/5/11.
 */
public class BooleanLatch {


    class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected int tryAcquireShared(int arg) {
            return super.tryAcquireShared(arg);
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            setState(1);
            return super.tryReleaseShared(arg);
        }
    }
}
