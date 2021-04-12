package day111;

import java.util.Scanner;
/*
给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。

注意：

空字符串被视为0。
如果结果中包含前导零，则需要将前导零删除，最后删除的前导零不用包含在移除的 k 个数字中。
输入格式
第一行输入一个字符串，用来表示非负整数 num。

第二行输入一个整数，表示 k。

输出格式
输出一个字符串，表示移除 k 位数字后所能得到的最小数字。

数据范围
0≤k≤ 字符串长度 ≤100000，
num 中不包含任何前导 0。
 */
public class day111exercise_3 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int k = scan.nextInt();
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < s.length(); i ++){
            while(sb.length() > 0 && s.charAt(i) - '0' < sb.charAt(sb.length() - 1)- '0' && k != 0){
                k --;
                sb.deleteCharAt(sb.length() - 1);
            }
            if(sb.length() == 0 && s.charAt(i) == '0'){
                continue;
            }
            sb.append(s.charAt(i));
        }

        while(k > 0 && sb.length() > 0){
            sb.deleteCharAt(sb.length() - 1);
            k --;
        }
        if(sb.length() == 0){
            System.out.println("0");
        }
        else{
            System.out.println(sb.toString());
        }
    }
}
