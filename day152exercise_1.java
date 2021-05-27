package day152;

import java.util.Arrays;
import java.util.Scanner;

/*
给定 n 个整数 a1,a2,…,an，n 为偶数。

现在要将它们两两配对，组成 n2 个数对。

ai 和 aj 能够配对，当且仅当 ai=aj。

每次增加操作可以使其中的任意一个数 ai 加一。

请问，要使得 n 个整数能够成功组成 n2 个数对，至少要进行多少次增加操作。

输入格式
第一行包含整数 n。

第二行包含 n 个整数 a1,a2,…,an。

输出格式
一个整数，表示所需最少操作次数。

数据范围
1≤n≤105,
1≤ai≤104
 */
public class day152exercise_1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        int res = 0;
        for(int i = 1; i < n; i += 2){
            res += arr[i] - arr[i - 1];
        }
        System.out.println(res);
    }
}
