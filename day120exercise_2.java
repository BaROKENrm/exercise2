package day120;
/*
给定一个长度为 N 的数组，数组中的第 i 个数字表示一个给定股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润，你最多可以完成 k 笔交易。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。一次买入卖出合为一笔交易。

输入格式
第一行包含整数 N 和 k，表示数组的长度以及你可以完成的最大交易数量。

第二行包含 N 个不超过 10000 的正整数，表示完整的数组。

输出格式
输出一个整数，表示最大利润。

 */
import java.util.*;
public class day120exercise_2 {

        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            int k = scan.nextInt();
            int[] arr = new int[n + 1];
            int[][][] f = new int[n + 1][k + 1][2];
            for(int i = 1; i <= n; i ++){
                arr[i] = scan.nextInt();
            }
            for(int i = 0; i <= n; i ++){
                f[i][0][0] = 0;
            }
            for(int i = 0; i <= n; i ++){
                for(int j = 0; j <= k; j ++){
                    f[i][j][1] = Integer.MIN_VALUE;
                }
            }
            for(int i = 1; i <= n; i ++){
                for(int j = 1; j <= k; j ++){
                    f[i][j][0] = Math.max(f[i - 1][j][0],f[i - 1][j][1] + arr[i]);
                    f[i][j][1] = Math.max(f[i - 1][j][1],f[i - 1][j - 1][0] - arr[i]);
                }
            }
            int res = 0;
            for(int i = 0;i <= k; i ++){
                res = Math.max(res,f[n][i][0]);
            }
            System.out.println(res);
        }
}
