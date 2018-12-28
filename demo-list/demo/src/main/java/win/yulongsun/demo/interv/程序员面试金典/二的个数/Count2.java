package win.yulongsun.demo.interv.程序员面试金典.二的个数;


import org.junit.Test;

public class Count2 {
    @Test
    public void test() {
        System.out.println(countNumberOf2s(Integer.MAX_VALUE));
    }

    public int countNumberOf2s(int n) {
        // write code here
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (contain2(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean contain2(int n) {
        String s = String.valueOf(n);
        if (s.contains("2"))
            return true;
        else
            return false;
    }

}