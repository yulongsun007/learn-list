package 数据结构.排序.选择.堆排序;

/**
 * 堆排序
 * <p>
 * 堆是通过一维数组来实现的。堆排序是完全二叉树。
 * <p>
 * 性质：
 * 1. 父节点i的左子节点的位置是 i*2+1
 * 2. 父节点i的右子节点的位置是 i*2+2
 * 3. 子节点i的父节点的位置是 floor[(i-1)/2]
 * <p>
 * 步骤：
 * 1. 创建最大堆：将堆所有数据重新排序
 * 2. 堆排序： 移除位在第一个数据的跟节点，并做最大堆调整的递归运算。
 * <p>
 * 时间复杂度：
 * O(nlogn)
 *      - 建堆：o（n）
 *      - 调整：o（logn）
 *
 * 空间复杂度：
 * O(1)
 * 稳定性：
 * 不稳定
 *
 *
 *
 * @author sunyulong on 2017/1/22.
 */
public class HeapSort {

    private static int[] sort = new int[]{1, 0, 10, 20,11};
//    private static int[] sort = new int[]{1, 0, 10, 20, 3, 5, 6, 4, 9, 8, 12, 17, 34, 11};

    public static void main(String[] args) {
        //建堆
        buildMaxHeapify(sort);
        //调整
        heapSort(sort);
        print(sort);
    }


    /**
     * 创建最大堆
     *
     * @param data
     */
    public static void buildMaxHeapify(int[] data) {
        //没有子节点的才需要创建最大堆，从最后一个的父节点开始
        int parentIndex = getParentIndex(data.length - 1);

        //从尾端开始创建大顶堆
        for (int i = parentIndex; i >= 0; i--) {
            maxHeapify(data, data.length, i);
        }

    }

    /**
     * 创建最大堆
     *
     * @param data
     * @param heapSize 需要创建堆的大小R
     * @param index    当前需要创建堆的位置
     */
    public static void maxHeapify(int[] data, int heapSize, int index) {
        int leftChildIndex  = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);

        int largest = index;
        if (leftChildIndex < heapSize && data[index] < data[leftChildIndex]) {
            largest = leftChildIndex;
        }
        if (rightChildIndex < heapSize && data[largest] < data[rightChildIndex]) {
            largest = rightChildIndex;
        }

        //创建最大值后可能需要交换
        if (largest != index) {
            int temp = data[index];
            data[index] = data[largest];
            data[largest] = temp;
            maxHeapify(data, heapSize, largest);
        }


    }


    /**
     * 堆排序
     * 最大值放在末尾，排序后就是递增
     *
     * @param data
     */
    public static void heapSort(int[] data) {
        for (int i = data.length - 1; i > 0; i--) {
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            maxHeapify(data, i, 0);
        }
    }


    /**
     * 左子节点的位置，加法的优先级更高
     *
     * @param i
     * @return
     */
    public static int getLeftChildIndex(int i) {
        return (i << 1) + 1;
    }


    /**
     * 右子节点的位置
     *
     * @param i
     * @return
     */
    public static int getRightChildIndex(int i) {
        return (i << 1) + 2;
    }


    /**
     * 父节点的位置
     *
     * @param i
     * @return
     */
    public static int getParentIndex(int i) {
        return (i - 1) >> 1;
    }

    private static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

}
