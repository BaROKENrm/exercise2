package day129;
/*
给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数 target 和 start ，请你找出一个下标 i ，满足 nums[i] == target 且 abs(i - start) 最小化 。注意：abs(x) 表示 x 的绝对值。

返回 abs(i - start) 。

题目数据保证 target 存在于 nums 中。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-distance-to-the-target-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
1848. 到目标元素的最小距离
 */
public class day129exercise_3 {
    public int getMinDistance(int[] nums, int target, int start) {
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < len; i ++){
            if(nums[i] == target){
                int num = Math.abs(i - start);
                min = Math.min(min,num);
            }
        }
        return min;
    }
}
