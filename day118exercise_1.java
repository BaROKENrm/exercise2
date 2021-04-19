package day118;
//27. 移除元素
public class day118exercise_1 {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if(len == 0 ){
            return 0;
        }
        int l = 0;
        int r = 0;
        while(r < len){
            if(nums[r] != val){
                nums[l] = nums[r];
                l ++;
            }
            r ++;
        }
        return l;
    }
}
