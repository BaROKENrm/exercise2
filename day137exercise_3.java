package day137;
//1854. 人口最多的年份
public class day137exercise_3 {
    public int maximumPopulation(int[][] logs) {
        int res = 0, cnt = 0;
        for (int i = 1950; i <= 2050; i++) {    //循环年份
            int s = 0;      //记录当前年份存活人数
            for (int[] log : logs)
                if (i >= log[0] && i < log[1])  //如果存活
                    s ++ ;
            if (s > cnt) {  //记录存活人数最大值
                res = i;    //存活人数最多的年份
                cnt = s;
            }
        }
        return res;
    }
}
