package day156;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/*
给定一个 N 行 M 列的 01 矩阵 A，A[i][j] 与 A[k][l] 之间的曼哈顿距离定义为：

dist(A[i][j],A[k][l])=|i−k|+|j−l|
输出一个 N 行 M 列的整数矩阵 B，其中：

B[i][j]=min1≤x≤N,1≤y≤M,A[x][y]=1dist(A[i][j],A[x][y])
输入格式
第一行两个整数 N,M。

接下来一个 N 行 M 列的 01 矩阵，数字之间没有空格。

输出格式
一个 N 行 M 列的矩阵 B，相邻两个整数之间用一个空格隔开。

数据范围
1≤N,M≤1000
 */
public class day156exercise_2 {
    static int N = 1005;
    static char[][] ch = new char[N][N];
    static int[][] dist = new int[N][N];
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int n,m;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception{
        String[] s = bf.readLine().split(" ");
        n = Integer.valueOf(s[0]);
        m = Integer.valueOf(s[1]);
        for(int i = 0; i < n; i ++){
            String str = bf.readLine();
            for(int j = 0; j < m; j ++){
                ch[i][j] = str.charAt(j);
            }
        }
        bfs();

        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j ++){
                System.out.printf("%d ",dist[i][j]);
            }
            System.out.println(" ");
        }
    }

    public static void bfs(){
        for(int i = 0; i < n; i ++){
            Arrays.fill(dist[i],-1);
        }

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j ++){
                if(ch[i][j] == '1'){
                    queue.offer(new int[]{i,j});
                    dist[i][j] = 0;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] t = queue.poll();
            int a = t[0];
            int b = t[1];
            for(int i = 0; i < 4; i ++){
                int x = a + dx[i];
                int y = b + dy[i];
                if(dist[x][y] != -1){
                    continue;
                }
                if(x < 0 || x >= n || y < 0 || y >= m){
                    continue;
                }
                queue.offer(new int[]{x,y});
                dist[x][y] = dist[a][b] + 1;
            }
        }
    }
}
