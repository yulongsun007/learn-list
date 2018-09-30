package win.yulongsun.demo.java.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author yulong.sun on 2018/9/30.
 */
public class Mutex {

    //自定义同步器
    private static class Sync extends AbstractQueuedSynchronizer {
        //当状态为0时，获取独占锁
        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                return true;
            }
            return false;
        }

        //释放锁，将状态设置为0
        @Override
        protected boolean tryRelease(int arg) {
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        //是否处于占用状态
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
    }

    //将操作到代理Sync上
    private final Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }

    public void tryLock() {
        sync.tryAcquire(1);
    }

    public void unlock() {
        sync.release(1);
    }

    public boolean isLocked() {
        return sync.isHeldExclusively();
    }

    public boolean hasQueuedThreads(){
        return sync.hasQueuedThreads();
    }

    public void lockInterruptibly() throws InterruptedException {
        //如果当前线程被中断，则会抛出一个Interruptibly异常
        sync.acquireInterruptibly(1);
    }

    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
        //在acquireInterruptibly基础上加了超时限制，如果在超时时间内没有返回同步状态，则返回false
       return sync.tryAcquireNanos(1,unit.toNanos(timeout));
    }

}
