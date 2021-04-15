package day114;
//213. 打家劫舍 II
public class day114exercise_1 {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int len = nums.length;
        int[] arr1 = new int[len - 1];
        for(int i = 0; i < len - 1; i ++){
            arr1[i] = nums[i];
        }
        int[] arr2 = new int[len - 1];
        for(int i = 1;i < len; i ++){
            arr2[i - 1] = nums[i];
        }
        int a = fun(arr1);
        int b = fun(arr2);
        return Math.max(a,b);
    }

    public int fun(int[] arr){
        int len = arr.length;
        int[] f = new int[len];
        f[0] = arr[0];
        f[1] = Math.max(arr[0],arr[1]);
        for(int i = 2; i < len; i ++){
            f[i] = arr[i];
            f[i] = Math.max(f[i - 2] + arr[i],f[i - 1]);
        }
        return f[len - 1];
    }
}
