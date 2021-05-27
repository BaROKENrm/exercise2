package day152;
// leetcode 461. 汉明距离

public class day152exercise_2 {
    public int hammingDistance(int x, int y) {
        int res = 0;
        for(int i = 0; i < 31; i ++){
            int a = x >> i & 1;
            int b = y >> i & 1;
            if((a ^ b) == 1){
                res ++;
            }
        }
        return res;
    }
}
