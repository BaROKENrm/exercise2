package day145;

import java.util.Scanner;

public class day145exercise_3 {
    static int N = 100010;
    static int n;
    static int[] q = new int[N], t = new int[N];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for(int i = 0 ; i < n; i ++){
            q[i] = scan.nextInt();
        }
        long res = sort(0,n - 1);
        System.out.println(res);
    }

    public static long sort(int l, int r){
        if(l >= r){
            return 0;
        }
        int mid = l + r >> 1;
        long res = sort(l, mid) + sort(mid + 1,r);
        int i = l;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= r){
            if(q[i] <= q[j]) t[k ++] = q[i ++];
            else{
                t[k ++] = q[j ++];
                res += mid - i + 1;
            }
        }
        while(i <= mid){
            t[k ++] = q[i ++];
        }
        while(j <= r){
            t[k ++] = q[j ++];
        }

        for(i = l, j = 0; i <= r; i ++, j ++){
            q[i] = t[j];
        }
        return res;
    }
}
