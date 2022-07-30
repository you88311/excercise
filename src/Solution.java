import java.util.*;

public class Solution {
    public int connectedVertices(int[][] edges) {
        // TODO:
        Queue<Integer[]> queue = new LinkedList<>();
        int groupCnt = 0;
        int size = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int nx, ny, x, y;
        Integer[] cur;

        for (int[] edge : edges) {
            for (int i : edge) {
                size = Math.max(size, i);
            }
        }
        size += 1;

        int[][] graph = new int[size][size]; //0으로 초기화
        boolean[][] visited;
        for (int[] e : edges) {
            //연결은1, 연결x는 0(기본값) , 방문했으면 -1
            graph[e[0]][e[1]] = 1;
            graph[e[1]][e[0]] = 1;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (graph[i][j] != 1 || i == j) continue;
                queue.add(new Integer[]{i,j});
                graph[i][j] = -1;
                graph[j][i] = -1;
                while (!queue.isEmpty()) {
                    cur = queue.poll();
                    x = cur[0];
                    y = cur[1];
                    if (graph[x][y] == 1) {
                        for (int k = 0; k < 4; k++) {
                            nx = x + dx[k];
                            ny = y + dy[k];
                            if(nx < 0 || ny < 0 || nx >= size || ny >= size) continue;
                            if (graph[nx][ny] == 1) {
                                queue.add(new Integer[]{nx, ny});
                                graph[nx][ny] = -1;
                                graph[ny][nx] = -1;
                            }
                        }
                    }
                }
                groupCnt++;
            }
        }
        return groupCnt;
    }
}
