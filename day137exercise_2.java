package day137;
//1310. 子数组异或查询
public class day137exercise_2 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int len = arr.length;
        int[] s = new int[len + 1];
        for(int i = 0; i < len; i ++){
            s[i + 1] = s[i] ^ arr[i];
        }

        int n = queries.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i ++){
            int a = queries[i][0];
            int b = queries[i][1] + 1;
            res[i] = s[a] ^ s[b];
        }
        return res;
    }
}
