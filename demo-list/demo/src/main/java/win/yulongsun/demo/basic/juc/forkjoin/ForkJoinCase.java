package win.yulongsun.demo.basic.juc.forkjoin;


import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

/**
 * Created by Sun.Yulong on 2017/8/20.
 */
public class ForkJoinCase {

    public static void main(String[] args) {

    }


    public static class CalRecursiveTask extends RecursiveTask<Integer> {
        private static final int MAX_THRESHOLD = 3;
        private final int start;
        private final int end;

        public CalRecursiveTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        protected Integer compute() {
            if (end - start <= MAX_THRESHOLD) {
                return IntStream.rangeClosed(start, end).sum();
            } else {
                int mid = (start + end) / 2;
                CalRecursiveTask leftTask = new CalRecursiveTask(start, mid);
                CalRecursiveTask rightTask = new CalRecursiveTask(mid + 1, end);
                //
                leftTask.fork();
                leftTask.fork();
                //
                return leftTask.join() + rightTask.join();
            }
        }
    }
}
