package 数据结构.查找.二分查找;

/**
 * 二分查找，递归实现
 *
 * @author sunyulong on 2017/2/26.
 */
public class Main {


    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int target = 5;

        //递归实现
        System.out.println(binSearch(array, target));


        //非递归实现
        System.out.println(binSearch2(array, target, 0, array.length));


    }


    /**
     * 二分查找[非递归实现]
     *
     * @param array
     * @param target
     * @return 返回出现在数组中的位置
     */
    public static int binSearch(int[] array, int target) {
        int low  = 0;
        int high = array.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;

            if (array[mid] == target) {
                return mid + 1;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else if (array[mid] > target) {
                high = mid - 1;
            }
        }

        return -1;
    }


    /**
     * 二分查找[递归实现]
     * 时间复杂度O(logN)
     *
     * @param array
     * @param target
     * @return
     */
    public static int binSearch2(int[] array, int target, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == target) {
                return mid + 1;
            } else if (array[mid] < target) {
                return binSearch2(array, target, mid + 1, high);
            } else {
                return binSearch2(array, target, low, mid - 1);
            }
        }

        return -1;
    }


}
