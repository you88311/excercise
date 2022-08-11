import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static private Integer[] BFS(Queue<Integer[]> queue, Integer[] cur, int[][] maze, int[][] fire, int R, int C, boolean isFire) {
        cur = queue.poll();
        int[] dX = {1, -1, 0, 0};
        int[] dY = {0, 0, 1, -1};
        int x;
        int y;
        for (int i = 0; i < 4; i++) {
            x = cur[0] + dX[i];
            y = cur[1] + dY[i];
            if (0 > x || x >= R || 0 > y || y >= C) continue;
            if(maze[x][y] == -1) continue;
            if(isFire){
                if(fire[x][y] == 0) {
                    fire[x][y] = fire[cur[0]][cur[1]] + 1;
                    queue.add(new Integer[]{x,y});
                }
            }else {
                if(maze[x][y] == 0) {
                    if(fire[x][y]!= 0 && fire[x][y] > maze[cur[0]][cur[1]] + 1) {
                        maze[x][y] = maze[cur[0]][cur[1]] + 1;
                        queue.add(new Integer[]{x, y});
                    }else if(fire[x][y] == 0){
                        maze[x][y] = maze[cur[0]][cur[1]] + 1;
                        queue.add(new Integer[]{x, y});
                    }
                }
            }
        }

        return cur;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int R = Integer.parseInt(arr[0]);
        int C = Integer.parseInt(arr[1]);

        int[][] maze = new int[R][C];
        int[][] fire = new int[R][C];
        Queue<Integer[]> jQueue = new LinkedList<>();
        Queue<Integer[]> fQueue = new LinkedList<>();
        char c;
        for (int i = 0; i < R; i++) {
            arr = br.readLine().split("");
            for (int j = 0; j < arr.length; j++) {
                c = arr[j].charAt(0);
                if (c == 'J') {
                    jQueue.add(new Integer[]{i, j});
                    maze[i][j] = 1;
                } else if (c == 'F') {
                    fQueue.add(new Integer[]{i, j});
                    maze[i][j] = -1;
                    fire[i][j] = 1;
                } else if (c == '#') {
                    maze[i][j] = -1;
                } else
                    maze[i][j] = 0;
            }
        }

        Integer[] curJ = {0, 0};
        Integer[] curF = {0, 0};
        while (!fQueue.isEmpty()) {
            BFS(fQueue, curF, maze, fire, R, C, true);
        }

        while (!jQueue.isEmpty()) {
            curJ = BFS(jQueue, curJ, maze, fire, R, C, false);
            if (curJ[0] == 0 || curJ[1] == 0
                    || curJ[0] == R - 1 || curJ[1] == C - 1) {
                System.out.print(maze[curJ[0]][curJ[1]]);
                return;
            }
        }

        System.out.print("IMPOSSIBLE");
        br.close();
    }
}