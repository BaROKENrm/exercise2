package day162;

import java.util.Scanner;

public class day162exercise_2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(T -- > 0){
            int n = scan.nextInt();
            for(int i = 0; i < n / 3; i ++){
                for(int j = 0; j < n / 5; j ++){
                    int num = (n - (3 * i) - (5 * j));
                    if(n % 7 == 0){
                        System.out.printf("%d %d %d", i, j, n / 7);
                        break;
                    }
                }
            }
            System.out.println("-1");
        }
    }
}
