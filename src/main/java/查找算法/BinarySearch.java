package 查找算法;

/**
 * @Author: hqf
 * @description: 二分查找的递归与非递归实现 (适用于有序序列)
 * @Data: Create in 18:30 2020/2/2
 * @Modified By:
 */
public class BinarySearch {
    // 递归实现
    public static int search1(int []array, int low, int high, int key) {
        if (low>high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (array[mid] < key) {
            return search1(array, mid+1, high, key);
        } else if (array[mid] > key) {
            return search1(array, low, mid-1, key);
        } else {
            return mid;
        }
    }

    // 非递归实现
    public static int search2(int []array, int key) {
        int low = 0;
        int high = array.length-1;
        while (low <= high) {
            int mid = (low+high)/2;
//            int mid = low + (high-low)/2;
            if (array[mid] < key) {
                low = mid + 1;
            } else if (array[mid] > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int []array = new int[]{1, 4, 4, 4, 7, 8, 9};
//        System.out.println(search1(array, 0, array.length-1, 5));
        System.out.println(search2(array, 4));
    }
}
