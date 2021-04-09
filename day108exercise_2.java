package day108;
//154. 寻找旋转排序数组中的最小值 II 
public class day108exercise_2 {
    public int findMin(int[] nums) {
        int len = nums.length;
        int l = 0;
        int n = len - 1;
        while(n > 0 && nums[n] == nums[l]){
            n --;
        }
        int r = n;
        if(nums[r] > nums[0]){
            return nums[0];
        }
        while(l < r){
            int mid = l + r >> 1;
            if(nums[mid] < nums[0]){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
