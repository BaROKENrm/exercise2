package day106;
//81. 搜索旋转排序数组 II
public class day106exercise_2 {
    public boolean check(int[] nums,int l,int r,int target){
        while(l < r){
            int mid = l + r >> 1;
            if(nums[mid] >= target){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return target == nums[r];
    }
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if(len == 1){
            return nums[0] == target;
        }
        int n = len - 1;
        while(n > 0 && nums[0] == nums[n]){
            n --;
        }
        if(nums[n] >= nums[0]){
            return check(nums,0,n,target);
        }
        int l = 0, r = n;
        while(l < r){
            int mid = l + r >> 1;
            if(nums[mid] < nums[0]){
                r = mid;
            }
            else{
                l = mid - 1;
            }
        }
        if(target >= nums[0]){
            return check(nums,0,r,target);
        }

        return check(nums,r,n,target);

    }
}
