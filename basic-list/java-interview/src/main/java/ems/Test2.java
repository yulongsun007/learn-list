package ems;

import java.util.Scanner;

/**
 * Created by sunyulong on 2016/12/6.
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input n ");
        int n = scanner.nextInt();
        System.out.println("input i");
        int i = scanner.nextInt();
        System.out.println("input k");
        int k = scanner.nextInt();
        //初始化
        int[][] values = new int[n / 2][2];
        int initNum = 1;
        while (initNum <= n / 2) {
            values[initNum - 1][0] = initNum;
            initNum++;
        }
        while (initNum <= n) {
            values[n - initNum][1] = initNum;
            initNum++;
        }

        int outPutNum = 10;
        i = i - 2;
        i = i + k;
        while (outPutNum > 0) {
            i = i % 10;
            int j=0;
            int walk=0;
            while (j<k){
                walk = walk(i, values, n);
                if(walk!=0){
                    j++;
                    i++;
                }
            }
            outPutNum--;
            System.out.printf(walk+" ");

//            if (number != 0) {
//                outPutNum--;
//                i = i + k;
//                System.out.printf(number + "\t");
//            }else {
//                i=i+1;
//            }


        }
    }

    private static int walk(int i, int[][] values,int n) {
        int number = 0;
        if (i >= n / 2) {
            //换到第二行
            number = values[n-1-i][1];
        }
        if (i < n / 2) {
            //换到一个行
            number = values[i][0];
        }
        return number;
    }
}
