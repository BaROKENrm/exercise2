package day159;

import java.util.Arrays;
import java.util.Scanner;
/*
给定一个字符串 s，其中的每个字符都是 1,2 或 3。

请你求出同时包含字符 1,2,3 的 s 的最短子串的长度。

注意，子串必须是连续的。

输入格式
第一行包含整数 T，表示共有 T 组测试数据。

每组数据占一行，包含一个字符串 s，保证 s 中可能包含字符 1,2 或 3。

输出格式
每组数据输出一行，一个整数，表示符合条件的最短子串的长度。

如果不存在符合条件的子串，则输出 0。
 */
public class day159exercise_4 {
    static int map[] = new int[3];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(T -- > 0){
            String s = scan.next();
            char[] ch = s.toCharArray();
            int res = s.length() + 1;
            Arrays.fill(map,0);
            for(int i = 0; i < s.length(); i ++){
                int j = 0;
                map[ch[i] - '1'] ++;
                while(map[ch[j] - '1'] > 1){
                    map[ch[j] - '1'] --;
                    j ++;
                }
                if(map[0] > 0 && map[1] > 0 && map[2] > 0){
                    res = Math.min(res, i - j + 1);
                }
            }
            if(res == s.length() + 1){
                System.out.println(0);
            }
            else{
                System.out.println(res);
            }
        }
    }
}
