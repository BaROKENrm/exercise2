package day130;

import java.util.Scanner;
/*
单词接龙是一个与我们经常玩的成语接龙相类似的游戏。

现在我们已知一组单词，且给定一个开头的字母，要求出以这个字母开头的最长的“龙”，每个单词最多被使用两次。

在两个单词相连时，其重合部分合为一部分，例如 beast 和 astonish ，如果接成一条龙则变为 beastonish。

我们可以任意选择重合部分的长度，但其长度必须大于等于1，且严格小于两个串的长度，例如 at 和 atide 间不能相连。

输入格式
输入的第一行为一个单独的整数 n 表示单词数，以下 n 行每行有一个单词（只含有大写或小写字母，长度不超过20），输入的最后一行为一个单个字符，表示“龙”开头的字母。

你可以假定以此字母开头的“龙”一定存在。

输出格式
只需输出以此字母开头的最长的“龙”的长度。

数据范围
n≤20
 */
public class day130exercise_2 {
    static int N = 21;
    static int n, res;
    static int[] count = new int[N];
    static int[][] g = new int[N][N];
    static String[] word = new String[N];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for(int i = 0; i < n; i ++){
            word[i] = scan.next();
        }
        String start = scan.next();

        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                String a = word[i];
                String b = word[j];
                int min = Math.min(a.length(),b.length());
                for(int k = 1;k < min; k ++){
                    if(a.substring(a.length() - k).equals(b.substring(0,k))){
                        g[i][j] = k;
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < n; i ++){
            if(word[i].startsWith(start)){
                dfs(word[i],i);
            }
        }
        System.out.println(res);
    }


    public static void dfs(String dargon, int index){
        res = Math.max(res,dargon.length());
        count[index] ++;
        for(int i = 0; i < n; i ++){
            if(g[index][i] != 0 && count[i] < 2){
                dfs(dargon + word[i].substring(g[index][i]),i);
            }
        }
        count[index] --;
    }
}
