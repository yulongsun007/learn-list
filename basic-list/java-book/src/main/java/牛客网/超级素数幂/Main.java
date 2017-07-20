package 牛客网.超级素数幂;

import java.util.Scanner;

/**
 * @author sunyulong on 2017/3/7.
 */
public class Main {


    public static void main(String[] args) {
        Scanner sc   = new Scanner(System.in);
        int     n    = sc.nextInt();
        int[]   pq   = new int[2];
        boolean flag = false;


        //边界
        if (n < 2 || n > Math.pow(10, 18)) {
            System.out.println("No");
            return;
        }

        for (int i = 2; i <= 10; i++) {
            for (int j = 2; j <= 18; j++) {
                if ((Math.pow(i, j) == n) && isSusu(i)) {
                    pq[0] = i;
                    pq[1] = j;
                    flag = true;
                    break;
                }
            }
        }
        if (flag) {
            System.out.println(pq[0] + " " + pq[1]);
        } else {
            System.out.println("No");
        }
    }

    private static boolean isSusu(int a) {
        boolean flag = true;

        if (a < 2) {// 素数不小于2
            return false;
        } else {

            for (int i = 2; i <= Math.sqrt(a); i++) {

                if (a % i == 0) {// 若能被整除，则说明不是素数，返回false

                    flag = false;
                    break;// 跳出循环
                }
            }
        }
        return flag;
    }
}
