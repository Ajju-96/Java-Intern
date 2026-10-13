/*
Problem 1: Parse and sum a comma-separated string Task: Given a string of numbers separated by commas, extract each number and calculate the total sum. Key concept: Integer.parseInt() or Integer.valueOf().
*/
public class Question1 {
    public static void main(String[] args){
        String numbers = "2,4,6,7,9";
        String[] arr = numbers.split(",");
        int sum = 0;

        for(String num : arr){
            sum += Integer.parseInt(num);
        }
        System.out.println("Sum = " + sum);

    }
}
