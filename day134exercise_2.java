package day134;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
//格子游戏
public class day134exercise_2 {
    static int N = 40010;
    static int n, m, res;
    static int[] p = new int[N];
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        int res = 0;

        for(int i = 0; i < n * n; i ++){
            p[i] = i;
        }

        for(int i = 1; i <= m; i ++){
            String[] s2 = scan.nextLine().split(" ");
            int x = Integer.valueOf(s2[0]);
            int y = Integer.valueOf(s2[1]);
            String ch = s2[2];
            int a = get(x,y);
            int b = 0;
            if(ch.equals("D")){
                b = get(x + 1,y);
            }
            else{
                b = get(x, y + 1);
            }

            int fa = find(a);
            int fb = find(b);
            if(fa == fb){
                res = i;
                break;
            }
            p[fa] = fb;
        }

        if(res == 0){
            System.out.println("draw");
        }
        else{
            System.out.println(res);
        }
    }


    public static int get(int x, int y){
        return x * n + y;
    }

    public static int find(int x){
        if(p[x] != x){
            find(p[x]);
        }
        return p[x];
    }
}
