package day122;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day122exercise_2 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer>[] dp = new ArrayList[n];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j].size()> sub.size()) {
                    sub = dp[j];
                }
            }
            List<Integer> list = new ArrayList<>(sub);
            list.add(nums[i]);
            dp[i] = list;
            if (dp[i].size() > ans.size()) {
                ans = dp[i];
            }
        }
        return ans;
    }
}
