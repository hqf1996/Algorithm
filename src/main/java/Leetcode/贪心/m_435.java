package Leetcode.贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 15:53 2020/2/17
 * @Modified By:
 */
public class m_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 贪心策略：只要一个区间结尾越小，则就可能组成更多的不重叠区间，最后用总区间减去这个最多不重叠区间即可。
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int []>() {
            @Override
            public int compare(int []o1, int []o2) {
                return o1[1]-o2[1];
            }
        });
        int tmp = intervals[0][1];
        int num = 1;
        for (int i = 1 ; i < intervals.length ; ++i) {
            if (intervals[i][0] >= tmp) {
                num++;
                tmp = intervals[i][1];
            }
        }
        return intervals.length - num;
    }
}
