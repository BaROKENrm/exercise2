package day138;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day138exercise_2 {
    static int N = 110;
    static int n, m;
    static int[][] f = new int[N][N];
    static int[] w = new int[N], v = new int[N];
    static boolean[] st = new boolean[N];
    static List<List<Integer>> ret = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        for(int i = 1;i <= n; i ++){
            w[i] = scan.nextInt();
        }
        m = scan.nextInt();
        for(int i = 1; i <= m; i ++){
            v[i] = scan.nextInt();
        }
        dfs();
        int max = 0;
        int res = 0;
        for(int i = 0; i < ret.size(); i ++){
            max = w[1];
            List<Integer> temp = ret.get(i);
            int index = 1;
            for(int j = 0; j < m; j ++){
                if(index + temp.get(j) <= n){
                    index += temp.get(j);
                    max += w[index];
                }
            }
            res = Math.max(res,max);
        }
        System.out.println(res);
    }


    public static void dfs(){
        if(list.size() == m){
            ret.add(new ArrayList<>(list));
            return;
        }
        for(int i = 1; i <= m; i ++){
            if(!st[i]){
                list.add(v[i]);
                st[i] = true;
                dfs();
                st[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
