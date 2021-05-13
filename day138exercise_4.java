package day138;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*
给定一个 n×m 的二维矩阵，其中的每个元素都是一个 [1,9] 之间的正整数。

从矩阵中的任意位置出发，每次可以沿上下左右四个方向前进一步，走过的位置可以重复走。

走了 k 次后，经过的元素会构成一个 (k+1) 位数。

请求出一共可以走出多少个不同的 (k+1) 位数。

输入格式
第一行包含三个整数 n,m,k。

接下来 n 行，每行包含 m 个空格隔开的整数，表示给定矩阵。

输出格式
输出一个整数，表示可以走出的不同 (k+1) 位数的个数。

数据范围
对于 30% 的数据, 1≤n,m≤2,0≤k≤2
对于 100% 的数据，1≤n,m≤5,0≤k≤5,m×n>1
 */
public class day138exercise_4 {
    static int N = 10;
    static int n, m, k;
    static int[][] w = new int[N][N];
    static Set<Integer> set = new HashSet<>();
    static int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        k = scan.nextInt();
        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= m; j ++){
                w[i][j] = scan.nextInt();
            }
        }
        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= m; j ++){
                dfs(i,j,0,0);
            }
        }
        System.out.println(set.size());
    }

    public static void dfs(int x, int y,int num, int count){
        if(count == k + 1){
            set.add(num);
            return;
        }
        num = num * 10 + w[x][y];
        for(int i = 0; i < 4; i ++){
            int a = x + dx[i];
            int b = y + dy[i];
            if(a < 1 || a > n || b < 1 || b > m){
                continue;
            }
            dfs(a,b,num,count + 1);
        }
    }
}
