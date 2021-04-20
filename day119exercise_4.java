package day119;

import java.util.Scanner;
/*
Hello Kitty想摘点花生送给她喜欢的米老鼠。

她来到一片有网格状道路的矩形花生地(如下图)，从西北角进去，东南角出来。

地里每个道路的交叉点上都有种着一株花生苗，上面有若干颗花生，经过一株花生苗就能摘走该它上面所有的花生。

Hello Kitty只能向东或向南走，不能向西或向北走。

问Hello Kitty最多能够摘到多少颗花生。

 */
public class day119exercise_4 {
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
