package win.yulongsun.demo.interv.程序员面试金典.清除行列;

import org.junit.Test;

/**
 * Created by : yulongsun
 * Date on : 2016/9/9
 * Desc : 清除行列
 * 请编写一个算法，若N阶方阵中某个元素为0，则将其所在的行与列清零。
 * 给定一个N阶方阵int[][](C++中为vector>)mat和矩阵的阶数n，请返回完成操作后的int[][]方阵(C++中为vector>)，保证n小于等于300，矩阵中的元素为int范围内。
 * 测试样例：
 * [[1,2,3],[0,1,2],[0,0,1]]
 * 返回：[[0,0,3],[0,0,0],[0,0,0]]
 */
public class Clearer {
    public int[][] clearZero(int[][] mat, int n) {
        //copy array
        int[][] result = new int[n][n];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                result[i][j]=mat[i][j];
            }
        }
        //遍历mat,将mat中i,j对应在result中的行列清除。
        //不再原矩阵中清除，是因为防止清除后的干扰
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    for (int a = 0; a < mat.length; a++) {
                        result[a][j] = 0;
                    }
                    for (int b = 0; b < mat[i].length; b++) {
                        result[i][b] = 0;
                    }
                }
            }
        }
        return result;
    }


    @Test
    public void testClearZero() {
        int mat[][] = {{1, 2, 3}, {0, 1, 2}, {0, 0, 1}};
        int[][] clearZero = clearZero(mat, 3);
        for (int i = 0; i < clearZero.length; i++) {
            for (int j = 0; j < clearZero[i].length; j++) {
                System.out.printf(clearZero[i][j] + "");
            }
            System.out.println();
        }
    }
}
