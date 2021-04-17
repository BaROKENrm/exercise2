package day116;

import java.util.TreeSet;
//220. 存在重复元素 III
public class day116exercise_2 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        if(len == 0){
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < len; i ++){
            Long u = nums[i] * 1L;
            Long small = set.floor(u);
            Long big = set.ceiling(u);
            if(small != null && u - small <= t){
                return true;
            }
            if(big != null && big - u <= t){
                return true;
            }
            set.add(nums[i] * 1L);
            if(i >= k){
                set.remove(nums[i - k] * 1L);
            }
        }
        return false;
    }
}
