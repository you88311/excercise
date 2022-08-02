import java.util.*;

public class Solution {
    public String readVertically(String[] arr) {
        // TODO:
        StringBuilder sb = new StringBuilder();
        int[] strLength = new int[arr.length];
        int maxLength = 0;
        for(int i = 0 ; i < arr.length; i++){
            strLength[i] = arr[i].length();
            maxLength = Math.max(maxLength, strLength[i]);
        }

        for(int i = 0; i < maxLength ; i++){
            for(int j = 0; j < arr.length; j++){
                if(i < strLength[j])
                    sb.append(arr[j].charAt(i));
            }
        }
        return sb.toString();
    }
}
