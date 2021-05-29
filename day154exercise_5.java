package day154;

import java.util.Scanner;
/*
将 1∼n 按顺序排成一排，构成一个数列。

数字 i 刚好位于位置 i。

再给定一个长度为 n 的位置序列 p1,p2,…,pn，它是 1∼n 的一种排列。

接下来，我们会重复不断地对数列进行如下操作：

重新排列数列中每个数的位置，将位于位置 i 的数移动至位置 pi。（如果 i=pi 则该数仍移动至位置 i）。
每次操作开始时，所有数的移动同时进行，操作结束后，数列将变为一个新的 1∼n 的排列。
例如，当 n=6 并且 p=[4,6,1,3,5,2] 时，第一次操作后，数字 1 将移动至位置 4，数字 2 将移动至位置 6，以此类推；第二次操作后，数字 1 将移动至位置 3，数字 2 将移动至位置 2，以此类推。

你的任务是确定从 1 到 n 的每个数字 i，经过多少次操作后，第一次重新回到位置 i。

例如，考虑 p=[5,1,2,4,3]，数字 1 的移动轨迹如下：

第一次操作后，到达位置 5。
第二次操作后，到达位置 3。
第三次操作后，到达位置 2。
第四次操作后，回到位置 1。
所以，经过四次操作后，数字 1 第一次回到位置 1。

值得一提的是，数字 4 经过一次操作后就回到了位置 4.

输入格式
第一行包含整数 T，表示共有 T 组测试数据。

每组数据第一行包含整数 n。

第二行包含 n 个整数 p1,…,pn。

输出格式
每组数据输出一行结果，包含 n 个整数，其中第 i 个整数表示数字 i 第一次回到位置 i 所经过的操作次数。

整数之间用单个空格隔开。
 */
public class day154exercise_5 {
    static int N = 200010;
    static int T,n;
    static int[] p = new int[N], s = new int[N], q = new int[N];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        T = scan.nextInt();
        while(T -- > 0){
            n = scan.nextInt();
            for(int i = 1; i <= n; i ++){
                p[i] = i;
                s[i] = 1;
            }

            for(int i = 1; i <= n; i++){
                int j = scan.nextInt();
                int pi = find(i);
                int pj = find(j);
                if(pi != pj){
                    s[pj] += s[pi];
                    p[pi] = pj;
                }
            }


            for(int i = 1; i <= n; i ++){
                System.out.printf("%d ",s[find(i)]);
            }
            System.out.println(" ");
        }
    }

    public static int find(int x){
        if(p[x] != x){
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
