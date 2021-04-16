package day115;
//87. 扰乱字符串
public class day115exercise_2 {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        if(s1.equals(s2)){
            return true;
        }
        int[] arr = new int[26];
        for(int i = 0; i < s1.length(); i ++){
            arr[s1.charAt(i) - 'a'] ++;
            arr[s2.charAt(i) - 'a'] --;
        }
        for(int i = 0; i < 26; i ++){
            if(arr[i] != 0){
                return false;
            }
        }

        for (int i = 1; i < s1.length(); i++) {
            //s1左边--->s2左边      s1右边--->s2右边
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i)))
                return true;

            //s1左边--->s2右边 s1右边 --->s2左边
            if (isScramble(s1.substring(0, i), s2.substring(s1.length() - i))
                    && isScramble(s1.substring(i), s2.substring(0, s1.length() - i)))
                return true;
        }
        return false;
    }
}
