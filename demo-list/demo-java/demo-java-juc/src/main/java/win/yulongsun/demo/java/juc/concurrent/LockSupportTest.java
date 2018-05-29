package win.yulongsun.demo.java.juc.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Sun.YuLong on 2018/5/11.
 */
public class LockSupportTest {

    public static void main(String[] args) {
        new MyThread(Thread.currentThread());
    }


    static class MyThread extends Thread {
        private Object thread;

        public MyThread(Object thread) {
            this.thread = thread;
        }

        @Override
        public void run() {

            //
            LockSupport.unpark((MyThread) thread);
        }
    }
}
