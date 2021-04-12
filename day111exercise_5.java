package day111;

import java.util.ArrayList;
import java.util.List;

public class day111exercise_5 {
    List<List<Integer>> ret = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int len;
    boolean[] flag;
    public List<List<Integer>> permutation(int[] nums) {
        if(nums.length == 0){
            return ret;
        }
        len = nums.length;
        flag = new boolean[len];
        dfs(nums);
        return ret;
    }


    public void dfs(int[] nums){
        if(list.size() == len){
            ret.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < len; i ++){
            if(!flag[i]){
                if(i > 0 && nums[i] == nums[i - 1] && flag[i - 1]){
                    continue;
                }
                flag[i] = true;
                list.add(nums[i]);
                dfs(nums);
                list.remove(list.size() - 1);
                flag[i] = false;
            }
        }
    }
}
