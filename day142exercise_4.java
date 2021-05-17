package day142;

import java.util.Scanner;

public class day142exercise_4 {
    static int N = 1010;
    static int[] f = new int[N];
    static int n, m;
    static int[] w = new int[N], v = new int[N];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for(int i = 1; i <= n; i ++){
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
        }

        for(int i = 1; i <= n; i ++){
            for(int j = v[i]; j <= m; j ++){

                f[j] = Math.max(f[j],f[j - v[i]] + w[i]);

            }
        }
        System.out.println(f[m]);
    }
}
