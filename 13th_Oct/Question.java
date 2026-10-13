import java.util.Scanner;

//Problem Statement:

//Write a program that takes two integer inputs from the user and calculates their division. If the second number is zero,
// handle the resulting ArithmeticException gracefully and print an error message instead of crashing.

public class Question {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the num1: ");
        int a = sc.nextInt();
        System.out.println("Enter the num2: ");
        int b = sc.nextInt();

        try{
            int value = a/b;
            System.out.println("Result: " + value);
        }catch (ArithmeticException e){
            System.out.println("error is : " + e.getMessage());
        }

    }
}
