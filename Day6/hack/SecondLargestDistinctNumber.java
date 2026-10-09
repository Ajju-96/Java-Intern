import java.util.Scanner;

public class SecondLargestDistinctNumber {
    // Returns the second-largest distinct value, or null if it does not exist.
    public static Integer secondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        boolean foundLargest = false;
        boolean foundSecondLargest = false;

        for (int num : arr) {
            if (!foundLargest || num > largest) {
                if (foundLargest) {
                    secondLargest = largest;
                    foundSecondLargest = true;
                }
                largest = num;
                foundLargest = true;
            } else if (num < largest && (!foundSecondLargest || num > secondLargest)) {
                secondLargest = num;
                foundSecondLargest = true;
            }
        }

        return foundSecondLargest ? secondLargest : null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Reads N followed by N integers, whether they appear on one line or many.
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            if (!sc.hasNextInt()) {
                System.out.println("Not Possible");
                sc.close();
                return;
            }
            arr[i] = sc.nextInt();
        }

        Integer answer = secondLargest(arr);
        if (answer == null) {
            System.out.println("Not Possible");
        } else {
            System.out.println(answer);
        }

        sc.close();
    }
}
