package win.yulongsun.demo.basic.thread;

/**
 * @author yulong.sun
 * @version OrderPrint2TestCase.java, v 0.1 2019-06-06 09:01 yulong.sun Exp $
 */
public class OrderPrint2TestCase {


    /**
     * thread.Join把指定的线程加入到当前线程，可以将两个交替执行的线程合并为顺序执行的线程。比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B。
     * @param args
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {

            System.out.println("T1");
        });
        Thread t2 = new Thread(() -> {

            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T2");
        });
        Thread t3 = new Thread(() -> {

            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T3");
        });
        t1.start();
        t2.start();
        t3.start();
    }



}
