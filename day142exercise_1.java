package day142;

import java.util.Scanner;
/*
为了庆贺班级在校运动会上取得全校第一名成绩，班主任决定开一场庆功会，为此拨款购买奖品犒劳运动员。

期望拨款金额能购买最大价值的奖品，可以补充他们的精力和体力。

输入格式
第一行二个数n，m，其中n代表希望购买的奖品的种数，m表示拨款金额。

接下来n行，每行3个数，v、w、s，分别表示第I种奖品的价格、价值（价格与价值是不同的概念）和能购买的最大数量（买0件到s件均可）。

输出格式
一行：一个数，表示此次购买能获得的最大的价值（注意！不是价格）。
 */
public class day142exercise_1 {
    static int N = 6010;
    static int n,m;
    static int[] f = new int[N];
    static int[] v = new int[N], w = new int[N], s = new int[N];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for(int i = 1; i <= n; i ++){
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
            s[i] = scan.nextInt();
        }
        for(int i = 1; i <= n; i ++){
            for(int j = m; j >= 0; j --){
                for(int k = 0; k <= s[i] && k * v[i] <= j; k ++){
                    f[j] = Math.max(f[j],f[j - k * v[i]] + k * w[i]);
                }
            }
        }
        System.out.println(f[m]);
    }
}
