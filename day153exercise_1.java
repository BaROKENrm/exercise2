package day153;

import java.util.Arrays;
import java.util.Scanner;
/*
给定 n 个整数 a1,a2,…,an。

现在，请你从中挑选一些数，并将选出的数进行分组。

要求：

选出的数最多划分为 k 组（至少 1 组）。
同一组内，任意两数之差的绝对值不超过 5。
所选出的数尽可能多。
请问，最多可以选出多少个数进行分组？

输入格式
第一行包含两个整数 n 和 k。

第二行包含 n 个整数 a1,a2,…,an。

输出格式
输出一个整数，表示可以选出的最大整数数量。

数据范围
1≤k≤n≤5000,
1≤ai≤109
 */
public class day153exercise_1 {
    static int N = 5010;
    static int n, m;
    static int[] w = new int[N];
    static int[][] f = new int[N][N];
    //前i个中选k组的最大值
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for(int i = 1; i <= n; i ++){
            w[i] = scan.nextInt();
        }
        Arrays.sort(w, 1, n + 1);
        for(int i = 1, k = 1; i <= n; i ++){
            while(w[i] - w[k] > 5) k ++;
            for(int j = 1; j <= m; j ++){
                f[i][j] = Math.max(f[i - 1][j] , f[k - 1][j - 1] + (i - k + 1));
            }
        }
        System.out.println(f[n][m]);
    }
}
