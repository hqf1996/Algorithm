package 排序算法;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: hqf
 * @description: 桶排序（比如：统计出现频率从小到大的数）
 * @Data: Create in 19:32 2020/2/15
 * @Modified By:
 */
public class BucketSort {
    public static void bucketSort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer each : nums) {
            if (map.get(each) == null) {
                map.put(each, 1);
            } else {
                map.put(each, map.get(each)+1);
            }
        }
        // 创建桶，下标代表出现的频率
        ArrayList<Integer>[] buckets = new ArrayList[nums.length+1];
        for (Integer each : map.keySet()) {
            int index = map.get(each);
            if (buckets[index] == null) {
                buckets[index] = new ArrayList<>();
            }
            buckets[index].add(each);
        }
        // 输出桶排序
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0 ; i < buckets.length-1 ; ++i) {
            if (buckets[i] != null) {
                for (int k = 0 ; k < buckets[i].size() ; ++k) {
                    result.add(buckets[i].get(k));
                }
            }
        }
        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        int []nums = new int[]{1, 2, 2, 5, 5, 5, 9, 1};
        bucketSort(nums);
    }
}
