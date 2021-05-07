package day132;
//1486. 数组异或操作
public class day132exercise_1 {
    public int xorOperation(int n, int start) {
        int res = 0;
        for(int i = 0; i < n; i ++){
            res ^= start + 2 *i;
        }
        return res;
    }
}
