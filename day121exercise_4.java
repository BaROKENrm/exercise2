package day121;

import java.util.TreeSet;
//363. 矩形区域不超过 K 的最大数值和
public class day121exercise_4 {
    int[][] f;
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        f = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= m; j ++){
                f[i][j] = f[i - 1][j] + f[i][j - 1] - f[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int res = Integer.MIN_VALUE;
        for(int x1 = 1; x1 <= n; x1 ++){
            for(int x2 = x1; x2 <= n; x2 ++){
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for(int y2 = 1; y2 <= m; y2 ++){
                    int s = get(x1,1,x2,y2);
                    Integer num = set.ceiling(s - k);
                    if(num != null){
                        res = Math.max(res,s - num);
                    }
                    set.add(s);
                }
            }
        }
        return res;
    }

    public int get(int x1,int y1,int x2, int y2){
        return f[x2][y2] - f[x1 - 1][y2] - f[x2][y1 - 1] + f[x1 - 1][y1 - 1];
    }
}
