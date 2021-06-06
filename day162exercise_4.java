package day162;

import java.util.Arrays;

//    5777. 使数组元素相等的减少操作次数
public class day162exercise_4 {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0; // 总操作次数
        int count = 0; // 每个元素操作次数
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                count++;
            }
            res += count;
        }
        return res;
    }
}
