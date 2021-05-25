package day150;

import java.util.Scanner;

/*
给定一个 n×n 的矩阵 a，其中第 i 行第 j 列的元素 aij 等于 i×j（1≤i,j≤n）。

现在，给定一个整数 m，请你计算 m 在矩阵中出现的次数。

输入格式
第一行一个整数 T，表示共有 T 组测试数据。

每组数据包含两个整数 n,m。

输出格式
每组数据输出一行一个结果，表示 m 在矩阵中出现的次数。

数据范围
1≤T≤20,
1≤n≤105,
1≤m≤109
 */
public class day150exercise_1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(T -- > 0){
            int n = scan.nextInt();
            int m = scan.nextInt();
            int res = 0;
            for(int i = n; i > 0; i --){
                if(m % i == 0 && m / i <= n){
                    res ++;
                }
            }
            System.out.println(res);
        }
    }
}
