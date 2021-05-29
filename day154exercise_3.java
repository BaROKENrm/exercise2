package day154;

import java.util.HashMap;
import java.util.Map;
//560. 和为K的子数组
public class day154exercise_3 {
    int N = 20010;
    int[] s = new int[N];
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 1;i <= n; i ++){
            s[i] = s[i - 1] + nums[i - 1];
        }
        int res = 0;
        map.put(0,1);
        for(int i = 1; i <= n; i ++){
            if(map.containsKey(s[i] - k)){
                res += map.get(s[i] - k);
            }
            map.put(s[i],map.getOrDefault(s[i], 0) + 1);
        }
        return res;
    }
}
