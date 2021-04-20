package day119;

import java.util.Scanner;

/*
有一个箱子容量为 V，同时有 n 个物品，每个物品有一个体积（正整数）。

要求 n 个物品中，任取若干个装入箱内，使箱子的剩余空间为最小。

输入格式
第一行是一个整数 V，表示箱子容量。

第二行是一个整数 n，表示物品数。

接下来 n 行，每行一个正整数（不超过10000），分别表示这 n 个物品的各自体积。

输出格式
一个整数，表示箱子剩余空间。

数据范围
0<V≤20000,
0<n≤30
 */
public class day119exercise_3 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(T -- > 0){
            int r = scan.nextInt();
            int c = scan.nextInt();
            int[][] arr = new int[r][c];
            int[][] f = new int[r][c];
            for(int i = 0; i < r; i ++){
                for(int j = 0; j < c; j ++){
                    arr[i][j] = scan.nextInt();
                }
            }
            f[0][0] = arr[0][0];
            for(int i = 1; i < r; i ++){
                f[i][0] = f[i - 1][0] + arr[i][0];
            }
            for(int i = 1; i < c; i ++){
                f[0][i] = f[0][i - 1] + arr[0][i];
            }

            for(int i = 1; i < r; i ++){
                for(int j = 1; j < c; j ++){
                    f[i][j] = Math.max(f[i - 1][j],f[i][j - 1]) + arr[i][j];
                }
            }
            System.out.println(f[r - 1][c - 1]);
        }
    }
}
