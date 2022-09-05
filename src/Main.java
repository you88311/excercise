import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean visited[] = new boolean[n + 1];
        int com[] = new int[m + 1];

        combination(bw, visited, com, 0, n, m);

        bw.flush();
        bw.close();
    }

    static void combination(BufferedWriter bw, boolean visited[], int com[], int k, int n, int m) throws IOException {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                bw.write(com[i] + " ");
            }
            bw.write("\n");

            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if(k-1 >= 0 && com[k-1] > i) continue;
            com[k] = i;
            combination(bw, visited, com, k + 1, n, m);
        }
    }
}