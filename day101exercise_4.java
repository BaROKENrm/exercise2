package day101;

import java.util.Scanner;

/**
 * 给定 n 组 ai,bi,pi，对于每组数据，求出 abiimodpi 的值。
 *
 * 输入格式
 * 第一行包含整数 n。
 *
 * 接下来 n 行，每行包含三个整数 ai,bi,pi。
 *
 * 输出格式
 * 对于每组数据，输出一个结果，表示 abiimodpi 的值。
 *
 * 每个结果占一行。
 *
 * 数据范围
 * 1≤n≤100000,
 * 1≤ai,bi,pi≤2×109
 */
public class day101exercise_4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while(n -- > 0){
            long a = scan.nextLong();
            long k = scan.nextLong();
            long p = scan.nextLong();
            System.out.println(fun(a,k,p));
        }
    }

    private static long fun(long a, long k, long p) {
        long res = 1;
        while(k != 0){
            if(k % 2 == 1){
                res = res * k % p;
            }
            k = k >> 1;
            a = a * a % p;
        }
        return res;
    }
}
