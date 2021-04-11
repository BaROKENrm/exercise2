package day109;

import java.util.Arrays;
import java.util.Scanner;

/*
给定一个 R 行 C 列的矩阵，表示一个矩形网格滑雪场。

矩阵中第 i 行第 j 列的点表示滑雪场的第 i 行第 j 列区域的高度。

一个人从滑雪场中的某个区域内出发，每次可以向上下左右任意一个方向滑动一个单位距离。

当然，一个人能够滑动到某相邻区域的前提是该区域的高度低于自己目前所在区域的高度。
 */
public class day109exercise_3 {
    static int N = 310;
    static int n,m;
    static int[][] h = new int[N][N];
    static int[][] f = new int[N][N];
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static  void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= m; j ++){
                h[i][j] = scan.nextInt();
            }
        }

        for(int i = 1; i <= n; i ++){
            Arrays.fill(f[i],-1);
        }

        int res = 0;
        for(int i = 1; i <= n; i ++){
            for(int j = 1;j <= m; j ++ ){
                res = Math.max(res,dp(i,j));
            }
        }
        System.out.println(res);
    }

    public static int dp(int x,int y){
        if(f[x][y] != -1){
            return f[x][y];
        }
        f[x][y] = 1;
        for(int i = 0; i < 4; i ++){
            int a = dx[i] + x;
            int b = dy[i] + y;
            if(a >= 1 && a <= n && b >= 1 && b <= m && h[a][b] < h[x][y]){
                f[x][y] = Math.max(f[x][y],dp(a,b) + 1);
            }
        }
        return f[x][y];
    }
}
