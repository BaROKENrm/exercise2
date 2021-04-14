package day113;

import java.util.Scanner;

public class day113exercise_1 {
    static int N = 100010;
    static int[][] arr = new int[N][26];
    static int[] count = new int[N];
    static int index;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while(n -- > 0){
            String a = scan.next();
            String b = scan.next();
            if(a.equals("I")){
                insert(b);
            }
            else{
                System.out.println(search(b));
            }
        }
    }
    public static void insert(String s){
        char[] ch = s.toCharArray();
        int p = 0;
        int len = s.length();
        for(int i = 0; i < len; i ++){
            int u = ch[i] - 'a';
            if(arr[p][u] == 0){
                arr[p][u] = ++ index;
            }
            p = arr[p][u];
        }
        count[p] ++;
    }

    public static int search(String s){
        int len = s.length();
        char[] ch = s.toCharArray();
        int p = 0;
        for(int i = 0; i < len; i ++){
            int u = ch[i] - 'a';
            if(arr[p][u] == 0){
                return 0;
            }
            p = arr[p][u];
        }
        return count[p];
    }
}
