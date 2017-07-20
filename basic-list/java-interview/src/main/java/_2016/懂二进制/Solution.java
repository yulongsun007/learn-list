package _2016.懂二进制;

/**
 * 世界上有10种人，一种懂二进制，一种不懂。那么你知道两个int32整数m和n的二进制表达，有多少个位(bit)不同么？
 * 输入例子:
 * 1999 2299
 * <p>
 * 输出例子:
 * 7
 */
public class Solution {
    /**
     * 获得两个整形二进制表达位数不同的数量
     *
     * @param m 整数m
     * @param n 整数n
     * @return 整型
     */
    public static int countBitDiff(int m, int n) {

        //先将两者做异或运算
        int diff  = m ^ n;
        int count = 0;

        //统计一个整数diff含有多少个1；
        while (diff != 0) {
            diff = diff & (diff - 1);
            count++;
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println(countBitDiff(1, 2));
    }
}