package day101;

import java.util.HashMap;
import java.util.Map;
//剑指 Offer 56 - II. 数组中数字出现的次数 II
//哈希表
public class day101exercise_3 {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,1) +1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() != 3){
                return entry.getKey();
            }
        }
        return 0;
    }
}
