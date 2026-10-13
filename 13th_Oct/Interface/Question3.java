/*
Problem 3:
 Filter odd numbers from an ArrayList Task: Create an ArrayList<Integer> with mixed numbers, remove all odd numbers, and print the remaining list. Key concept: Autoboxing, unboxing, and collections requiring wrapper types instead of primitives. Key concept: Integer cache between -128 and 127. */

import java.util.ArrayList;

public class Question3 {
    public static void main(String[] args){
        ArrayList<Integer> number = new ArrayList<>();

        // Autoboxing: int values are converted to Integer objects
        number.add(10);
        number.add(15);
        number.add(20);
        number.add(25);
        number.add(30);
        number.add(35);

        System.out.println("Original list: "+ number);

        //Remove all odd numbers
        number.removeIf(num -> num%2 != 0);

        System.out.println("List after removeing odd numbers: "+ number);



    }
}
