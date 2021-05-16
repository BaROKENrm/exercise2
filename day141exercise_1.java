package day141;
//5759. 找出所有子集的异或总和再求和
public class day141exercise_1 {
    int res = 0;
    public int subsetXORSum(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        dfs(0,0,nums);
        return res;
    }

    public void dfs(int i, int sum, int[] nums){
        if(i == nums.length){
            res += sum;
            return;
        }
        dfs(i + 1, sum ^ nums[i], nums);
        dfs(i + 1, sum, nums);
    }
}
