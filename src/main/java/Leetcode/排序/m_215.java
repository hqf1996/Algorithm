package Leetcode.排序;

import java.util.*;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 15:42 2020/2/15
 * @Modified By:
 */
public class m_215 {
    public int findKthLargest(int[] nums, int k) {
        // 思路：思路1是用PriorityQueue来做，小顶堆堆顶即是返回的第k个。思路2是用快速选择排序。
        // 思路1：
        /**
         PriorityQueue<Integer> queue = new PriorityQueue<>();
         for (int i = 0 ; i < nums.length ; ++i) {
         queue.add(nums[i]);
         if (queue.size() > k) {
         queue.poll();
         }
         }
         return queue.peek();
         **/
        // 思路2:用快排的思路，但是快排在排序过程中需要分别对[low, mid]以及[mid, high]都做一次递归，
        // 这边只需要找到从小到大的第length-k个数即可，所以只要让枢纽的位置达到这个即可，即枢纽超过这个位置了就让high--,
        // 没超过就让low++。
        k = nums.length-k;
        int low = 0, high = nums.length-1;
        while (low < high) {
            int i = partition(nums, low, high);
            if (i == k) {
                break;
            } else if (i > k) {
                high--;
            } else {
                low++;
            }
        }
        return nums[k];
    }

    public int partition(int []nums, int low, int high) {
        int i = low;  //记录枢纽位置
        int flag = nums[low];
        while (low < high) {
            while (low < high && flag<= nums[high]) {
                high--;
            }
            while (low < high && flag>=nums[low]) {
                low++;
            }
            if (low < high) {
                swap(nums, low, high);
            }
        }
        swap(nums, low, i);
        return low;
    }

    public void swap(int []nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
