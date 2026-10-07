import java.util.*;

//Question.. 1

class Sum {
    public void printAverage(double a, double b, double c) {
        double average = (a + b + c) / 3;
        System.out.println("The average is: " + average);
    }
}

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
		Sum sum1 = new Sum();
	    System.out.print("Enter three numbers: ");
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        double num3 = sc.nextDouble();
        
        sum1.printAverage(num1, num2, num3);
	}
}