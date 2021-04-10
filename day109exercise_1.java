package day109;

import java.util.ArrayList;
import java.util.List;

//263. 丑数
public class day109exercise_1 {
    public boolean isUgly(int n) {
        if(n < 1){
            return false;
        }
        while(n % 2 == 0) n /= 2;
        while(n % 3 == 0) n /= 3;
        while(n % 5 == 0) n /= 5;
        return n == 1;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

    }

}
