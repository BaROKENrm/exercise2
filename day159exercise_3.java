package day158;

import java.util.Scanner;

/*
给定一个长度为 n 的数组 a 和一个长度为 m 的数组 b。

两个数组均只包含 0 和 1。

利用两个给定数组生成一个 n×m 的矩阵 c，其中 cij=ai×bj。

显然，矩阵 c 中也只包含 0 和 1。

请问，矩阵 c 中有多少个大小（面积）恰好为 k 且只包含 1 的子矩形？

子矩形是指矩阵中连续若干行和连续若干列的交集。

例如，考虑四个整数 x1,x2,y1,y2(1≤x1≤x2≤n,1≤y1≤y2≤m)，子矩形 c[x1…x2][y1…y2] 即为行 x1,x1+1,…,x2 和列 y1,y1+1,…,y2 的一个交集。

一个子矩形的大小（面积）等于它包含的数字个数。

输入格式
第一行包含三个整数 n,m,k。

第二行包含 n 个整数 a1,…,an，表示数组 a 中的元素。

第三行包含 m 个整数 b1,…,bm，表示数组 b 中的元素。

输出格式
输出满足条件的子矩形的总数量。
 */
public class day159exercise_3 {
    static int N = 40005;
    static int n, m, k;
    static int[] a = new int[N], b = new int[N], s1 = new int[N], s2 = new int[N];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        k = scan.nextInt();
        long res = 0;
        for(int i = 0; i < n; i ++) a[i] = scan.nextInt();
        for(int j = 0; j < m; j ++) b[j] = scan.nextInt();

        fun(a, s1, n);
        fun(b, s2, m);
        //System.out.println(Arrays.toString(s1));
        for(int i = 1; i <= n ; i ++){
            if(k % i != 0) continue;
            int j = k / i;
            if(j > m) continue;
            res += s1[i] * s2[j];
        }
        System.out.println(res);
    }

    public static void fun(int[] w, int[] s, int n){
        for(int i = 0, j = 0; i < n; i ++){
            if(w[i] == 1){
                j ++;
                s[1] ++;
                s[j + 1] --;
            }
            else{
                j = 0;
            }
        }
        for(int i = 1; i <= n; i ++){
            s[i] += s[i - 1];
        }
    }

}
