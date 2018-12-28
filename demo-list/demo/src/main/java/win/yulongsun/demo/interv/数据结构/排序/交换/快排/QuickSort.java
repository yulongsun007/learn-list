package win.yulongsun.demo.interv.数据结构.排序.交换.快排;

/**
 * 快速排序
 *
 * @author sunyulong on 2017/1/22.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] table = {38, 26, 97, 19, 66, 1, 5, 49};
        quickSort(table);
        for (int i = 0; i < table.length; i++) {
            System.out.print(table[i] + "\t");
        }
    }

    private static void quickSort(int[] table) {
        quickSort(table, 0, table.length - 1);
    }

    /**
     * 时间复杂度
     *      最好的情况下是：N(logN)
     *      最坏的情况下是：O(N^2)
     * @param table
     * @param begin
     * @param end
     */
    private static void quickSort(int[] table, int begin, int end) {
        if (begin < end) {
            int i   = begin;
            int j   = end;
            int vot = table[i];
            while (i != j) {
                // 尾指针向前移动
                while (i < j && table[j] >= vot) {
                    j--;
                }
                if (table[j] < vot) {
                    table[i++] = table[j];
                }
                // 头指针向后移动
                while (i < j && table[i] <= vot) {
                    i++;
                }
                if (table[i] > vot) {
                    table[j--] = table[i];
                }

            }
            table[i] = vot;
            //
            quickSort(table, begin, j - 1);
            quickSort(table, j + 1, end);
        }

    }


}
