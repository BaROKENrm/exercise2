package day131;

import java.util.Arrays;
//611. 有效三角形的个数
public class day131exercise_3 {
    public int triangleNumber(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int res = 0;
        for(int i = len - 1; i >= 2; i --){
            int l = 0;
            int r = i - 1;
            while(l < r){
                if(nums[l] + nums[r] > nums[i]){
                    res += r - l;
                    r --;
                }
                else{
                    l ++;
                }
            }
        }
        return res;
    }
}
