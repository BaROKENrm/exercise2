package day151;

import java.util.Scanner;

/*
给定一个长度为 n 且不包含 0 的整数序列 a1,a2,…,an。

请你计算以下两值：

使得 al×al+1×…×ar 为负的索引对 (l,r)(l≤r) 的数量。
使得 al×al+1×…×ar 为正的索引对 (l,r)(l≤r) 的数量。
输入格式
第一行一个整数 n。

第二行包含 n 个整数 a1,…,an。

输出格式
共一行，输出单个空格隔开的两个整数，分别表示负的索引对数和正的索引对数。

数据范围
1≤n≤2×105,
−109≤ai≤109,ai≠0。
 */
public class day151exercise_2 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long a = 0;//正数和
        long b = 0;//负数和
        int c = 1;//正数
        int d = 0;//负数
        int s = 1;
        while(n -- > 0){
            int num = scan.nextInt();
            if(num < 0){
                s *= -1;
            }
            if(s < 0){
                a += d;
                b += c;
                d ++;
            }
            else{
                a += c;
                b += d;
                c ++;
            }
        }
        System.out.println(b + " " + a);
    }
}
