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

        combination(bw, com, 0, n, m);

        bw.flush();
        bw.close();
    }

    static void combination(BufferedWriter bw, int com[], int k, int n, int m) throws IOException {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                bw.write(com[i] + " ");
            }
            bw.write("\n");

            return;
        }

        for (int i = 1; i < n + 1; i++) {
            com[k] = i;
            combination(bw, com, k + 1, n, m);
            //com[k] = 0 이런거 필요 없다. 어차피 덮어 씌워지기 때문
        }
    }
}