package day150;

import java.util.Scanner;

public class day150exercise_2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(T -- > 0){
            int n = scan.nextInt();
            int m = scan.nextInt();
            int[][] w = new int[n][m];
            for(int i = 0; i < n; i ++){
                for(int j = 0; j < m; j ++){
                    w[i][j] = scan.nextInt();
                }
            }
            long res = 0;
            for(int i = 0; i < n; i ++){
                for(int j = 0; j < m; j ++){
                    int a = w[i][j];
                    int b = w[n - i - 1][j];
                    int c = w[i][m - j - 1];
                    int d = w[n - i - 1][m - j - 1];
                    int mid = Math.max(Math.max(a,b),Math.max(c,d));
                    res += Math.abs(a - mid) + Math.abs(b - mid) + Math.abs(c - mid) + Math.abs(d - mid);
                }
            }
            System.out.println(res / 4);
        }
    }
}
