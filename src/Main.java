import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean visited[] = new boolean[n + 1];
        LinkedList<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 0; i < n+1; i++) {
            graph[i] = new LinkedList<Integer>();
        }

        Integer u, v;
        int comCnt = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.valueOf(st.nextToken());
            v = Integer.valueOf(st.nextToken());
            //연결리스트로 그래프 저장
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i < n+1; i++) {
            if(visited[i]) continue;

            queue.add(i);
            visited[i] = true;
            //bfs
            while(!queue.isEmpty()){
                int cur = queue.poll();

                for (int adj : graph[cur]) {
                    if(!visited[adj]){
                        queue.add(adj);
                        visited[adj] = true;
                    }
                }
            }
            comCnt++;
        }

        System.out.println(comCnt);
    }
}