package day110;
//丑数2
public class day110exercise_1 {
    int a,b,c;
    public int nthUglyNumber(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        for(int i = 1 ; i <= n; i ++){
            int n2 = f[a] * 2;
            int n3 = f[b] * 3;
            int n5 = f[c] * 5;
            f[i] = Math.min(Math.min(n2,n3),n5);
            if(f[i] == n2) a ++;
            if(f[i] == n3) b ++;
            if(f[i] == n5) c ++;

        }
        return f[n - 1];
    }
}
