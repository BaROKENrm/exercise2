package day120;
/*
阿福是一名经验丰富的大盗。趁着月黑风高，阿福打算今晚洗劫一条街上的店铺。

这条街上一共有 N 家店铺，每家店中都有一些现金。

阿福事先调查得知，只有当他同时洗劫了两家相邻的店铺时，街上的报警系统才会启动，然后警察就会蜂拥而至。

作为一向谨慎作案的大盗，阿福不愿意冒着被警察追捕的风险行窃。

他想知道，在不惊动警察的情况下，他今晚最多可以得到多少现金？

 */
import java.util.*;
public class day120exercise_3 {


        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            int T = scan.nextInt();
            while(T -- > 0){
                int n = scan.nextInt();
                int[] arr = new int[n];
                int[] f = new int[n];
                for(int i = 0; i < n; i ++){
                    arr[i] = scan.nextInt();
                }
                f[0] = arr[0];
                f[1] = Math.max(arr[0],arr[1]);
                for(int i = 2; i < n; i ++){
                    f[i] = Math.max(f[i - 2] + arr[i],f[i - 1]);
                }
                System.out.println(f[n - 1]);
            }
        }
        /*


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(T -- > 0){
            int n = scan.nextInt();
            int[] arr = new int[n + 1];
            int[][] f = new int[n + 1][2];
            for(int i = 1; i <= n; i ++){
                arr[i] = scan.nextInt();
            }
            f[0][0] = arr[0];
            f[0][1] = Integer.MIN_VALUE;
            for(int i = 1; i <= n; i ++){
                f[i][0] = Math.max(f[i - 1][0],f[i - 1][1]);
                f[i][1] = f[i - 1][0] + arr[i];
            }
            System.out.println(Math.max(f[n][0],f[n][1]));
}
}
         */
}
