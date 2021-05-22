package day147;
// 810. 黑板异或游戏
public class day147exercise_1 {
    public boolean xorGame(int[] nums) {
        if(nums.length % 2 == 0){
            return true;
        }
        int res = 0;
        for(int num : nums){
            res ^= num;
        }
        return res == 0;
    }
}
