package day104;

import java.util.Scanner;

/*
给定 n 个正整数，找出它们中出现次数最多的数。

如果这样的数有多个，请输出其中最小的一个。

输入格式
输入的第一行只有一个正整数 n，表示数字的个数。

输入的第二行有 n 个整数 s1,s2,…,sn。

相邻的数用空格分隔。

输出格式
输出这 n 个次数中出现次数最多的数。

如果这样的数有多个，输出其中最小的一个。

数据范围
1≤n≤1000,
1≤si≤10000
 */
public class day104exercise_1 {
    static int N = 10010;
    static  int[] num = new int[N];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while(n -- > 0){
            int x = scan.nextInt();
            num[x] ++;
        }
        int res = 0;
        for(int i = 0; i < N; i ++){
            if(num[i] > num[res]){
                res = i;
            }
        }
        System.out.println(res);
    }
}
