package day155;

import java.util.Arrays;
//5755. 数组中最大数对和的最小值
public class day155exercise_2 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int max = 0;
        while(l < r){
            max = Math.max(max,nums[l ++] + nums[r --]);
        }
        return max;
    }
}
