package day130;
//740. 删除并获得点数
public class day130exercise_1 {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int len = nums.length;
        int max = nums[0];
        for(int num : nums){
            max = Math.max(num,max);
        }
        int[] f = new int[max + 1];
        int[] map = new int[max + 1];
        for(int num : nums){
            map[num] ++;
        }
        f[0] = map[0];
        f[1] = Math.max(f[0],map[1]);
        for(int i = 2; i <= max; i ++){
            f[i] = Math.max(f[i - 1],f[i - 2] + i * map[i]);
        }
        return f[max];
    }
}
