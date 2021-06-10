package day166;

import java.util.Arrays;

public class day166exercise_2 {
    public static void main(String[] args) {
        day166exercise_2 d = new day166exercise_2();
        int[] w = {2,3,8,3,2,5};
        int[] res = d.findBuilding(w);
        System.out.println(Arrays.toString(res));
    }
    public int[] findBuilding (int[] heights) {
        int n = heights.length;
        int[] l = new int[n + 1];
        int[] r = new int[n + 1];
        int[] h = new int[n + 1];
        for(int i = 1; i <= n; i ++){
            h[i] = heights[i - 1];
        }

        for(int i = 1; i <= n; i ++){
            l[i] = 1;
            for(int j = 1; j < i; j ++){
                if(h[i] > h[j]){
                    l[i] = Math.max(l[i],l[j] + 1);
                }
            }
        }

        for(int i = n; i >= 1; i --){
            r[i] = 1;
            for(int j = n; j > i; j --){
                if(h[i] > h[j]){
                    r[i] = Math.max(r[i], r[j] + 1);
                }
            }
        }
        int[] res = new int[n];
        for(int i = 0; i < n; i ++){
            res[i] = l[i + 1] + r[i + 1] + 1;
        }
        return res;
    }
}
