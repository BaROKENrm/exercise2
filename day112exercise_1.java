package day112;

import java.util.Arrays;
import java.util.Scanner;

/*
给定一个 n 个点 m 条边的有向图，图中可能存在重边和自环，所有边权均为正值。

请你求出 1 号点到 n 号点的最短距离，如果无法从 1 号点走到 n 号点，则输出 −1。

输入格式
第一行包含整数 n 和 m。

接下来 m 行每行包含三个整数 x,y,z，表示存在一条从点 x 到点 y 的有向边，边长为 z。

输出格式
输出一个整数，表示 1 号点到 n 号点的最短距离。

如果路径不存在，则输出 −1。
 */
public class day112exercise_1 {
    static int N = 510;
    static int n;
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];
    static boolean[] flag = new boolean[N];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        int m = scan.nextInt();
        Arrays.fill(dist,0x3f3f3f);
        for(int i = 1; i <= n; i ++){
            Arrays.fill(g[i],0x3f3f3f);
        }
        for(int i = 0; i < m; i ++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int val = scan.nextInt();
            g[a][b] = Math.min(g[a][b],val);
        }
        int ret = dijkstra();
        System.out.println(ret);
    }
    public static int dijkstra(){
        dist[1] = 0;

        for(int i = 0; i < n; i ++){
            int t = -1;
            for(int j = 1; j <= n; j ++){
                if(!flag[j] && ((t == -1) || dist[t] > dist[j])){
                    t = j;
                }
            }
            flag[t] = true;
            for(int k = 1; k <= n; k ++){
                dist[k] = Math.min(dist[k],dist[t] + g[t][k]);
            }
        }
        if(dist[n] == 0x3f3f3f){
            return -1;
        }
        return dist[n];
    }
}
