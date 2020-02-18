package Leetcode.贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 11:44 2020/2/18
 * @Modified By:
 */
public class m_406 {
    public int[][] reconstructQueue(int[][] people) {
        // 贪心策略：按升高降序，k升序排序，然后按k插入第k个位置即可，这样就能保证
        Arrays.sort(people, new Comparator<int []>() {
            @Override
            public int compare(int []o1, int []o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int []> list = new ArrayList<>();
        for (int i = 0 ; i < people.length ; ++i) {
            list.add(people[i][1], people[i]);
        }
        return list.toArray(new int[people.length][]);
    }
}
