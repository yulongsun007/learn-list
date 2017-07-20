package 数据结构.排序.交换.冒泡排序;

/**
 * 冒泡排序
 * 时间复杂度：O(n^2)
 * 最优时间复杂度：O（n）
 * 空间复杂度：O(1)
 *
 * @author sunyulong on 2017/1/22.
 */
public class BubbleSort {


    public static void main(String[] args) {
        int[] table = new int[]{32, 26, 87, 72, 26, 17};
        bubbleSort(table);
        for (int i = 0; i < table.length; i++) {
            System.out.print(table[i] + " ");
        }
        System.out.println("");
        System.out.println("=======================================");
        bubbleSort2(table);
        for (int i = 0; i < table.length; i++) {
            System.out.print(table[i] + " ");
        }

    }

    /**
     * 普通冒泡排序
     *
     * @param table
     */
    public static void bubbleSort(int[] table) {
        for (int i = 1; i < table.length; i++) {
            //比较次数：指针从0开始
            for (int j = 0; j < table.length - i; j++) {
                if (table[j] > table[j + 1]) {
                    int temp = table[j];
                    table[j] = table[j + 1];
                    table[j + 1] = temp;
                }
            }
        }
    }


    /**
     * 冒泡排序改进
     *
     * @param table
     */
    public static void bubbleSort2(int[] table) {
        boolean exchange = true;    //如果exchange = false,说明不用继续交换
        for (int i = 1; i < table.length & exchange; i++) {
            exchange = false;
            //指针从0开始
            //比较次数为length-i
            for (int j = 0; j < table.length - i; j++) {
                if (table[j] > table[j + 1]) {
                    int temp = table[j];
                    table[j] = table[j + 1];
                    table[j + 1] = temp;
                    exchange = true;
                }
            }
        }
    }

}
