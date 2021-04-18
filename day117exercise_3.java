package day117;
import java.util.*;
public class day117exercise_3 {
        static int N = 1010;
        static int n;
        static int[] arr = new int[N];
        static int[] f = new int[N];
        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            n = scan.nextInt();
            for(int i = 1; i <= n; i ++){
                arr[i] = scan.nextInt();
            }

            for(int i = 1; i <= n; i ++){
                f[i] = arr[i];
                for(int j = 1; j < i; j ++){
                    if(arr[j] < arr[i]){
                        f[i] = Math.max(f[j] + arr[i],f[i]);
                    }
                }
            }
            int res = 0;
            for(int i = 1; i <= n; i ++){
                res = Math.max(f[i],res);
            }
            System.out.println(res);
        }
    }
