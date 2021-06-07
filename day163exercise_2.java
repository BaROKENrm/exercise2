package day163;

import java.util.Scanner;
/*
给定一个初始长度为 n 的数组 a 以及一个整数 x。

我们现在要对数组 a 进行延伸，具体方法如下：

我们从数组中的第一个元素开始，逐个遍历数组中的每个元素。

当遍历到数组中的元素 q 时，如果 q 能够被 x 整除，则在数组的末尾添加 x 个整数 qx，并开始遍历下一个元素。

否则，停止遍历，数组延伸结束。

注意，后面新增的元素也要被考虑在内，加以处理和判断。

请计算，在数组延伸结束后，数组中所有元素的和。

输入格式
第一行包含整数 T，表示共有 T 组测试数据。

每组数据的第一行包含两个整数 n 和 x。

第二行包含 n 个整数 a1,a2,…,an。

输出格式
每组数据输出一行，一个结果，表示延伸结束后，数组中所有元素的和。
 */
public class day163exercise_2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(T -- > 0){
            int n = scan.nextInt();
            int x = scan.nextInt();
            int count = 100005;
            long pSum = 0;
            long sum = 0;

            int[] w = new int[n];
            for(int i = 0; i < n; i ++){
                w[i] = scan.nextInt();
            }
            for(int i = 0; i < n; i ++){
                sum += w[i];
                int c = 0;
                for(int j = w[i]; j % x == 0; j /= x){
                    c ++;
                    if(c < count){
                        count = c;
                        pSum = sum - w[i];
                    }
                }
            }
            System.out.println(sum * (count + 1) + pSum);
        }
    }
}
