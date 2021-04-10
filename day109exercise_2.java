package day109;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//全排列
public class day109exercise_2 {
    static int n;
    static List<Integer> list = new ArrayList<>();
    static boolean[] flag;
    static int[] arr;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        flag = new boolean[n];
        arr = new int[n];
        for(int i = 1; i <= n ;i ++){
            arr[i - 1] = i;
        }
        dfs();
    }

    public static void dfs(){
        if(n == list.size()){
            for(int num : list){
                System.out.printf("%d ",num);
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < n; i ++){
            if(!flag[i]){
                list.add(arr[i]);
                flag[i] = true;
                dfs();
                list.remove(list.size() - 1);
                flag[i] = false;
            }
        }
    }
}
