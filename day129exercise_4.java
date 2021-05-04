package day129;

import java.util.Scanner;
/*
翰翰和达达饲养了 N 只小猫，这天，小猫们要去爬山。

经历了千辛万苦，小猫们终于爬上了山顶，但是疲倦的它们再也不想徒步走下山了（呜咕>_<）。

翰翰和达达只好花钱让它们坐索道下山。

索道上的缆车最大承重量为 W，而 N 只小猫的重量分别是 C1、C2……CN。

当然，每辆缆车上的小猫的重量之和不能超过 W。

每租用一辆缆车，翰翰和达达就要付 1 美元，所以他们想知道，最少需要付多少美元才能把这 N 只小猫都运送下山？

输入格式
第 1 行：包含两个用空格隔开的整数，N 和 W。

第 2..N+1 行：每行一个整数，其中第 i+1 行的整数表示第 i 只小猫的重量 Ci。

输出格式
输出一个整数，表示最少需要多少美元，也就是最少需要多少辆缆车。
 */
public class day129exercise_4 {
    static int N = 20;
    static int[] sum = new int[N];
    static int[] w = new int[N];
    static int n, m;
    static int ans = N;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for(int i = 0; i < n; i ++){
            w[i] = scan.nextInt();
        }
        sort(0,N - 1);
        dfs(0,0);
        System.out.println(ans);
    }

    public static void dfs(int u, int k){
        if(k >= ans) return;
        if(u == n){
            ans = k;
            return;
        }

        for(int i = 0; i < k; i ++){
            if(sum[i] + w[u] <= m){
                sum[i] += w[u];
                dfs(u + 1, k);
                sum[i] -= w[u];
            }
        }
        sum[k] = w[u];
        dfs(u + 1, k + 1);
        sum[k] = 0;

    }

    public static void sort(int l, int r){
        if(l >= r){
            return;
        }
        int i = l - 1;
        int j = r + 1;
        int x = w[l];
        while(i < j){
            do{
                i ++;
            }while(x < w[i]);

            do{
                j --;
            }while(x > w[j]);

            if(i < j){
                int temp = w[i];
                w[i] = w[j];
                w[j] = temp;
            }
        }
        sort(l,j);
        sort(j + 1, r);
    }
}
