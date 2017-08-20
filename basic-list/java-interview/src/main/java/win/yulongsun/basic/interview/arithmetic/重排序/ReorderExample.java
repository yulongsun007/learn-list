package win.yulongsun.basic.interview.arithmetic.重排序;

/**
 * @author by sunyulong on 2017/1/第五部分.
 *         重排序
 */
public class ReorderExample {
    int     a    = 0;
    boolean flag = false;

    public void writer() {
        a = 1;              //操作1
        flag = true;        //操作2
    }

    public void reader() {
        if (flag) {         //操作3
            int i = a * a;  //操作4
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        final ReorderExample reorderExample = new ReorderExample();


        for (int i = 0; i < 10; i++) {
            Thread threadA = new Thread(new Runnable() {
                @Override
                public void run() {
                    reorderExample.writer();
                }
            });
            threadA.start();

            Thread threadB = new Thread(new Runnable() {
                @Override
                public void run() {
                    reorderExample.reader();
                }
            });
            threadB.start();
        }

    }


}
