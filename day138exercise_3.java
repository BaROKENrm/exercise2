package day138;

import java.util.*;

public class day138exercise_3 {
    static int N = 15;
    static int[] start = new int[N], end = new int[N], w = new int[N];
    static int n;
    static Map<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        n = scan.nextInt();
        for(int i = 1; i <= n; i ++){
            start[i] = scan.nextInt();
        }

        for(int i = 1; i <= n; i ++){
            end[i] = scan.nextInt();
        }

        for(int i = 1; i <= n; i ++){
            w[i] = scan.nextInt();
            map.put(w[i],i);
            queue.offer(w[i]);
        }
        int res = queue.poll();
        int index = map.get(res);
        int l = start[index];
        int r = end[index];
        while(!queue.isEmpty()){
            int num = queue.poll();
            index = map.get(num);
            if(end[index] <= l || start[index] >= r){
                res += num;
                l = Math.min(l,start[index]);
                r = Math.max(r,end[index]);
            }
        }
        System.out.println(res);
    }
}
