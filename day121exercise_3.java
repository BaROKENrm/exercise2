package day121;

import java.util.Scanner;
/*
输入一个 n 行 m 列的整数矩阵，再输入 q 个询问，每个询问包含四个整数 x1,y1,x2,y2，表示一个子矩阵的左上角坐标和右下角坐标。

对于每个询问输出子矩阵中所有数的和。

输入格式
第一行包含三个整数 n，m，q。

接下来 n 行，每行包含 m 个整数，表示整数矩阵。

接下来 q 行，每行包含四个整数 x1,y1,x2,y2，表示一组询问。

输出格式
共 q 行，每行输出一个询问的结果。
 */
public class day121exercise_3 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt(), q = scan.nextInt();
        int[][] arr = new int[n + 1][m + 1];
        int[][] f = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= m; j ++){
                arr[i][j] = scan.nextInt();
            }
        }


        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= m; j ++){
                f[i][j] =  f[i - 1][j] + f[i][j - 1] - f[i - 1][j - 1] + arr[i][j];
            }
        }

        for(int i = 0; i < q; i ++){
            int x1 = scan.nextInt(), y1 = scan.nextInt(), x2 = scan.nextInt(), y2 = scan.nextInt();
            int res = f[x2][y2] - f[x1 - 1][y2] - f[x2][y1 - 1] + f[x1 - 1][y1 - 1];
            System.out.println(res);
        }

    }
}
