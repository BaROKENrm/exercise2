package day102;
//    1143. 最长公共子序列
public class day102exercise_1 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] f = new int[len1 + 1][len2 + 1];
        for(int i = 1; i <= len1; i ++){
            for(int j = 1; j <= len2; j ++){
                f[i][j] = Math.max(f[i - 1][j],f[i][j - 1]);
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    f[i][j] = Math.max(f[i][j],f[i - 1][j - 1] + 1);
                }
            }
        }
        int max = 0;
        for(int i = 0; i <= len2; i ++){
            max = Math.max(max,f[len1][i]);
        }
        return max;
    }
}
