package day166;
//518. 零钱兑换 II
public class day166exercise_1 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] f = new int[amount + 1];
        f[0] = 1;
        for(int i = 1; i <= n; i ++){
            int val = coins[i - 1];
            for(int j = val; j <= amount; j ++){
                f[j] += f[j - val];
            }
        }
        return f[amount];
    }
}
