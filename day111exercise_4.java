package day111;
// 0 ~ n -1 缺失的数字
public class day111exercise_4 {
    public int getMissingNumber(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int mid = l + r >> 1;
            if(nums[mid] != mid){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }

        if(nums[r] == r){
            r ++;
        }
        return r;
    }

}
