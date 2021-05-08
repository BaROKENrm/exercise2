package day133;

import java.util.Scanner;
//最长上升子序列
public class day133exercise_2 {
    static int N = 1010;
    static int[] f = new int[N], w = new int[N];
    static int n;
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for(int i = 1; i <= n; i ++){
            w[i] = scan.nextInt();
        }

        for(int i = 1; i <= n; i ++){
            f[i] = 1;
            for(int j = 1; j <= i; j ++){
                if(w[i] > w[j]){
                    f[i] = Math.max(f[i],f[j] + 1);
                }
            }
        }
        int max = 0;
        for(int i = 1; i <= n; i ++){
            max = Math.max(f[i],max);
        }
        System.out.println(max);
    }

}
