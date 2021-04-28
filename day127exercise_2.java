package day127;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/*
农民 John 有很多牛，他想交易其中一头被 Don 称为 The Knight 的牛。

这头牛有一个独一无二的超能力，在农场里像 Knight 一样地跳（就是我们熟悉的象棋中马的走法）。

虽然这头神奇的牛不能跳到树上和石头上，但是它可以在牧场上随意跳，我们把牧场用一个 x，y 的坐标图来表示。

这头神奇的牛像其它牛一样喜欢吃草，给你一张地图，上面标注了 The Knight 的开始位置，树、灌木、石头以及其它障碍的位置，除此之外还有一捆草。

现在你的任务是，确定 The Knight 要想吃到草，至少需要跳多少次。

The Knight 的位置用 K 来标记，障碍的位置用 * 来标记，草的位置用 H 来标记。
 */
public class day127exercise_2 {
    static int N = 160;
    static int[][] dist = new int[N][N];
    static int n,m;
    static char[][] ch = new char[N][N];
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        String[] str = bf.readLine().split(" ");
        m = Integer.valueOf(str[0]);
        n = Integer.valueOf(str[1]);
        int x = 0;
        int y = 0;
        for(int i = 0; i < n; i ++){
            char[] c = bf.readLine().toCharArray();
            for(int j = 0; j < m; j ++){
                ch[i][j] = c[j];
                if(ch[i][j] == 'K'){
                    x = i;
                    y = j;
                }
            }
        }

        int res = bfs(x,y);
        System.out.println(res);
    }

    public static int bfs(int x, int y){

        for(int i = 0; i < n; i ++){
            Arrays.fill(dist[i],-1);
        }

        int[] dx = {-2,-1,1,2,2,1,-1,2};
        int[] dy = {1,2,2,1,-1,-2,-2,-1};
        Queue<int[]> queue = new LinkedList<>();
        dist[x][y] = 0;
        queue.offer(new int[]{x,y});
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int p = arr[0];
            int q = arr[1];
            for(int i = 0; i < 8; i ++){
                int a = p + dx[i];
                int b = q + dy[i];
                if(a < 0 || a >= n || b < 0 || b >= m) continue;
                if(dist[a][b] != -1) continue;
                if(ch[a][b] == '*') continue;
                if(ch[a][b] == 'H') return dist[p][q] + 1;

                queue.offer(new int[]{a,b});
                dist[a][b] = dist[p][q] + 1;
            }
        }
        return 0;
    }
}
