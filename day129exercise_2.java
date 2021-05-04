package day129;

import java.util.Arrays;
//1473 
public class day129exercise_2 {
    final int INF = 0x3f3f3f3f;

    public int minCost(int[] h, int[][] cost, int m, int n, int target) {
        int[][][] f = new int[m][target + 1][n + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j <= target; j++)
                Arrays.fill(f[i][j], INF);

        if (h[0] != 0) f[0][1][h[0]] = 0;
        else {
            for (int i = 1; i <= n; i++)
                f[0][1][i] = cost[0][i - 1];
        }

        for (int i = 1; i < m; i++)
            for (int j = 1; j <= target; j++) {
                if (h[i] != 0) {
                    int k = h[i];
                    for (int u = 1; u <= n; u++) {
                        if (u == k) f[i][j][k] = Math.min(f[i][j][k], f[i - 1][j][k]);
                        else f[i][j][k] = Math.min(f[i][j][k], f[i - 1][j - 1][u]);
                    }
                } else {
                    for (int k = 1; k <= n; k++)
                        for (int u = 1; u <= n; u++) {
                            if (u == k) f[i][j][k] = Math.min(f[i][j][k], f[i - 1][j][k] + cost[i][k - 1]);
                            else f[i][j][k] = Math.min(f[i][j][k], f[i - 1][j - 1][u] + cost[i][k - 1]);
                        }
                }
            }

        int res = INF;
        for (int i = 1; i <= n; i++) res = Math.min(res, f[m - 1][target][i]);
        return res == INF ? -1 : res;
    }
}
