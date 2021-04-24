package day123;

import java.util.Scanner;

/*
一个整数总可以拆分为 2 的幂的和。

例如：7 可以拆分成

7=1+2+4,7=1+2+2+2,7=1+1+1+4,7=1+1+1+2+2,

7=1+1+1+1+1+2,7=1+1+1+1+1+1+1

共计 6 种不同拆分方式。

再比如：4 可以拆分成：4=4,4=1+1+1+1,4=2+2,4=1+1+2。

用 f(n) 表示 n 的不同拆分的种数，例如 f(7)=6。

要求编写程序，读入 n，输出 f(n)mod109。
 */
public class day123exercise_1 {
    static int N = 1000010;
    static int MOD = 1000000000;
    static int[] f = new int[N];
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        f[0] = 1;
        for(int i = 1; i <= n; i *= 2){
            for(int j = i; j <= n; j ++){
                f[j] = (f[j - i] + f[j]) % MOD;
            }
        }
        System.out.println(f[n]);
    }
}
