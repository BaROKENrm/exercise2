package day138;

//1269. 停在原地的方案数
public class day138exercise_1 {
    public int numWays(int steps, int len) {
        int mod = 1000000007;

        int n = Math.min(steps,len - 1);
        int[][] f = new int[steps + 1][n + 1];
        f[0][0] = 1;
        for(int i = 1; i <= steps; i ++){
            for(int j = 0; j <= n; j ++){
                f[i][j] = f[i - 1][j];
                if(j >= 1){
                    f[i][j] = (f[i][j] + f[i - 1][j - 1]) % mod;
                }
                if(j < n){
                    f[i][j] = (f[i][j] + f[i - 1][j + 1]) % mod;
                }
            }
        }
        return f[steps][0];
    }
}
