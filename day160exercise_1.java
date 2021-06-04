package day160;

import java.util.Arrays;
import java.util.Scanner;

/*
有 n 个人排队到 1 个水龙头处打水，第 i 个人装满水桶所需的时间是 ti，请问如何安排他们的打水顺序才能使所有人的等待时间之和最小？

输入格式
第一行包含整数 n。

第二行包含 n 个整数，其中第 i 个整数表示第 i 个人装满水桶所花费的时间 ti。

输出格式
输出一个整数，表示最小的等待时间之和。
 */
public class day160exercise_1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] w = new int[n];
        for(int i = 0; i < n; i ++){
            w[i] = scan.nextInt();
        }
        Arrays.sort(w);
        long wait = 0;
        for(int i = 0; i < n; i ++){
            wait += (w[i] * (n - i - 1));
        }
        System.out.println(wait);
    }
}
