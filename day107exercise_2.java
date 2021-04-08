package day107;
//153. 寻找旋转排序数组中的最小值
public class day107exercise_2 {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int mid = l + r >> 1;
            if(nums[mid] > nums[r]){
                l = mid + 1;
            }
            else{
                r = mid;
            }
        }
        return nums[l];
    }
}
