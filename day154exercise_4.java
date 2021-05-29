package day154;

import java.util.Arrays;
import java.util.Scanner;
/*
给定一个由 n 个整数组成的数组 a，其中 n 为奇数。

你可以对其进行以下操作：

选择数组中的一个元素（例如 ai），将其增加 1（即，将其替换为 ai+1）。
你最多可以进行 k 次操作，并希望该数组的中位数能够尽可能大。

奇数长度的数组的中位数是数组以非降序排序后的中间元素。

例如，数组 [1,5,2,3,5] 的中位数为 3。

输入格式
第一行包含两个整数 n 和 k。

第二行包含 n 个整数 a1,a2,…,an。

输出格式。
输出一个整数，表示通过操作可能得到的最大中位数。
 */
public class day154exercise_4 {
    static int N = 200010;
    static int[] w = new int[N];
    static int n, m;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for(int i = 0; i < n; i ++){
            w[i] = scan.nextInt();
        }
        Arrays.sort(w,0,n);
        long l = 0;
        long r = 2000000000;
        while(l < r){
            long mid = (l + r + 1) / 2;
            if(check(mid)){
                l = mid;
            }
            else{
                r = mid - 1;
            }
        }
        System.out.println(l);
    }
    public static boolean check(long mid){
        long res = 0;
        for(int i = n / 2; i <= n; i ++){
            if(w[i] < mid){
                res += mid - w[i];
            }
        }
        return res <= m;
    }
}
