package day115;

import java.util.Scanner;
/*
给定一个长度为 N 的数组，数组中的第 i 个数字表示一个给定股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class day115exercise_1 {
    static int N = 100010;
    static int n;
    static int[] f = new int[N];
    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            n = scan.nextInt();
            for(int i = 0; i < n; i ++){
                f[i] = scan.nextInt();
            }

            int res = 0;
            for(int i = 0; i < n - 1; i ++){
                res += Math.max(0,f[i + 1] - f[i]);
            }
            System.out.println(res);
        }
}
