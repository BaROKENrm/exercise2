package day121;

import java.util.Scanner;
/*
给定一个长度为 N 的数组，数组中的第 i 个数字表示一个给定股票在第 i 天的价格。

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
输入格式
第一行包含整数 N，表示数组长度。

第二行包含 N 个不超过 10000 的正整数，表示完整的数组。

输出格式
输出一个整数，表示最大利润。
 */
public class day121exercise_2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n + 1];
        for(int i = 1; i <= n; i ++){
            arr[i] = scan.nextInt();
        }

        int[][] f = new int[n + 1][3];
        for(int i = 0; i <= n; i ++){
            f[i][0] = Integer.MIN_VALUE;
            f[i][1] = Integer.MIN_VALUE;
        }
        for(int i = 1; i <= n; i ++){
            f[i][2] = Math.max(f[i - 1][2],f[i - 1][1]);
            f[i][1] = f[i - 1][0] + arr[i];
            f[i][0] = Math.max(f[i - 1][0],f[i - 1][2] - arr[i]);
        }

        System.out.println(Math.max(f[n][2],f[n][1]));
    }
}
