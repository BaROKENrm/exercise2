package day154;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*
给定一个整数数组 A，其包含 n 个正整数 a1,a2,…,an 以及一个整数数组 B，其包含 m 个正整数 b1,b2,…,bm。

请从数组 A 中挑选一个元素 a 并从数组 B 中挑选一个元素 b，使得 a+b 既不包含于 A 也不包含于 B。

例如，如果 A=[2,1,7] 而 B=[1,3,4]，则可以从 A 中选取 1，从 B 中选取 4，这样得到的数字 1+4=5 既不在 A 中，也不在 B 中。

但是，我们不能从 A 中选取 2，从 B 中选取 1，因为得到的数字 2+1=3 包含于 B。

可以证明这样的数对一定存在，如果答案不唯一则输出任意合理答案均可。

输入格式
第一行包含整数 n。

第二行包含 n 个整数 a1,…,an。

第三行包含整数 m。

第四行包含 m 个整数 b1,…,bm。

输出格式
共一行，输出 a 和 b，中间用空格隔开。
 */
public class day154exercise_1 {
    static int N = 110;
    static int[] a = new int[N], b = new int[N];
    static Set<Integer> set = new HashSet<>();
    static int n, m;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for(int i = 0; i < n; i ++){
            a[i] = scan.nextInt();
            set.add(a[i]);
        }
        m = scan.nextInt();
        for(int i = 0; i < m; i ++){
            b[i] = scan.nextInt();
            set.add(b[i]);
        }
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j ++){
                int num = a[i] + b[j];
                if(!set.contains(num)){
                    System.out.println(a[i] + " " + b[j]);
                    return;
                }
            }
        }

    }
}
