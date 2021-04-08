package day107;

import java.util.Arrays;
import java.util.Scanner;

public class day107exercise_1 {
    static int N = 6010;
    static int[] happy = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] h = new int[N];
    static int[][] f = new int[N][2];
    //f[u][1] 表示选择这个点 f[u][0]表示不选择这个点
    //f[u][1] =  选这个点并且不选择儿子的最大值
    //f[u][0] = 不选择这个点并且选择儿子的最大值
    //f[u][0] = max  f[s][1]  f[s][0];
    //f[u][1] =   f[s][0];
    //s表示u的每个儿子
    static boolean[] hasFather = new boolean[N];
    static int index;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 1; i <= n; i ++){
            happy[i] = scan.nextInt();
        }
        Arrays.fill(h,-1);
        for(int i = 0; i < n - 1; i ++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            add(b,a);
            hasFather[a] = true;
        }
        //寻找根
        int root = 1;
        while(hasFather[root]){
            root ++;
        }
        dfs(root);
        System.out.println(Math.max(f[root][0],f[root][1]));
    }

    public static void dfs(int u){
        f[u][1] = happy[u];
        for(int i = h[u]; i != -1; i = ne[i]){
            int j = e[i];
            dfs(j);
            f[u][0] += Math.max(f[j][0],f[j][1]);
            f[u][1] += f[j][0];

        }
    }

    public static void add(int a,int b){
        e[index] = b;
        ne[index] = h[a];
        h[a] = index ++;
    }
}
