package day155;
//5754. 长度为三且各字符不同的子字符串
public class day155exercise_1 {
    public int countGoodSubstrings(String s) {
        int n = s.length();
        if(n < 3){
            return 0;
        }
        int res = 0;
        int l = 0;
        int r = 2;
        char[] ch = s.toCharArray();
        while(r < n){
            if(ch[l] != ch[l + 1] && ch[l + 1] != ch[r] && ch[l] != ch[r]){
                res ++;
            }
            l ++;
            r ++;
        }
        return res;
    }
}
