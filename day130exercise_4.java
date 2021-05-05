package day130;

import java.util.Arrays;
//1838. 最高频元素的频数
public class day130exercise_4 {
    public int maxFrequency(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        int res = 0;
        long[] s = new long[len + 1];
        for(int i = 1; i <= len; i ++){
            s[i] = s[i - 1] + nums[i - 1];
        }

        for(int i = 1; i <= len; i ++){
            int l = 1, r = i;
            while(l < r){
                int mid = l + r >> 1;
                if(nums[i - 1] * (long)(i - mid + 1) - (s[i] - s[mid - 1]) <= k) r = mid;
                else l = mid + 1;
            }
            res = Math.max(res, i - r + 1);
        }
        return res;
    }
}
