package day103;

import java.util.Scanner;

/*
有 N 种物品和一个容量是 V 的背包。

第 i 种物品最多有 si 件，每件体积是 vi，价值是 wi。

求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
输出最大价值。
 */
public class day103exercise_3 {
    static int N = 110;
    static int[] w = new int[N];
    static int[] v = new int[N];
    static int[] s = new int[N];
    static int[][] f = new int[N][N];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        for(int i = 0; i <= n; i ++){
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
            s[i] = scan.nextInt();
        }
        for(int i = 1; i <= n; i ++){
            for(int j = 0; j <= m; j ++){
                for(int k = 0; k <= s[i] && k * v[i] <= j; k ++){
                    f[i][j] = Math.max(f[i][j],f[i - 1][j - k * v[i]] + w[i]);
                }
            }
        }
        System.out.println(f[n][m]);
    }
}
