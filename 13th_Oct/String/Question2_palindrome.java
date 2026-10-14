
/*
Problem 2: Check Whether a String Is a Palindrome

Problem Statement:
Take a string as input and determine whether it reads
the same backward as forward using the two-pointer technique.

Concepts Used:
1. Scanner for user input
2. String methods
3. Two-pointer technique
4. while loop
5. Boolean variable
*/

import java.util.Scanner;

public class Question2_palindrome {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // Initialize two pointers
        int left = 0;
        int right = str.length() - 1;

        boolean isPalindrome = true;

        // Compare characters from both ends
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                isPalindrome = false;
                break;
            }

            left++;
            right--;
        }

        // Display the result
        if (isPalindrome) {
            System.out.println("The string is a palindrome");
        } else {
            System.out.println("The string is not a palindrome");
        }

        sc.close();
    }
}
