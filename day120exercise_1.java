package day120;
//91. 解码方法
public class day120exercise_1 {
    public int numDecodings(String s) {
        int len = s.length();
        if(len == 0){
            return 0;
        }
        int[] dp = new int[len + 1];
        dp[0] = 1 ;
        dp[1] = s.charAt(0) == '0' ?  0 : 1;
        for (int i = 1; i < len; i++) {
            if(s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) < '7'){//10-26
                if(s.charAt(i) == '0'){ //10  20
                    dp[i + 1] = dp[i - 1];
                }
                else{
                    dp[i + 1] = dp[i - 1] + dp[i];
                }
            }
            else if(s.charAt(i) == '0'){// 当前大于26的10的倍数的数 例30 40
                return 0;
            }
            else{
                dp[i + 1] = dp[i];
            }
        }
        return dp[len];
    }
}
