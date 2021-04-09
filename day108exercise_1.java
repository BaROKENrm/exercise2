package day108;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// n 皇后
public class day108exercise_1 {
    static List<List<String>> ret = new ArrayList<>();
    static int n;
    static char[][] gruid;
    static boolean[] col;
    static boolean[] dg;
    static boolean[] udg;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        gruid = new char[n][n];
        col = new boolean[n];
        dg = new boolean[n + n];
        udg = new boolean[n + n];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                gruid[i][j] = '.';
            }
        }
        dfs(0);
        System.out.println(ret);
    }
    public static void dfs(int u){
        if(u == n){
            List<String> list = new ArrayList<>();
            for(int i = 0; i < n;i ++){
                System.out.println(gruid[i]);
                list.add(new String(gruid[i]));
            }
            ret.add(list);
            System.out.println();
        }
        for(int i = 0; i < n; i ++){
            if(!col[i] && !dg[u + i] && !udg[n + i - u]){
                gruid[i][u] = 'Q';
                col[i] =  dg[u + i] = udg[n + i - u] = true;
                dfs(u + 1);
                gruid[i][u] = '.';
                col[i] = dg[u + i] = udg[n + i - u] = false;
            }
        }
    }
}
