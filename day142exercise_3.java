package day142;

import java.util.Scanner;

public class day142exercise_3 {
    static int N = 1010;
    static int[][] f = new int[N][N];
    static int n, m;
    static int[] v = new int[N], w = new int[N];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for(int i = 1; i <= n; i ++){
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
        }

        for(int i = 1; i <= n; i ++){
            for(int j = 0; j <= m; j ++){
                f[i][j] = f[i - 1][j];
                if(j >= v[i]){
                    f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - v[i]] + w[i]);
                }
            }
        }
        System.out.println(f[n][m]);
    }
}
