/*
* problem 1: sum and average of array elements
* problem statement :
*           take n integers as input from the user, store them in an array, and             find the sum and average of all the elements.
 * */


import javax.xml.transform.Source;
import java.util.*;

public class Question1_array {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter "+ n + " elements: ");
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
        }

        double average = (double) sum/n;

        System.out.println("Sum: "+ sum);
        System.out.println("Average: "+ average);

    }
}
