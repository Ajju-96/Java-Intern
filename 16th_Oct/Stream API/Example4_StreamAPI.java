
import java.util.*;
import java.util.stream.Collectors;

public class Example4_StreamAPI {
    public static void main(String[] args) {

        // 1. Sort numerical values in ascending order
        List<Integer> nums = Arrays.asList(19, 82, 39, 34, 43);

        List<Integer> res = nums.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Sorted Numbers: " + res);


        // 2. Sort strings alphabetically
        List<String> words = Arrays.asList(
                "banana", "fig", "apple", "kiwi"
        );

        List<String> sortedWords = words.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Sorted Strings: " + sortedWords);


        // 3. Sort strings by length
        List<String> byLength = words.stream()
                .sorted((a, b) -> a.length() - b.length())
                .collect(Collectors.toList());

        System.out.println("Strings by Length: " + byLength);
    }
}
