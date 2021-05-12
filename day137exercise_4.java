package day137;
//1855. 下标对中的最大距离
public class day137exercise_4 {
    public int maxDistance(int[] nums1, int[] nums2) {
        int l = 0;
        int r = 0;
        int max = 0;
        while(l < nums1.length && r < nums2.length){
            if(r >= l && nums2[r] >= nums1[l]){
                max = Math.max(max,(r - l));
                r ++;
            }
            else{
                l ++;
                r ++;
            }
        }
        return max;
    }
}
