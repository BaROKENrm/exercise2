package day152;

import java.util.Scanner;

public class day152exercise_3 {
    static int N = 100010;
    static int[] w = new int[N], q = new int[N];
    static int n;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for(int i = 1; i <= n; i ++){
            w[i] = scan.nextInt();
        }
        q[0] = Integer.MIN_VALUE;
        int len = 0;
        for(int i = 1; i <=n ; i ++){
            int l = 0;
            int r = len;
            while(l < r){
                int mid = l + r + 1>> 1;
                if(q[mid] < w[i]){
                    l = mid;
                }
                else{
                    r = mid - 1;
                }
            }
            len = Math.max(len,r + 1);
            q[r + 1] = w[i];
        }
        System.out.println(len);
    }
}

