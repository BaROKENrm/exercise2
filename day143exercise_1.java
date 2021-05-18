package day143;

import java.util.Scanner;

public class day143exercise_1 {
    static int N = 210;
    static int n,m;
    static int[] map = new int[N],arr = new int[N];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for(int i = 1; i <= n; i ++){
            arr[i] = scan.nextInt();
            map[arr[i]] ++;
        }

        for(int i = 1; i <= n; i ++){
            if(map[arr[i]] != 1){
                System.out.println(map[arr[i]] - 1);
            }
            else{
                System.out.println("BeiJu");
            }
        }
    }
}
