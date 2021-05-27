package day152;

import java.util.Scanner;

public class day152exercise_5 {
    static int N = 3010;
    static int n;
    static int[][] f = new int[N][N];
    //所有由第一个序列的前i个数和第二个序列的前j个数构成的，并且以b[j]结尾的公共上升子序列的最大值
    static int[] a = new int[N], b = new int[N];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for(int i = 1; i <= n; i ++){
            a[i] = scan.nextInt();
        }

        for(int i = 1; i <= n; i ++){
            b[i] = scan.nextInt();
        }

        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= n; j ++){
                f[i][j] = f[i - 1][j];
                if(a[i] == b[j]){
                    f[i][j] = Math.max(f[i][j],1);
                    for(int k = 1; k < j; k ++){
                        if(b[j] > b[k]){
                            f[i][j] = Math.max(f[i][j], f[i][k] + 1);
                        }
                    }
                }
            }
        }
        int max = 0;
        for(int i = 1; i <= n; i ++){
            max = Math.max(f[n][i],max);
        }
        System.out.println(max);
    }
}
