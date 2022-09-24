import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] testCase = new int[n];
        int maxCase = 0;

        for(int i = 0; i < n ; i ++){
            st = new StringTokenizer(br.readLine());
            testCase[i] = Integer.parseInt(st.nextToken());
            if(i == 0) maxCase = testCase[i];
            else maxCase = (Math.max(maxCase, testCase[i]));
        }

        int[] dp = new int[maxCase+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i <= maxCase; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for(int test : testCase){
            bw.append(String.valueOf(dp[test])).append("\n");
        }

        bw.flush();
        bw.close();

        return;
    }
}
