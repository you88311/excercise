import java.util.*;

public class Exercise {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
                add(4);
            }
        };

        System.out.println(list.stream().mapToInt(Integer::valueOf).sum());

    }
}
