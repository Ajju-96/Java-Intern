import java.util.List;
import java.util.stream.Collectors;

public class Example3_StreamAPI {
    public static void main(String[] args){
        // map : transform each item.

        List<Integer> nums = List.of(5,12,8,3,20,7);

        List<Integer> res = nums.stream()
                .map(n -> n * 2)    //Intermediate operation
                .collect(Collectors.toList());

        System.out.println(res);
    }
}
