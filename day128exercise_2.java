package day128;

import java.util.Arrays;
import java.util.Scanner;
/*
给定一棵树，树中包含 n 个结点（编号1~n）和 n−1 条无向边，每条边都有一个权值。

现在请你找到树中的一条最长路径。

换句话说，要找到一条路径，使得使得路径两端的点的距离最远。

注意：路径中可以只包含一个点。

输入格式
第一行包含整数 n。

接下来 n−1 行，每行包含三个整数 ai,bi,ci，表示点 ai 和 bi 之间存在一条权值为 ci 的边。

输出格式
输出一个整数，表示树的最长路径的长度。

数据范围
1≤n≤10000,
1≤ai,bi≤n,
−105≤ci≤105
 */
public class day128exercise_2 {
    static int N = 10010;
    static int M = N * 2;
    static int n, res,index;
    static int[] e = new int[M], ne = new int[M], h = new int[M], w = new int[M];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        Arrays.fill(h,-1);
        for(int i = 0; i < n - 1; i ++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            add(a,b,c);
            add(b,a,c);
        }
        dfs(1,-1);
        System.out.println(res);
    }

    public static int dfs(int u, int f){
        int dist = 0;
        int d1 = 0, d2 = 0;
        for(int i = h[u]; i != -1; i = ne[i]){
            int j = e[i];
            if(j == f){
                continue;
            }
            int d = dfs(j,u) + w[i];
            dist = Math.max(d,dist);
            if(d >= d1){
                d2 = d1;
                d1 = d;
            }
            else if(d > d2){
                d2 = d;
            }
        }
        res = Math.max(res,d1 + d2);
        return dist;
    }

    public static void add(int a, int b,int c){
        e[index] = b;
        ne[index] = h[a];
        w[index] = c;
        h[a] = index ++;
    }
}
