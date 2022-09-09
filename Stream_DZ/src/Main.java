import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) > 0 && list.get(i)%2 == 0)
                result.add(list.get(i));
        }
        Collections.sort(result);
        System.out.println(result);
    }
}
