package day140;

import java.util.Arrays;
import java.util.Scanner;

public class day140exercise_3 {
    static int N = 6010;
    static int[] e = new int[N], ne = new int[N], h = new int[N],happy = new int[N];
    static boolean[] hasF = new boolean[N];
    static int n, index;
    static int[][] f = new int[N][2];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for(int i = 1; i <= n; i ++){
            happy[i] = scan.nextInt();
        }
        Arrays.fill(h,-1);
        for(int i = 1; i < n; i ++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            add(b,a);
            hasF[a] = true;
        }

        int root = 1;
        while(hasF[root]) root ++;

        dfs(root);
        System.out.println(Math.max(f[root][0],f[root][1]));
    }

    public static void dfs(int u){
        f[u][1] = happy[u];
        for(int i = h[u]; i != -1; i = ne[i]){
            int j = e[i];
            dfs(j);
            f[u][0] += Math.max(f[j][1],f[j][0]);
            f[u][1] += f[j][0];
        }
    }

    public static void add(int a, int b){
        e[index] = b;
        ne[index] = h[a];
        h[a] = index++;
    }

}
