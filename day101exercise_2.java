package day101;
//面试题 17.21. 直方图的水量
public class day101exercise_2 {
    public int trap(int[] height) {
        int len = height.length;
        if(len == 0){
            return 0;
        }
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = height[0];
        right[len - 1] = height[len - 1];
        for(int i = 1; i < len; i ++){
            left[i] = Math.max(left[i - 1],height[i]);
        }

        for(int i = len - 2; i >= 0; i --){
            right[i] = Math.max(right[i + 1],height[i]);
        }
        int res = 0;
        for(int i = 0; i < len; i ++){
            res += Math.min(left[i],right[i]) - height[i];
        }
        return res;
    }
}
