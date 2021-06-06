package day162;

import java.util.PriorityQueue;
import java.util.Scanner;
/*
给定一个长度为 n 的非负整数序列 a1,a2,…,an。

你可以对该序列进行最多 k 次操作。

每次操作选择两个非 0 的元素 ai 和 aj，然后选择一个整数 c（0≤c≤ai），使得 ai 减少 c，aj 增加 c。

请问，在操作全部完成后，序列中的最大值和最小值之差是多少。

例如，如果初始序列为 [5,5,5,5] 而 k=1，则一种最优方案是将 a2 减少 5，将 a4 增加 5，得到序列 [5,0,5,10]，这样最大值和最小值之差为 10。

再例如，如果序列中的所有元素都为 0，则无法进行任何操作，所以最大值和最小值之差也为 0。

输入格式
第一行包含整数 T，表示共有 T 组测试数据。

每组数据第一行包含整数 n 和 k。

第二行包含 n 个整数 a1,a2,…,an。

输出格式
每组数据输出一行，一个整数，表示可以得到的最大差值。
 */
public class day162exercise_3 {
    static int N = 100005 * 2;
    static int[] w = new int[N];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(T-- > 0){
            long res = 0;
            PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> {return o2 - o1;});
            int n = scan.nextInt();
            int k = scan.nextInt();
            for(int i = 0; i < n; i ++){
                w[i] = scan.nextInt();
                heap.offer(w[i]);
            }
            res = heap.poll();
            while(k -- > 0){
                res += heap.poll();
            }
            System.out.println(res);
        }
    }
}
