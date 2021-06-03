package day159;

import java.util.HashSet;
import java.util.Set;
//523. 连续的子数组和
public class day159exercise_1 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for(int i = 1; i <= n; i ++){
            s[i] = s[i - 1] + nums[i - 1];
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 2; i <= n; i ++){
            set.add(s[i - 2] % k);
            if(set.contains(s[i] % k)){
                return true;
            }
        }
        return false;
    }
}
