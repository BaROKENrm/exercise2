package day127;
//45. 跳跃游戏 II
public class day127exercise_5 {
    public int jump(int[] nums) {
        int len = nums.length;
        int maxStep = 0;
        int time = 0;
        int end = 0;
        for(int i = 0; i < len - 1; i ++){
            maxStep = Math.max(maxStep, i + nums[i]);
            if(i == end){
                end = maxStep;
                time ++;
            }
        }
        return time;
    }
}
