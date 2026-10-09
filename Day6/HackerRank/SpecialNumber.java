import java.util.Scanner;

public class SpecialNumber {
    public static boolean isSpecialNumber(int n) {
        int original = n;
        int sum = 0;

        // Factorials for digits 0 through 9; 0! and 1! are both 1.
        int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

        while (n > 0) {
            int digit = n % 10;       // Get the last digit.
            sum += factorial[digit];  // Add that digit's factorial.
            n /= 10;                  // Remove the last digit.
        }

        return sum == original;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (isSpecialNumber(n)) {
            System.out.println("Special Number");
        } else {
            System.out.println("Not a Special Number");
        }

        sc.close();
    }
}
