package win.yulongsun.demo.all.basic.juc.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author by sunyulong on 2017/1/第五部分.
 */
public class SemaphoreCase {

    public static void main(String[] args) {
        //参数：有多少个信号量
        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 5; i++) {
            Person person = new Person(semaphore, "person" + i);
            person.start();
        }
    }

}

class Person extends Thread {

    Semaphore semaphore;

    public Person(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        setName(name);
    }

    @Override
    public void run() {
        super.run();
        System.out.println(getName() + " is waiting");
        try {
            semaphore.acquire();        //获取信号量

            System.out.println(getName() + " is servicing");
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " is done ");
        semaphore.release();            //释放信号量
    }
}


