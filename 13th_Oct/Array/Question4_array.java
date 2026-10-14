
import java.util.Scanner;

public class Question4_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array:");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Array size must be positive.");
            sc.close();
            return;
        }

        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        boolean foundSecond = false;

        // Find the second-largest distinct element in one traversal
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
                foundSecond = (secondLargest != Integer.MIN_VALUE);
            } else if (arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
                foundSecond = true;
            }
        }

        if (foundSecond) {
            System.out.println("Second largest element: " + secondLargest);
        } else {
            System.out.println("No second largest distinct element found");
        }

        sc.close();
    }
}
