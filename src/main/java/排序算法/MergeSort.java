package 排序算法;

import java.util.Arrays;

/**
 * @Author: hqf
 * @description: 归并排序的递归与非递归实现
 * @Data: Create in 14:38 2020/2/2
 * @Modified By:
 */

public class MergeSort {
    // 递归实现
    /**
     * @param array 数组
     * @param low 数组第一个元素
     * @param high 数组最后一个元素
     */
    public static void mergeSort(int[] array, int low, int high) {
        int mid = (low + high)/2;
        if(low < high)
        {
            //递归地对左右两边进行排序
            mergeSort(array, low, mid);
            mergeSort(array, mid+1, high);
            //合并
            merge(array, low, mid, high);
        }
    }
    //merge函数实际上是将两个有序数组合并成一个有序数组
    //因为数组有序，合并很简单，只要维护几个指针就可以了
    private static void merge(int[] arr, int low, int mid, int high)
    {
        //temp数组用于暂存合并的结果
        int[] temp = new int[high - low + 1];
        //左半边的指针
        int i = low;
        //右半边的指针
        int j = mid+1;
        //合并后数组的指针
        int k = 0;

        //将记录由小到大地放进temp数组
        for(; i <= mid && j <= high; k++)
        {
            if(arr[i] < arr[j]) {
                temp[k] = arr[i++];
            }
            else {
                temp[k] = arr[j++];
            }
        }
        //接下来两个while循环是为了将剩余的（比另一边多出来的个数）放到temp数组中
        while(i <= mid) {
            temp[k++] = arr[i++];
        }

        while(j <= high) {
            temp[k++] = arr[j++];
        }

        //将temp数组中的元素写入到待排数组中
        for(int l = 0; l < temp.length; l++) {
            arr[low + l] = temp[l];
        }
    }

    // 非递归实现
    public static void MergeSort2(int[] arr)
    {
        int len = arr.length;
        int k = 1;
        while(k < len)
        {
            MergePass(arr, k, len);
            k *= 2; //先是2个2个归并，接着是4个4个，接着是8个8个，16个16个...
        }
    }

    // 将两个长度为k的数组进行归并排序
    public static void MergePass(int []array, int k, int length) {
        int i = 0;
        // 保证前面的能组成两两的归并
        while (i < length - 2*k + 1) {
            merge(array, i, i+k-1, i+2*k-1);
            i += 2*k;
        }
        // 剩下组不成归并的与之前的merge起来
        if (i < length-k) {
            merge(array, i, i+k-1, length-1);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{8, 2, 5, 1, 3, 9, 0};
//        mergeSort(array, 0, array.length-1);
//        System.out.println(Arrays.toString(array));

        MergeSort2(array);
        System.out.println(Arrays.toString(array));
    }
}
