package day165;

import java.util.Scanner;

public class day165exercise_1 {
    static int N = 1010;
    static int[][] f = new int[N][N];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int M = scan.nextInt();
        int k = scan.nextInt();
        for(int i = 1; i <= n; i ++){
            int v = scan.nextInt();
            int m = scan.nextInt();
            int w = scan.nextInt();
            for(int j = m; j >= v; j --){
                for(int x = k; x >= m; x --){
                    f[j][x] = Math.max(f[j][x],f[j - v][x - m] + v);
                }
            }
        }
        System.out.println(f[M][k]);
    }
}

