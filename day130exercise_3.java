package day130;
// leetcode 1837
public class day130exercise_3 {

    public int sumBase(int n, int k) {
        int num = 0;
        while(n != 0){
            num += n % k;
            n /= k;
        }
        return num;
    }
}
