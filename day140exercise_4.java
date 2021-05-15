package day140;

import java.util.Arrays;
import java.util.Scanner;

public class day140exercise_4 {
    static int N = 510;
    static int[][] g = new int[N][N];
    static int n, m;
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for(int i = 1; i <= n; i ++){
            Arrays.fill(g[i],Integer.MAX_VALUE);
        }

        while(m -- > 0){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            g[a][b] = g[b][a] = Math.min(c,g[a][b]);
        }

        int res = prim();
        if(res == Integer.MAX_VALUE) System.out.println("impossible");
        else System.out.println(res);
    }

    public static int prim(){
        Arrays.fill(dist,Integer.MAX_VALUE);
        int res = 0;
        for(int i = 0; i < n; i ++){
            int t = -1;
            for(int j = 1; j <= n; j ++){
                if(!st[j] && (t == -1 || dist[t] > dist[j])){
                    t = j;
                }
            }
            if(i != 0 && dist[t] == Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(i != 0) res += dist[t];
            for(int j = 1; j <= n; j ++){
                dist[j] = Math.min(dist[j],g[t][j]);
            }
            st[t] = true;
        }
        return res;
    }
}
