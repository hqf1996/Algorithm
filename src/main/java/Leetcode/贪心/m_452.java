package Leetcode.贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 10:20 2020/2/18
 * @Modified By:
 */
public class m_452 {
    public int findMinArrowShots(int[][] points) {
        // 思路：贪心策略为找到不连续的有多少个，也就是最后射出的箭的数量
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int []>() {
            @Override
            public int compare(int []o1, int []o2) {
                return o1[1]-o2[1];
            }
        });
        int tmp = points[0][1];
        int num = 1;
        for (int i = 1 ; i < points.length ; ++i) {
            if (points[i][0] > tmp) {
                tmp = points[i][1];
                num++;
            }
        }
        return num;
    }
}
