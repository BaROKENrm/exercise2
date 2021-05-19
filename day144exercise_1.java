package day144;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class day144exercise_1 {
    public int kthLargestValue(int[][] matrix, int k) {
        List<Integer> list = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] s = new int[n + 1][m + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                s[i][j] = s[i - 1][j] ^ s[i][j - 1] ^ s[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                list.add(s[i][j]);
            }
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        return list.get(k - 1);
    }
}
