package 排序算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

/**
 * @Author: hqf
 * @description: 快排实现，这边用的是双指针法，也就是partition
 * @Data: Create in 16:25 2020/2/15
 * @Modified By:
 */
public class QuickSort {
    public void swap(int []nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int partition(int []nums, int low, int high) {
        int index = low;
        int flag = nums[index];   //设置第一个元素为枢纽元素
        while (low < high) {
            // 右往左找到一个比枢纽小的元素，注意这边要让high先走
            while (low<high && nums[high]>=flag) {
                high--;
            }
            // 左往右找到一个比枢纽大的元素
            while (low<high && nums[low]<=flag) {
                low++;
            }
            // 如果没有越过界限，则交换两个元素的位置
            if (low < high) {
                swap(nums, low, high);
            }
        }
        // 将枢纽元素放到最后一个位置上
        swap(nums, index, low);
        return low;
    }

    public void quicksort(int []nums, int low, int high) {
        if (low < high) {
            int i = partition(nums, low, high);
            quicksort(nums, low, i-1);
            quicksort(nums, i+1, high);
        }
    }

    public static void main(String[] args) {
        int []nums = new int[]{5, 2, 7, 8, 1, 2, 6};
        QuickSort qs = new QuickSort();
        qs.quicksort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
