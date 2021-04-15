package day114;
/*
在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄，他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。现在，给出提莫对艾希的攻击时间序列和提莫攻击的中毒持续时间，你需要输出艾希的中毒状态总时长。
你可以认为提莫在给定的时间点进行攻击，并立即使艾希处于中毒状态。
 */
public class day114exercise_2 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(duration == 0){
            return 0;
        }
        if(timeSeries.length == 0){
            return 0;
        }
        int len = timeSeries.length;
        int res = 0;
        for(int i = 0; i < len - 1;  i ++){
            res += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        return res + duration;
    }
}
