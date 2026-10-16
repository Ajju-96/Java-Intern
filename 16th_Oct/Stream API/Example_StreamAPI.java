// Stream API
import java.util.*;
import java.util.stream.Collectors;

public class Example_StreamAPI {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> res = nums.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println("Original List: " + nums);
        System.out.println("Result List: " + res);
    }
}
