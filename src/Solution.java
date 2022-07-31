
import java.util.*;

public class Solution {
    public ArrayList<Integer[]> divideChocolateStick(int M, int N) {
        // TODO:
        ArrayList<Integer> tmp = new ArrayList<>();
        int gcd = 1;
        int min = Math.min(M, N);
        int max = Math.max(M, N);
        int num;

        /*최대공약수 구하기*/
        while (gcd != 0) {
            gcd = max / min;
            max = gcd;
        }
        gcd = min;

        /*공약수 구하기*/
        for (int i = 1; i <= Math.sqrt(gcd); i++) {
            if (M % i == 0 && N % i == 0)
                tmp.add(i);
        }

        ArrayList<Integer> common = new ArrayList<>(tmp);
        for(Integer e : tmp){
            num = gcd/e;
            if(e == Math.sqrt(gcd)) continue;
            if(M % num == 0 && N % num == 0)
                common.add(num);
        }

        /*조합 return*/
        ArrayList<Integer[]> result = new ArrayList<>();
        for (Integer e : common) {
            Integer[] arr = new Integer[]{e, M / e, N / e};
            result.add(arr);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        ArrayList<Integer[]> result = sol.divideChocolateStick(4,8);
        for(Integer[] arr : result){
            System.out.println(Arrays.toString(arr));
        }
    }
}

