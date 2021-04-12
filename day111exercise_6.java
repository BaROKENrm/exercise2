package day111;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day111exercise_6 {
    List<String> list = new ArrayList<>();
    char[] ch;
    boolean[] flag;
    int len;
    StringBuffer sb = new StringBuffer();
    public String[] permutation(String s) {
        len = s.length();
        ch = s.toCharArray();
        Arrays.sort(ch);
        flag = new boolean[len];
        dfs();
        return list.toArray(new String[list.size()]);
    }

    public void dfs(){
        if(sb.length() == len){
            list.add(sb.toString());
            return;
        }
        for(int i = 0; i < len; i ++){
            if(!flag[i]){
                if(i > 0 && ch[i] == ch[i - 1] && flag[i - 1]){
                    continue;
                }
                sb.append(ch[i]);
                flag[i] = true;
                dfs();
                sb.deleteCharAt(sb.length() - 1);
                flag[i] = false;
            }
        }
    }
}
