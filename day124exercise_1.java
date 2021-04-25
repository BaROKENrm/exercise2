package day124;

import java.util.Scanner;

public class day124exercise_1 {
    static int N = 100010;
    static int[] arr = new int[N];
    static int MOD = 100000;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int c = scan.nextInt();
        n = n % MOD;
        c = c % MOD;
        String map = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i < n; i ++){
            arr[i] = scan.nextInt();
        }
        for(int i = 0; i < n; i ++){
            int index = arr[i] / c;
            int num = arr[i] % c;
            if(arr[i] % c == 0){
                index = index - 1;
                num = 5;
            }
            System.out.println(map.charAt(index) + "" + num);

        }
    }
}
