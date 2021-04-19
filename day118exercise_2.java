package day118;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
给定一个 n 个点 m 条边的有向图，图中可能存在重边和自环， 边权可能为负数。

请你求出 1 号点到 n 号点的最短距离，如果无法从 1 号点走到 n 号点，则输出 impossible。

数据保证不存在负权回路。

输入格式
第一行包含整数 n 和 m。

接下来 m 行每行包含三个整数 x,y,z，表示存在一条从点 x 到点 y 的有向边，边长为 z。

输出格式
输出一个整数，表示 1 号点到 n 号点的最短距离。

如果路径不存在，则输出 impossible。

数据范围
1≤n,m≤105,
图中涉及边长绝对值均不超过 10000。
 */
public class day118exercise_2 {
    static int N = 100010;
    static int INF = 0x3f3f3f3f;
    static int[] e = new int[N], h = new int[N], ne = new int[N], w = new int[N];
    static int index, n, m;
    static int[] dist = new int[N];
    static boolean[] flag = new boolean[N];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        Arrays.fill(h,-1);
        while(m -- > 0){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            add(a,b,c);
        }
        int res = spfa();
        if(res == -1){
            System.out.println("impossible");
        }
        else{
            System.out.println(res);
        }
    }
    public static int spfa(){
        Arrays.fill(dist,INF);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        dist[1] = 0;
        flag[1] = true;
        while(!queue.isEmpty()){
            int t = queue.poll();
            flag[t] = false;
            for(int i = h[t]; i != -1; i = ne[i]){
                int j = e[i];
                if(dist[j] > dist[t] + w[i]){
                    dist[j] = dist[t] + w[i];
                    if(!flag[j]){
                        flag[j] = true;
                        queue.offer(j);
                    }
                }
            }
        }
        if(dist[n] == INF){
            return -1;
        }
        return dist[n];
    }

    public static void add(int a,int b, int c){
        e[index] = b;
        ne[index] = h[a];
        w[index] = c;
        h[a] = index ++;
    }

}
