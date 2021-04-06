package day105;

import java.util.Arrays;
import java.util.Scanner;

/*
给定一个长度为 n 的数组 a，请你编写一个函数：

int get_unique_count(int a[], int n);  // 返回数组前n个数中的不同数的个数
输入格式
第一行包含一个整数 n。

第二行包含 n 个整数，表示数组 a。

输出格式
共一行，包含一个整数表示数组中不同数的个数。

数据范围
1≤n≤1000
 */
public class day105exercise_1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        int i = 1;
        int j = 1;
        while(j < n){
            if(arr[i - 1] != arr[j]){
                arr[i] = arr[j];
                i ++;
            }
            j ++;
        }
        System.out.println(i);
    }
}
