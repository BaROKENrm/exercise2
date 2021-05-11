package day136;

import java.util.Scanner;
/*
给定一个长度为 n 的正整数数列 a1,a2,…,an。

初始时，数列中的每个元素要么处于可选状态，要么处于不可选状态。

你可以选择一个长度恰好为 k 的区间 [i,i+k−1]，使得 ai∼ai+k−1 这 k 个元素的状态全部变为可选。

请问，在经过此操作后，所有处于可选状态的元素之和最大是多少。
 */
public class day136exercise_3 {
    static int N = 100010;
    static int[] a = new int[N], b = new int[N];
    static int n, m;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        long res = 0;
        for(int i = 1; i <= n; i ++) a[i] = scan.nextInt();

        for(int i = 1; i <= n; i ++){
            b[i] = scan.nextInt();
            if(b[i] == 1){
                res += a[i];
            }
        }

        long val = 0;
        long sum = 0;
        for(int i = 1; i <= n; i ++){
            if(b[i] == 0){
                sum += a[i];
            }

            if(i > m && b[i - m] == 0){
                sum -= a[i - m];
            }
            val = Math.max(sum,val);
        }
        System.out.println(res + val);
    }
}
