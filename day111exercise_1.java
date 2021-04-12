package day111;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class day111exercise_1{


    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for(int num : nums){
            list.add(num + "");
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuffer sb = new StringBuffer();
        for(String s : list){
            sb.append(s);
        }
        return sb.toString();
    }
}
