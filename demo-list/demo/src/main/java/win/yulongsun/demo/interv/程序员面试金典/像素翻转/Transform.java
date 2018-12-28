package win.yulongsun.demo.interv.程序员面试金典.像素翻转;

import org.junit.Test;

public class Transform {

    @Test
    public void testTrans() {
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] ints = transformImage(mat, 3);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j]);
            }
            System.out.println();
        }
    }

    public int[][] transformImage(int[][] mat, int n) {
        /**
         * 思路：
         * 1. 数字代码ascii码 转成字符串
         * 2. tmp每一个存 一行的像素字符串
         * 3.
         *
         * 注意：
         * 1. asscii-> char  :(char) mat[i][j]
         * 2. char -> asscii :
         */
        String[] tmp = new String[n];
        for (int i = 0; i < mat.length; i++) {
            char[] tmpChar = new char[mat[i].length];
            for (int j = 0; j < mat[i].length; j++) {
                tmpChar[j] = (char) mat[i][j];
            }
            String Line = new String(tmpChar);
//            String Line = tmpChar.toString();

            tmp[i] = Line;
        }


        //方法一
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = mat[i].length - 1; j >= 0; j--) {
//                char[] chars = tmp[mat[i].length - 1 - j].toCharArray();
//                mat[i][j] = chars[i];
//            }
//        }
        //方法二
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                //取出行
                char[] chars = tmp[mat[i].length - 1 - j].toCharArray();
                mat[i][j] = chars[i];
            }
        }
        return mat;
    }
}