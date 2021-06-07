package day163;

import java.util.Scanner;

/*
一位雇主想要招聘一个工人，有个人前来应聘，这位雇主让每个人写下期望的薪资，然后再进行选择。
因为这个雇主十分狡猾，ta会选择期望薪资最低的人，但是这个人可能不是唯一的，为了避免纠纷，ta会选择在没有和其他人提出的期望薪资相同的情况下期望薪资最低的人录用。
求这个最低薪资，如果没有合适的人，则输出
 */
public class day163exercise_3 {
    static int N = 10005;
    static int[] map = new int[N];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 1; i <= n; i ++){
            int wish = scan.nextInt();
            map[wish] ++;
        }
        for(int i = 1; i <= 10000; i ++){
            if(map[i] == 0){
                continue;
            }
            if(map[i] == 1){
                System.out.println(i);
                return;
            }
        }
        System.out.println("-1");
    }
}
