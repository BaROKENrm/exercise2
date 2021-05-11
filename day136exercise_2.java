package day136;

import java.util.Scanner;
/*
农夫约翰在给他的奶牛们喂食时遇到了一个问题。

他共有 N 头奶牛，编号 1∼N。

每次喂食前，这 N 头奶牛会按照 1∼N 的顺序站成一排。

此外，每头奶牛都被分配了一个可能不唯一的整数。

那么所有被分配的整数就形成了一个长度为 N 的整数序列。

请你在该整数序列中找出一个连续的非空子序列，使得子序列中元素的异或和能够最大。

如果存在多个这样的序列，那么选择序列末端整数对应的奶牛编号更小的那个序列。

如果仍然存在多个可选的序列，那么选择长度最短的那个序列。

输入格式
第一行包含整数 N。

第 2∼N+1 行，每行包含一个整数，其中第 i 行的整数表示编号为 i−1 的牛被分配的整数值。

输出格式
输出三个整数，分别表示最大的异或和，所选序列首端整数对应的奶牛编号，所选序列末端整数对应的奶牛编号。

数据范围
1≤N≤105，
分配给奶牛的整数的范围是 [0,221−1]。
 */
public class day136exercise_2 {
    static int N = 100010, M = 100010 * 21;
    static int[] s = new int[N], count = new int[N];
    static int[][] son = new int[M][2];
    static int n, index;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for(int i = 1;i <= n; i ++){
            int num = scan.nextInt();
            s[i] = s[i - 1] ^ num;
        }

        insert(s[0],0);
        int res = -1;
        int a = 0;
        int b = 0;
        for(int i = 1; i <= n; i ++){
            int k = query(s[i]);
            int t = s[k] ^ s[i];
            if(t > res){
                res = t;
                a = k + 1;
                b = i;
            }
            insert(s[i],i);
        }
        System.out.println(res + " " + a + " " + b );
    }

    public static void insert(int x, int k){
        int p = 0;
        for(int i = 20; i >= 0; i --){
            int u = x >> i & 1;
            if(son[p][u] == 0){
                son[p][u] = ++ index;
            }
            p = son[p][u];
        }
        count[p] = k;
    }

    public static int query(int x){
        int p = 0;
        for(int i = 20; i >= 0; i --){
            int u = x >> i & 1;
            if(son[p][1 - u] != 0){
                p = son[p][1 - u];
            }
            else{
                p = son[p][u];
            }
        }
        return count[p];
    }


}
