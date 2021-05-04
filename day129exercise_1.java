package day129;

import java.util.Scanner;

/*
上体育课的时候，小蛮的老师经常带着同学们一起做游戏。

这次，老师带着同学们一起做传球游戏。

游戏规则是这样的：

n 个同学站成一个圆圈，其中的一个同学手里拿着一个球，当老师吹哨子时开始传球，每个同学可以把球传给自己左右的两个同学中的一个（左右任意），当老师再次吹哨子时，传球停止，此时，拿着球没传出去的那个同学就是败者，要给大家表演一个节目。

聪明的小蛮提出一个有趣的问题：有多少种不同的传球方法可以使得从小蛮手里开始传的球，传了 m 次以后，又回到小蛮手里。

两种传球的方法被视作不同的方法，当且仅当这两种方法中，接到球的同学按接球顺序组成的序列是不同的。

比如有 3 个同学 1 号、2 号、3 号，并假设小蛮为 1 号，球传了 3 次回到小蛮手里的方式有 1→2→3→1 和 1→3→2→1，共 2 种。

输入格式
输入文件共一行，有两个用空格隔开的整数 n，m。

输出格式
输出文件共一行，有一个整数，表示符合题意的方法数。

数据范围
3≤n≤30,
1≤m≤30
 */
public class day129exercise_1 {
    static int N = 35;
    static int[][] f = new int[N][N];
    static int n , m;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        f[0][0] = 1;
        for(int i = 1; i <= m; i ++){
            for(int j = 0; j < n; j ++){
                f[i][j] = f[i - 1][(j + 1) % n] + f[i - 1][(j - 1 + n) % n];
            }
        }
        System.out.println(f[m][0]);
    }
}
