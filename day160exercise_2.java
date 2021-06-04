package day160;

import java.util.Arrays;
import java.util.Scanner;

/*
在一条数轴上有 N 家商店，它们的坐标分别为 A1∼AN。

现在需要在数轴上建立一家货仓，每天清晨，从货仓到每家商店都要运送一车商品。

为了提高效率，求把货仓建在何处，可以使得货仓到每家商店的距离之和最小。

输入格式
第一行输入整数 N。

第二行 N 个整数 A1∼AN。

输出格式
输出一个整数，表示距离之和的最小值。
 */
public class day160exercise_2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] w = new int[n];
        for(int i = 0; i < n; i ++){
            w[i] = scan.nextInt();
        }
        Arrays.sort(w);
        int res = 0;
        for(int i = 0; i < n; i ++){
            res += Math.abs(w[i] - w[n / 2]);
        }
        System.out.println(res);
    }
}
