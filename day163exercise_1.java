package day163;
//494. 目标和
public class day163exercise_1 {
    public int findTargetSumWays(int[] nums, int t) {
        int n = nums.length;
        int s = 0;
        for (int i : nums) s += Math.abs(i);
        if (t > s) return 0;
        int[][] f = new int[n + 1][2 * s + 1];
        f[0][0 + s] = 1;
        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];
            for (int j = -s; j <= s; j++) {
                if ((j - x) + s >= 0) f[i][j + s] += f[i - 1][(j - x) + s];
                if ((j + x) + s <= 2 * s) f[i][j + s] += f[i - 1][(j + x) + s];
            }
        }
        return f[n][t + s];
    }
}
