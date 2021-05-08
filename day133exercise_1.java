package day133;

import java.util.Arrays;
//1723. 完成所有工作的最短时间
public class day133exercise_1 {
    int[] jobs;
    int[] works;
    public int minimumTimeRequired(int[] jobs, int k) {
        this.jobs = jobs;
        works = new int[k];
        int len = jobs.length;
        sort(0,len - 1);
        int sum = 0;
        for(int i = 0; i < len; i ++){
            sum += jobs[i];
        }
        int l = jobs[0];
        int r = sum;
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
        Arrays.fill(works,0);
        return dfs(0,mid);
    }

    public boolean dfs(int i, int mid) {
        if (i >= jobs.length) {
            return true;
        }
        int cur = jobs[i];
        for (int j = 0; j < works.length; ++j) {
            if (works[j] + cur <= mid) {
                works[j] += cur;
                if (dfs(i + 1, mid)) {
                    return true;
                }
                works[j] -= cur;
            }
            if (works[j] == 0 || works[j] + cur == mid) {
                break;
            }
        }
        return false;
    }

    public void sort(int l, int r){
        if(l >= r){
            return;
        }
        int i = l - 1;
        int j = r + 1;
        int x = jobs[l];
        while(i < j){
            do{
                i ++;
            }while(x < jobs[i]);

            do{
                j --;
            }while(x > jobs[j]);

            if(i < j){
                int temp = jobs[i];
                jobs[i] = jobs[j];
                jobs[j] = temp;
            }
        }
        sort(l,j);
        sort(j + 1,r);
    }
}
