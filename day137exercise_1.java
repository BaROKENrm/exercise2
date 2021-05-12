package day137;
/*
给定一个长度为 m 的整数序列 a1,a2,…,am。

序列中每个元素的值 ai 均满足 1≤ai≤n。

当一个值为 i 的元素和一个值为 j 的元素相邻时，可以产生的收益为 wi,j。

现在，我们可以从序列中删除最多 k 个元素，删除一些元素后，原本不相邻的元素可能会变得相邻。

序列的收益和为所有相邻元素对产生的收益之和，例如一个长度为 3 的整数序列 1,3,2 的收益和为 w1,3+w3,2。

请问，通过利用删除操作，能够得到的序列的最大收益和是多少？

输入格式
第一行包含三个整数 n,k,m。

第二行包含 m 个整数 a1,a2,…,am。

接下来 n 行，每行包含 n 个整数，其中第 i 行第 j 列的数表示 wi,j。

输出格式
输出序列的最大收益和。

数据范围
对于 30% 的数据，1≤n,k,m≤20。
对于 100% 的数据，1≤n,k,m≤200，0≤wi,j≤107，1≤ai≤n。
数据保证 wi,j=wj,i，wi,i=0。
 */

import java.util.Arrays;
import java.util.Scanner;

public class day137exercise_1 {
    static int N = 210;
    static int[][] w = new int[N][N], f = new int[N][N];
    static int[] a = new int[N];
    static int n, m, k;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        k = scan.nextInt();
        m = scan.nextInt();
        for(int i = 1; i <= m; i ++){
            a[i] = scan.nextInt();
        }
        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= n; j ++){
                w[i][j] = scan.nextInt();
            }
        }
        for(int i = 0; i <= n; i ++){
            Arrays.fill(f[i],Integer.MIN_VALUE);
        }
        f[1][0] = 0;
        for(int i = 2; i <= m; i ++){
            for(int j = 0; j <= k; j ++){
                for(int u = 1; u < i; u ++){
                    if(j >= i - u - 1){
                        f[i][j] = Math.max(f[i][j], f[u][j - (i - u - 1)] + w[a[u]][a[i]]);
                    }
                }
            }
        }
        int max = 0;
        for(int i = 0; i <= k; i ++){
            max = Math.max(f[m][i],max);
        }
        System.out.println(max);
    }

}
