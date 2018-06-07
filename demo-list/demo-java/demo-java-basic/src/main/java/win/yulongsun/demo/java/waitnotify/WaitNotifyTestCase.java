package win.yulongsun.demo.java.waitnotify;

import org.junit.Test;

/**
 * @author Sun.YuLong on 2018/6/4.
 */
public class WaitNotifyTestCase {

    /**
     * java.lang.IllegalMonitorStateException
     * at java.lang.Object.wait(Native Method)
     * at java.lang.Object.wait(Object.java:502)
     * at win.yulongsun.demo.java.waitnotify.WaitNotifyTestCase.testWaitNotify(WaitNotifyTestCase.java:13)
     * at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
     * at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
     * at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
     * at java.lang.reflect.Method.invoke(Method.java:498)
     * at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
     * at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
     * at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
     * at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
     * at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
     * at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
     * at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
     * at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
     * at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
     * at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
     * at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
     * at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
     * at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
     * at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
     * at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
     * at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)
     * at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)
     * at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)
     *
     * @throws InterruptedException
     */
    @Test
    public void testWaitNotify() throws InterruptedException {
        Object o = new Object();
        o.wait();
        o.notify();
    }


    @Test
    public void testWaitNotifyWithSync() throws InterruptedException {
        final Object o = new Object();
//        synchronized (o) {
//            System.out.println("wait");
//            o.wait();
//            System.out.println("notify");
//            o.notifyAll();
//            System.out.println("notify end");
//        }

        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    try {
                        o.wait();
                        System.out.println("wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    o.notify();
                    System.out.println("notify");
                }
            }
        }).start();

        System.out.println("...");
    }
}
