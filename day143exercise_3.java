package day143;


import java.util.Arrays;
import java.util.Scanner;

class Node{
    int a;
    int b;
    int c;
    public Node(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

public class day143exercise_3 {
    static int N = 100010, M = 100010 * 2;
    static int n ,m;
    static int[] p = new int[N];


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        Node[] node = new Node[m];
        for(int i = 0; i < m; i ++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            node[i] = new Node(a,b,c);
        }
        Arrays.sort(node, (Node o1,Node o2) -> {
            return o1.c - o2.c;
        });
        for(int i = 0; i < n; i ++){
            p[i] = i;
        }
        int res = 0;
        int count = 0;

        for(int i = 0; i < m; i ++){
            Node t = node[i];
            int a = t.a;
            int b = t.b;
            int c = t.c;
            a = find(a);
            b = find(b);
            if(a != b){
                res += c;
                count ++;
                p[a]= b;
            }
        }

        if(count == n - 1){
            System.out.println(res);
        }
        else{
            System.out.println("impossible");
        }
    }

    public static int find(int x){
        if(p[x] != x){
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
