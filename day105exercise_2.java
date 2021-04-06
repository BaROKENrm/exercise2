package day105;
// 删除有序数组中的重复项 II
public class day105exercise_2 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len < 0 || nums == null){
            return 0;
        }
        int k = 2;
        for(int i = 2; i < len; i ++){
            if(nums[i] != nums[k - 1] || nums[i] != nums[k - 2]){
                nums[k ++] = nums[i];
            }
        }
        return k;
    }
}
