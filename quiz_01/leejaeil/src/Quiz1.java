import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Quiz1 {

    public static void main(String[] args) {
        Integer[] inputs = {20, 7, 23, 19, 10, 15, 25, 8, 13};
        List<Integer> oneLoop = Arrays.asList(inputs);
        Collections.sort(oneLoop);

        int total = oneLoop.stream().mapToInt(v -> v.intValue()).sum();
        for (int i = 0; i < oneLoop.size(); i++) {
            Integer one = oneLoop.get(i);
            for (int j = i + 1; j < oneLoop.size(); j++) {
                Integer two = oneLoop.get(j);
                int temp = total - one.intValue() - two.intValue();
                if (temp == 100) {
                    for (Integer value : oneLoop) {
                        if (!value.equals(one) && !value.equals(two)) {
                            System.out.println(value);
                        }
                    }
                }
            }
        }
    }
}
