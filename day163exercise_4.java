package day163;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
在的棋盘格状土地上盘踞着三个国家的若干股势力，上下左右相邻的属于同一个国家的土地被认为是同一股势力。现在想知道，土地上总共有多少股势力？
 */
public class day163exercise_4 {
    static int n, m;
    static char[][] ch;
    static boolean[][] st;
    static int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        ch = new char[n][m];
        st = new boolean[n][m];
        int res = 0;
        for(int i = 0; i < n; i ++){
            String s = scan.next();
            for(int j = 0; j < m; j ++){
                ch[i][j] = s.charAt(j);
            }
        }
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j ++){
                if(!st[i][j]){
                    bfs(i,j);
                    res ++;
                }
            }
        }
        System.out.println(res);

    }

    public static void bfs(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        st[i][j] = true;
        while(!queue.isEmpty()){
            int[] t = queue.poll();
            int x = t[0];
            int y = t[1];
            for(int k = 0; k < 4; k ++){
                int a = x + dx[k];
                int b = y + dy[k];
                if(a < 0 || a >= n || b < 0 || b >= m || st[a][b]){
                    continue;
                }
                if(ch[a][b] != ch[x][y]){
                    continue;
                }
                queue.offer(new int[]{a,b});
                st[a][b] = true;
            }
        }
    }
}
