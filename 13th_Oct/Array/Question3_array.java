/*
problem 3:
Reverse an array in-place problem statement reverse the elements of an array without using a second auxiliary array by using the two-pointer approach.
 */


import java.util.Scanner;

public class Question3_array {
    public static void main(String[] args){
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

        int start = 0;
        int end = n-1;

        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        System.out.println("Array after reverse: ");
        for(int i=0; i<n; i++){
            System.out.println(arr[i]);
        }

    }
}
