import java.util.*;

public class Exercise {
    public static void main(String[] args) {
       Integer[] arr = new Integer[]{1,2,3,4};
       hello(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void hello(Integer[] arr){
        arr[0] = 100;
    }
}
