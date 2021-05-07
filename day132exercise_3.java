package day132;

import java.util.Scanner;
/*
小明手里有n元钱全部用来买书，书的价格为10元，20元，50元，100元。

问小明有多少种买书方案？（每种书可购买多本）

输入格式
一个整数 n，代表总共钱数。

输出格式
一个整数，代表选择方案种数。
 */
public class day132exercise_3 {
    static int N = 1010;
    static int[] v = {0,10,20,50,100};
    static int m;
    static int[][] f = new int[5][N];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        m = scan.nextInt();
        f[0][0] = 1;
        for(int i = 1; i <= 4; i ++){
            for(int j = 0; j <= m; j ++){
                f[i][j] = f[i - 1][j];
                if(j >= v[i]){
                    f[i][j] += f[i][j - v[i]];
                }
            }
        }
        System.out.println(f[4][m]);
    }
}
