package Leetcode.搜索;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 16:16 2020/2/24
 * @Modified By:
 */
public class m_547 {
    public int findCircleNum(int[][] M) {
        // dfs
        int count = 0;
        int m = M.length;
        if (m == 0) {
            return 0;
        }
        int[] flag = new int[m];
        for (int i = 0 ; i < m ; ++i) {
            if (flag[i]==0) {
                dfs(M, flag, i, m);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] M, int[] flag, int i, int m) {
        flag[i] = 1;
        for (int k = 0 ; k < m ; ++k) {
            if (M[i][k] == 1 && flag[k] == 0) {
                dfs(M, flag, k, m);
            }
        }
    }
}
