package day155;
//5772. 检查某单词是否等于两单词之和
public class day155exercise_4 {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        char[] a = firstWord.toCharArray();
        char[] b = secondWord.toCharArray();
        char[] c = targetWord.toCharArray();
        int aSum = 0;
        int bSum = 0;
        int cSum = 0;
        for(int i = 0; i < a.length; i ++){
            aSum = aSum * 10 + a[i] - 'a';
        }

        for(int i = 0; i < b.length; i ++){
            bSum = bSum * 10 + b[i] - 'a';
        }

        for(int i = 0; i < c.length; i ++){
            cSum = cSum * 10 + c[i] - 'a';
        }

        return aSum + bSum == cSum;
    }
}

