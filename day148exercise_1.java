package day148;

import java.util.Arrays;
import java.util.Comparator;
//1707. 与数组中元素的最大异或值
public class day148exercise_1 {
    int N = 100000 * 31;
    int[][] son = new int[N][2];
    int index = 0;
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        Arrays.sort(queries, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int len = queries.length;
        int[] ret = new int[len];
        int idx = 0;
        for(int i = 0; i < nums.length; i ++){
            int a = queries[i][0];
            int b = queries[i][1];
            while(idx < nums.length && nums[idx] <= b){
                insert(nums[idx]);
                idx ++;
            }
            ret[i] = query(a);
        }
        return ret;
    }

    public void insert(int x){
        int p = 0;
        for(int i = 31; i >= 0; i --){
            int s = (x >> i) & 1;
            if(son[p][s] == 0){
                son[p][s] = ++ index;
            }
            p = son[p][s];
        }
    }

    public int query(int x){
        int p = 0;
        int res = 0;
        for(int i = 30; i >= 0; i --){
            int s = (x >> i) & 1;
            if(son[p][1 - s] != 0){
                res += (1 << i);
                p = son[p][1 - s];
            }
            else{
                p = son[p][s];
            }
        }
        return res;
    }
}
