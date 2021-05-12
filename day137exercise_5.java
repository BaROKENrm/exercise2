package day137;

import java.util.Stack;
//1856. 子数组最小乘积的最大值
public class day137exercise_5 {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        Stack<Integer> stk = new Stack<>();
        int[] l = new int[n];
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            while (stk.size() > 0 && nums[stk.peek()] >= nums[i]) {
                stk.pop();
            }
            l[i] = stk.size() == 0 ? 0 : stk.peek() + 1;
            stk.add(i);
        }
        stk.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (stk.size() > 0 && nums[stk.peek()] >= nums[i]) {
                stk.pop();
            }
            r[i] = stk.size() == 0 ? n - 1 : stk.peek() - 1;
            stk.add(i);
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, 1l * nums[i] * (sum[r[i] + 1] - sum[l[i]]));
        }
        int mod = (int) 1e9 + 7;
        return (int) (res % mod);
    }
}
