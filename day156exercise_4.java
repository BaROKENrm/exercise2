package day156;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class day156exercise_4 {
    static int N = 1000005;
    static int[] dist = new int[N];
    static int[] e = new int[N], ne = new int[N], h = new int[N] ,w = new int[N];
    static int n, m, index;
    static boolean[] st = new boolean[N];
    static PriorityQueue<int[]> heap = new PriorityQueue<>((o1,o2) -> {return o1[1] - o2[1];});
    static int MAX = 0x3f3f3f3f;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        Arrays.fill(h, -1);
        for(int i = 0; i < m; i ++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            add(a, b, c);
        }

        System.out.println(dijkstra());
    }

    public static int dijkstra(){
        Arrays.fill(dist,MAX);
        dist[1] = 0;
        //1表示点 0表示距离
        heap.offer(new int[]{1,0});
        while(!heap.isEmpty()){
            int[] t = heap.poll();
            int point = t[0];
            int distance = t[1];
            if(st[point]){
                continue;
            }
            st[point] = true;
            for(int i = h[point]; i != -1; i = ne[i]){
                int j = e[i];
                if(dist[j] > distance + w[i]){
                    dist[j] = distance + w[i];
                    heap.offer(new int[]{j,dist[j]});
                }
            }
        }
        if(dist[n] == MAX){
            return -1;
        }
        return dist[n];
    }

    public static void add(int a, int b, int c){
        e[index] = b;
        w[index] = c;
        ne[index] = h[a];
        h[a] = index ++;
    }
}
