package day145;

public class day145exercise_2 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n < 1){
            return 0;
        }
        int[] f = new int[n];
        int price = prices[0];
        f[0] = 0;
        for(int i = 1; i < n; i ++){

            f[i] = Math.max(f[i - 1],prices[i] - price);
            price = Math.min(prices[i],price);
        }
        return f[n - 1];
    }
}
