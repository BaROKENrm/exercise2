package day156;
//342. 4的幂
public class day156exercise_1 {
    public boolean isPowerOfFour(int n) {
        return n > 0 && ((n & (n - 1)) == 0) && (n % 3 == 1);
    }
}
