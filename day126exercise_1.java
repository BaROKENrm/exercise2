package day126;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*
FGD小朋友特别喜欢爬山，在爬山的时候他就在研究山峰和山谷。

为了能够对旅程有一个安排，他想知道山峰和山谷的数量。

给定一个地图，为FGD想要旅行的区域，地图被分为 n×n 的网格，每个格子 (i,j) 的高度 w(i,j) 是给定的。

若两个格子有公共顶点，那么它们就是相邻的格子，如与 (i,j) 相邻的格子有(i−1,j−1),(i−1,j),(i−1,j+1),(i,j−1),(i,j+1),(i+1,j−1),(i+1,j),(i+1,j+1)。

我们定义一个格子的集合 S 为山峰（山谷）当且仅当：

S 的所有格子都有相同的高度。
S 的所有格子都连通。
对于 s 属于 S，与 s 相邻的 s′ 不属于 S，都有 ws>ws′（山峰），或者 ws<ws′（山谷）。
如果周围不存在相邻区域，则同时将其视为山峰和山谷。
你的任务是，对于给定的地图，求出山峰和山谷的数量，如果所有格子都有相同的高度，那么整个地图即是山峰，又是山谷。

输入格式
第一行包含一个正整数 n，表示地图的大小。

接下来一个 n×n 的矩阵，表示地图上每个格子的高度 w。

输出格式
共一行，包含两个整数，表示山峰和山谷的数量。
 */
public class day126exercise_1 {
    static int N = 1010;
    static int n;
    static boolean[][] st = new boolean[N][N];
    static int[][] h = new int[N][N];
    static boolean higher;
    static boolean lower;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        n = Integer.valueOf(bf.readLine());
        for(int i = 0; i < n; i ++){
            String[] s = bf.readLine().split(" ");
            for(int j = 0; j < n; j ++){
                h[i][j] = Integer.valueOf(s[j]);
            }
        }
        int valley = 0;
        int peak = 0;
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                higher = false;
                lower = false;
                if(!st[i][j]){
                    bfs(i,j);
                    if(!higher){
                        peak ++;
                    }
                    if(!lower){
                        valley ++;
                    }
                }
            }
        }
        System.out.println(peak + " " + valley);
    }

    public static void bfs(int x ,int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        st[x][y] = true;
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int a = arr[0];
            int b = arr[1];
            for(int i = a - 1; i <= a + 1; i ++){
                for(int j = b - 1; j <= b + 1; j ++){
                    if(a == i && b == j){
                        continue;
                    }
                    if(i < 0 || i >= n || j < 0 || j >= n){
                        continue;
                    }
                    if(h[i][j] != h[a][b]){
                        if(h[i][j] > h[a][b]){
                            higher = true;
                        }
                        else{
                            lower = true;
                        }
                    }
                    else if(!st[i][j]){
                        queue.offer(new int[]{i,j});
                        st[i][j] = true;
                    }
                }

            }
        }
    }
}
