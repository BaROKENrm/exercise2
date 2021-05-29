package day154;

import java.util.HashMap;
import java.util.Map;
//1074. 元素和为目标值的子矩阵数量
public class day154exercise_2 {
    int N = 110;
    int[][] s = new int[N][N];
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int res = 0;
        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= m; j ++){
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        for(int x1 = 1; x1 <= n; x1 ++){
            for(int x2 = x1; x2 <= n; x2 ++){
                int cur = 0;
                Map<Integer,Integer> map = new HashMap<>();
                for(int y2 = 1; y2 <= m; y2 ++){
                    cur = get(x1,1,x2,y2);
                    if (cur == target) res++;
                    if (map.containsKey(cur - target)) res += map.get(cur - target);
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
        }

        return res;
    }
    public int get(int x1, int y1, int x2 , int y2){
        int res = s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1 - 1][y1 - 1];
        return res;
    }
}

