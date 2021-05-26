package day151;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class day151exercise_3 {
    static int N = 100010;
    static int n;
    static int m;
    static int idx;
    static int e[] = new int[N*2];
    static int ne[] = new int[N * 2];
    static int h[] = new int [N];
    static int dist[]  = new int[N];
    static int w[] = new int[N];
    static boolean st[] = new boolean[N];

    static void add(int x ,int y ,int z){
        e[idx] = y;
        w[idx] = z;
        ne[idx] = h[x];
        h[x] = idx++;
    }
    static int spfa(){
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(dist,0x3f3f3f3f);
        dist[1] = 0;
        st[1] = true;
        q.offer(1);
        while(!q.isEmpty()){
            int temp  = q.poll();
            st[temp] = false;
            for(int i = h[temp]; i != -1 ;i = ne[i]){
                int j = e[i];
                if(dist[j]>dist[temp]+w[i]){
                    dist[j] = dist[temp]+w[i];
                    if(!st[j]){
                        q.offer(j);
                        st[j] = true;
                    }
                }
            }
        }
        return dist[n];
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m  =in.nextInt();
        Arrays.fill(h,-1);
        while(m -- >0){
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            add(x,y,z);
        }
        int t =spfa();
        if(t == 0x3f3f3f3f) System.out.println("impossible");
        else  System.out.println(t);
    }

}
