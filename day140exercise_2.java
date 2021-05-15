package day140;

import java.util.Scanner;

public class day140exercise_2 {
    static int N = 1000010;
    static int n;
    static int[] a = new int[N], q = new int[N];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for(int i = 0; i < n; i ++){
            a[i] = scan.nextInt();
        }

        q[0] = Integer.MIN_VALUE;
        int len = 0;
        for(int i = 0; i < n ; i ++){
            int l = 0;
            int r = len;
            while(l < r) {
                int mid = l + r + 1 >> 1;
                if (q[mid] < a[i]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            len = Math.max(l + 1,len);
            q[l + 1] = a[i];

        }
        System.out.println(len);
    }
}
