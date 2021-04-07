package day106;
//机器人走路
import java.util.LinkedList;
import java.util.Queue;

public class day106exercise_1 {
    public static void main(String[] args) {
        day106exercise_1 d = new day106exercise_1();
        System.out.println(d.movingCount(3, 10, 10));
        Queue<Integer> q = new LinkedList<>();
    }
    public int movingCount(int threshold, int rows, int cols)
    {
        int res = 0;
        if(rows < 1 || cols < 1){
            return res;
        }
        if(threshold < 1){
            return 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] flag = new boolean[rows][cols];
        queue.add(new int[]{0,0});
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        while(!queue.isEmpty()){
            int size = queue.size();
            int[] arr = queue.poll();
            int x = arr[0];
            int y = arr[1];
            if(fun2(x,y) > threshold || flag[x][y]){
                continue;
            }
            res ++;
            flag[x][y] = true;
            for(int i = 0; i < 4; i ++){
                int a = x + dx[i];
                int b = y + dy[i];
                if(a >= 0 && a < rows && b < cols && b >= 0){
                    queue.offer(new int[]{a,b});
                }

            }

        }
        return res;

    }

    public int fun2(int x,int y){
        int sum = fun1(x) + fun1(y);
        return sum;
    }

    public int fun1(int x){
        int ret = 0;
        while(x != 0){
            ret = ret + x % 10;
            x /= 10;
        }
        return ret;
    }
}
