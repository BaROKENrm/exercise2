package day128;

import java.util.Arrays;
import java.util.Scanner;

public class day128exercise_1 {
    static int N = 510;
    static int[] dist = new int[N];
    static int n, m;
    static int max = 0x3f3f3f;
    static boolean[] st = new boolean[N];
    static int[][] g = new int[N][N];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();

        for(int i = 0; i <= n; i ++){
            Arrays.fill(g[i],max);
        }

        for(int i = 1; i <= m; i ++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            g[a][b] = Math.min(g[a][b],c);
        }
        int res = dijkstra();
        System.out.println(res);
    }

    public static int dijkstra(){
        Arrays.fill(dist,max);
        dist[1] = 0;
        for(int i = 0; i < n; i ++){
            int t = -1;
            for(int j = 1; j <= n; j ++){
                if(!st[j] && (t == -1 || dist[j] < dist[t])){
                    t = j;
                }
            }
            st[t] = true;

            for(int k = 1; k <= n; k ++){
                dist[k] = Math.min(dist[k],dist[t] + g[t][k]);
            }
        }

        if(dist[n] == max){
            return -1;
        }
        return dist[n];

    }
}
