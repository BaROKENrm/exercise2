package day116;

import java.util.Scanner;
//给定的 N 个整数 A1，A2……AN 中选出两个进行 xor（异或）运算，得到的结果最大是多少？
public class day116exercise_1 {
    static int N = 100005;
    static int n;
    static int index;
    static int M = 3000005;
    static int[][] son = new int[M][2];
    static int[] arr = new int[N];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for(int i = 0; i < n; i ++){
            arr[i] = scan.nextInt();
            insert(arr[i]);
        }

        int res = 0;
        for(int i = 0; i < n; i ++){
            res = Math.max(res,query(arr[i]));
        }
        System.out.println(res);
    }

    public static void insert(int x){
        int p = 0;
        for(int i = 30; i >= 0; i --){
            int s = (x >> i) & 1;
            if(son[p][s] == 0){
                son[p][s] = ++index;
            }
            p = son[p][s];
        }
    }

    public static int query(int x){
        int p = 0;
        int res = 0;
        for(int i = 30; i >= 0; i --){
            int s = (x >> i) & 1;
            if(son[p][1 - s] != 0){
                res += (1 << i);
                p = son[p][1 - s];
            }
            else{
                p = son[p][s];
            }
        }
        return res;
    }
}
