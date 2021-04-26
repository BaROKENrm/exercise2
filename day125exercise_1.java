package day125;

public class day125exercise_1 {
    public int shipWithinDays(int[] weights, int D) {
        int l = 1;
        int r = 25000000;
        while(l < r){
            int mid = l + r >> 1;
            if(check(weights,mid,D)){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return r;
    }
    public boolean check(int[] nums,int mid, int D){
        int sum = 0;
        int time = 1;
        for(int num : nums){
            if(num > mid){
                return false;
            }
            sum += num;
            if(sum > mid){
                sum = num;
                time ++;
            }
        }
        if(time > D){
            return false;
        }
        return true;
    }
}
