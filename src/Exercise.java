import java.util.*;

public class Exercise {
    public static int paveBox(Integer[] boxes) {

        //queue with Integer선언
        Queue<Integer> queue = new LinkedList<>();
        //maxCnt
        Integer maxCnt = 1;
        //cnt
        Integer cnt = 1;
        Integer back;

        //queue에 boxe를 집어 넣는다
        for(Integer e : boxes){
            queue.add(e);
        }
        //Integer front = queue.poll()
        Integer front = queue.poll();

        //queue가 empty가 아닐 때
        while(!queue.isEmpty()){
            back = queue.poll();
            if( front < back){
                // => front = 만약 queue가 empty가 아니면 다시 queue.poll() + cnt = 1
                front = back;
                cnt = 1;
            }
            else{
                //=> cnt ++  + maxCnt = max(maxCnt,cnt )
                cnt++;
                maxCnt = Math.max(maxCnt, cnt);
            }
        }

        return maxCnt;
    }

    public static void main(String[] args) {
        System.out.println(paveBox( new Integer[]{5, 1, 4, 6,7,3,2,1,2,9,1,1,1,2,3,4,5,6,6,7}));
    }
}
