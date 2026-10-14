
/*
Problem 1: Count Vowels and Consonants

Problem Statement:
Take a string as input from the user and count the total
number of vowels and consonants present in it.

Ignore spaces and non-alphabet characters.

Concepts Used:
1. Scanner for user input
2. String methods
3. for loop
4. if-else conditions
5. Character checking
*/

import java.util.Scanner;

public class Question1_vowels {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter a string: ");
        String str = sc.nextLine().toLowerCase();

        int vowels = 0;
        int consonants = 0;

        // Traverse each character of the string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Check whether the character is an alphabet
            if (ch >= 'a' && ch <= 'z') {

                // Check whether the character is a vowel
                if (ch == 'a' || ch == 'e' ||
                        ch == 'i' || ch == 'o' ||
                        ch == 'u') {

                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        // Display the results
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);

        sc.close();
    }
}
