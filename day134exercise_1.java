package day134;
//1482. 制作 m 束花所需的最少天数
public class day134exercise_1 {
    int[] bloomDay;
    int m;
    int k;
    public int minDays(int[] bloomDay, int m, int k) {
        this.bloomDay = bloomDay;
        this.k = k;
        this.m = m;
        int len = bloomDay.length;
        if(len < m * k){
            return -1;
        }
        int l = bloomDay[0];
        int r = bloomDay[0];
        for(int i = 1; i < len; i ++){
            l = Math.min(bloomDay[i],l);
            r = Math.max(bloomDay[i],r);
        }

        while(l < r){
            int mid = l + r >> 1;
            if(check(mid)){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return l;
    }


    public boolean check(int mid){
        int count = 0;//花束的数量
        int size = 0;//相邻的花的个数
        for(int i = 0; i < bloomDay.length; i ++){
            if(bloomDay[i] <= mid){
                size ++;
                if(size == k){
                    count ++;
                    size = 0;
                }
            }
            else{
                size = 0;
            }
        }
        return count >= m;
    }
}
