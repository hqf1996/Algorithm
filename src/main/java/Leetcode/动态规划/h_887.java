package Leetcode.动态规划;

/**
 * @Author: hqf
 * @description:
 * @Data: Create in 20:21 2020/5/18
 * @Modified By:
 */
public class h_887 {
    public static void main(String[] args) {
        h_887 test = new h_887();
        System.out.println(test.superEggDrop(3, 14));
    }
    public int superEggDrop(int K, int N) {
        int[][] mem = new int[K+1][N+1];
        return dp(K, N, mem);
    }

    public int dp(int K, int N, int[][] mem) {
        if (K == 1) {
            return N;
        }
        if (N == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1 ; i <= N ; ++i) {
            res = Math.min(res, Math.max(dp(K-1, i-1, mem), dp(K, N-i, mem))+1);
        }
        mem[K][N] = res;
        return res;
    }
}
