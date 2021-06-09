package day164;

import java.util.Scanner;
/*
现在有 a 个苹果，b 个香蕉，c 个橘子。

你要将这些水果分给尽可能多的小朋友。

假设一个小朋友分到的苹果数量为 x，香蕉数量为 y，橘子数量为 z。

在分发水果时，需要满足：

每个小朋友至少要分到一个水果，即 x+y+z≥1。
每个小朋友分到的苹果数量不得超过 1，香蕉数量不得超过 1，橘子数量不得超过 1，即 0≤x,y,z≤1。
任意两个小朋友分到的水果均不完全相同，即所有三元组 (x,y,z) 互不相同。
请问，最多可以将水果分给多少个小朋友。

输入格式
第一行包含整数 T，表示共有 T 组测试数据。

每组数据占一行，包含三个整数 a,b,c。

输出格式
每组数据输出一行结果，表示可以分到水果的小朋友的最大数量。
 */
public class day164exercise_2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int[][] w = {
                {0,0,1},
                {0,1,0},
                {1,0,0},
                {0,1,1},
                {1,1,0},
                {1,1,1},
                {1,0,1}
        };
        while(T -- > 0){
            int res = 0;
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            for(int i = 0; i < (1 << 7); i ++){
                int sa = 0, sb = 0, sc = 0, count = 0;
                for(int j = 0; j < 7; j ++){
                    int num = i >> j;
                    if((num & 1) == 1){
                        sa += w[j][0];
                        sb += w[j][1];
                        sc += w[j][2];
                        count ++;
                    }
                }
                if(sa <= a && sb <= b && sc <= c){
                    res = Math.max(res,count);
                }
            }
            System.out.println(res);
        }
    }
}
