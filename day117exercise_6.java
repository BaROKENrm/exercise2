package day117;
//26. 删除有序数组中的重复项
public class day117exercise_6 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int l = 1;
        int r = 1;
        while(r < len){
            if(nums[r] != nums[r - 1]){
                nums[l ++] = nums[r];
            }
            r ++;
        }
        return l;
    }
}
