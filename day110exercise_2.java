package day110;

import java.util.Arrays;
//329. 矩阵中的最长递增路径
public class day110exercise_2 {
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    int n;
    int m;
    int[][] f;
    int[][] matrix;
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        n = matrix.length;
        m = matrix[0].length;
        int res = 0;
        f = new int[n][m];
        for(int i = 0; i < n; i ++){
            Arrays.fill(f[i],-1);
        }
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j ++){
                res = Math.max(res,dp(i,j));
            }
        }
        return res;
    }

    public int dp(int x,int y){
        if(f[x][y] != -1){
            return f[x][y];
        }
        f[x][y] = 1;
        for(int i = 0; i < 4; i ++){
            int a = dx[i] + x;
            int b = dy[i] + y;
            if(a >= 0 && a < n && b >= 0 && b < m && matrix[a][b] > matrix[x][y]){
                f[x][y] = Math.max(f[x][y],dp(a,b) + 1);
            }
        }
        return f[x][y];
    }
}
