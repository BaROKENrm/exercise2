package day122;

import java.util.Arrays;
import java.util.Scanner;

/*
将 n 堆石子绕圆形操场排放，现要将石子有序地合并成一堆。

规定每次只能选相邻的两堆合并成新的一堆，并将新的一堆的石子数记做该次合并的得分。

请编写一个程序，读入堆数 n 及每堆的石子数，并进行如下计算：

选择一种合并石子的方案，使得做 n−1 次合并得分总和最大。
选择一种合并石子的方案，使得做 n−1 次合并得分总和最小。
输入格式
第一行包含整数 n，表示共有 n 堆石子。

第二行包含 n 个整数，分别表示每堆石子的数量。

输出格式
输出共两行：

第一行为合并得分总和最小值，

第二行为合并得分总和最大值。

数据范围
1≤n≤200
 */
public class day122exercise_1 {
    static int N = 410;
    static int[] w = new int[N], s = new int[N];
    static int[][] f = new int[N][N], a = new int[N][N];//f 是最大。 a是最小
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;

        for(int i = 1; i <= n; i ++){
            w[i] = scan.nextInt();
            w[i + n] = w[i];
        }

        for(int i = 1; i <= n * 2; i ++){
            Arrays.fill(f[i],MIN);
            Arrays.fill(a[i],MAX);
        }

        for(int i = 1; i <= n * 2; i ++){
            s[i] = s[i - 1] + w[i];
        }

        for(int len = 1; len <= n; len ++){
            for(int l = 1; l + len - 1 <= n * 2; l ++){
                int r = l + len - 1;
                if(len == 1){
                    f[l][r] = 0;
                    a[l][r] = 0;
                }
                else{
                    for(int k = l; k < r; k ++){
                        f[l][r] = Math.max(f[l][k], f[k + 1][r] + s[r] - s[l - 1]);
                        a[l][r] = Math.min(a[l][k], a[k + 1][r] + s[r] - s[l - 1]);
                    }

                }
            }
        }
        int min = MAX;
        int max = MIN;
        for(int i = 1; i <= n; i ++){
            max = Math.max(max,f[i][i + n - 1]);
            min = Math.min(min,a[i][i + n - 1]);
        }
        System.out.println(min);
        System.out.println(max);
    }
}
