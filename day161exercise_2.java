package day161;
//1000. 合并石头的最低成本
public class day161exercise_2 {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) return -1;
        int[][] dp = new int[n + 1][n + 1];
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; ++i) sum[i] = sum[i - 1] + stones[i - 1];
        for (int len = k; len <= n; ++len) { // 枚举区间长度
            for (int i = 1; i + len - 1 <= n; ++i) { // 枚举区间起点
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int p = i; p < j; p += k - 1) {  // 枚举分界点
                    dp[i][j] = Math.min(dp[i][j], dp[i][p] + dp[p + 1][j]);
                }
                if ((j - i) % (k - 1) == 0) dp[i][j] += sum[j] - sum[i - 1];
            }
        }
        return dp[1][n];
    }
}
