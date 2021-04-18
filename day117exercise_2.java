package day117;
//bfs
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class day117exercise_2 {
        static int N = 110;
        static int n;
        static int m;
        static int[][] arr = new int[N][N];
        static int[][] d = new int[N][N];
        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            n = scan.nextInt();
            m = scan.nextInt();
            for(int i = 1; i <= n; i ++){
                for(int j = 1; j <= m; j ++){
                    arr[i][j] = scan.nextInt();
                }
            }
            for(int i = 1; i <= n; i ++){
                for(int j = 1; j <= m; j ++){
                    d[i][j] = -1;
                }
            }
            bfs();
            System.out.println(d[n][m]);
        }

        public static void bfs(){
            int[] dx = {0,1,0,-1};
            int[] dy = {1,0,-1,0};
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{1,1});
            d[1][1] = 0;
            while(!queue.isEmpty()){
                int[] temp = queue.poll();
                for(int i = 0;i < 4; i ++){
                    int a = temp[0] + dx[i];
                    int b = temp[1] + dy[i];
                    if(a >= 0 && a <= n && b >= 0 && b <= m && arr[a][b] == 0 && d[a][b] == -1){
                        queue.offer(new int[]{a,b});
                        d[a][b] = d[temp[0]][temp[1]] + 1;
                    }
                }
            }
        }

    }

