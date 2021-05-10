package day135;

import java.util.LinkedList;
import java.util.Queue;

//200. 岛屿数量

public class day135exercise_1 {
    Queue<int[]> queue = new LinkedList<>();
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    int n;
    int m;
    boolean[][] st;
    char[][] grid;
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        this.grid = grid;
        st = new boolean[n][m];
        int res = 0;
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j ++){
                if(grid[i][j] == '1' && !st[i][j]){
                    bfs(i,j);
                    res ++;
                }
            }
        }
        return res;
    }

    public void bfs(int i,int j){
        queue.add(new int[]{i,j});
        st[i][j] = true;
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int x = arr[0];
            int y = arr[1];
            for(int k = 0; k < 4; k ++){
                int a = x + dx[k];
                int b = y + dy[k];
                if(a < 0 || a >= n || b < 0 || b >= m || grid[a][b] == '0' || st[a][b]){
                    continue;
                }
                st[a][b] = true;
                queue.add(new int[]{a,b});
            }
        }
    }
}
