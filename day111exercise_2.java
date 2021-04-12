package day111;

import java.util.Arrays;
import java.util.Comparator;
//179. 最大数
public class day111exercise_2 {
    public static void main(String[] args) {
        char a = 5;
        char b = 4;
        System.out.println(a);
        System.out.println(a - '0');
        System.out.println(a - '0' > b - '0');
    }
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0 ; i < nums.length; i ++){
            strs[i] = nums[i] + "";
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        if(strs[0].equals("0")){
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        for(String s : strs){
            sb.append(s);
        }
        return sb.toString();
    }
}
