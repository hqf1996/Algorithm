package Leetcode.贪心;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 17:12 2020/7/21
 * @Modified By:
 */
public class m_1353 {
    // 测试超时
//    public int maxEvents(int[][] events) {
//        Arrays.sort(events, new Comparator<int []>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1]!=o2[1] ? o1[1]-o2[1] : o1[0]-o2[0];
//            }
//        });
//        boolean[] isVisit = new boolean[100001];
//        for (int i = 0 ; i < events.length ; ++i) {
//            for (int j = events[i][0] ; j <= events[i][1] ; ++j) {
//                if (!isVisit[j]) {
//                    isVisit[j] = true;
//                    break;
//                }
//            }
//        }
//        int count = 0;
//        for (int i = 0 ; i < isVisit.length ; ++i) {
//            if (isVisit[i]) {
//                count++;
//            }
//        }
//        return count;
//    }

    public int maxEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int []>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int count = 0;
        int day = 1; // 天数
        int i = 0;
        int len = events.length;
        while (!queue.isEmpty() || i < len) {
            while (i < len && events[i][0] == day) {
                queue.add(events[i][1]);
                i++;
            }
            while (!queue.isEmpty() && queue.peek()<day) {
                queue.poll();
            }
            if (!queue.isEmpty()) {
                count++;
                queue.poll();
            }
            day++;
        }
        return count;
    }

}
