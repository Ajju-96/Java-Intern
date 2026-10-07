import java.util.*;

//Question.. 2

class Sum {
    public void printOdd(int a){
        if(a < 1){
            System.out.println("So the sum of all 1 to n numbers are: 0");
            return;
        }
        long n = (long) (a +1) / 2;
        long sum = n * n;
        System.out.println("So the sum of all 1 to n odd numbers are: "+ sum);
    }
}

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
		Sum sum1 = new Sum();
	    System.out.print("Enter Number: ");
        int odd = sc.nextInt();

        sum1.printOdd(odd);
	}
	
}