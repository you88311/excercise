import java.io.*;
import java.util.*;

public class Solution {
    public String compressString(String str) {
        if(str == "") return "";

        StringBuilder sb = new StringBuilder();
        char prev = str.charAt(0);
        int cnt = 0;

        /*기존 풀이*/
        // for(int i = 0; i < str.length(); i ++){
        //   if(prev == str.charAt(i) && i != str.length()-1)
        //     cnt ++;
        //   else{
        //     if(cnt >= 3)
        //       sb.append(cnt).append(prev);
        //     else{
        //       for(int j = 0; j < cnt; j ++){
        //         sb.append(prev);
        //       }
        //     }
        //     cnt = 1;
        //     prev = str.charAt(i);
        //   }

        //   if(i == str.length()-1)
        //     sb.append(prev);
        // }

        /*Reference 참고하여 마지막 문자 연속 경우 위해 str에 dummy추가하는 풀이*/
        str = str + ' ';

        for(int i = 0; i < str.length(); i ++){
            if(prev == str.charAt(i))
                cnt ++;
            else{
                if(cnt >= 3)
                    sb.append(cnt).append(prev);
                else{
                    for(int j = 0; j < cnt; j ++){
                        sb.append(prev);
                    }
                }
                cnt = 1;
                prev = str.charAt(i);
            }
        }

        return sb.toString();
    }
}
