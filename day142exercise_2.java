package day142;

import java.util.Scanner;
import java.util.Stack;

public class day142exercise_2 {
    static int N = 100010;
    static int n;
    static int[] q = new int[N], l = new int[N], r = new int[N], h = new int[N];
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(true){
            n = scan.nextInt();
            if(n == 0){
                break;
            }
            for(int i = 1; i <= n; i ++){
                h[i] = scan.nextInt();
            }

            h[0] = h[n + 1] = -1;
            //  q[0] = 0;
            stack.push(0);
            // int tt = 0;
            for(int i = 1; i <= n; i ++){
                while(h[i] <= h[stack.peek()]){
                    // tt --;
                    stack.pop();
                }

                l[i] = stack.peek();
                //   System.out.printf("%d ",l[i]);
                stack.push(i);
            }
            stack.clear();
            //  stack.push(n + 1);
            // q[0] = n + 1;
            stack.push(n + 1);
            //  tt = 0;
            for(int i = n; i > 0; i --){
                while(h[i] <= h[stack.peek()]){
                    stack.pop();
                }
                r[i] = stack.peek();
                stack.push(i);
                // System.out.printf("%d ",r[i]);

            }
            long max = 0;
            for(int i = 1; i <= n; i ++){
                max = Math.max(max, (long)(r[i] - l[i] - 1) * h[i]);
            }
            System.out.println(max);
        }
    }

}
