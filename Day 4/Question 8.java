import java.util.*;

//Question.. 8
class Sum{
    public static double power(double x, long n) {
            if (n == 0) return 1.0;
            if (n < 0) {
                return 1.0 / power(x, -n);
            }
        double half = power(x, n / 2);
            if (n % 2 == 0) {
                return half * half;
            } else {
                return x * half * half;
            }
        }
        
}



public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number to find the value of one number raised to the power of anouther");
		System.out.println("Enter the value of x: ");
		double x = sc.nextDouble();
		System.out.println("Enter the value of x: ");
		long n = sc.nextLong();
		
		//First way (easy way but try to avoid while solving DSA)
		
// 		System.out.println("So the answer is: "+ Math.pow(x,n));

        Sum sum1 = new Sum();
        System.out.println("So the answer is: "+ sum1.power(x, n));
		
	    
	    
	}
	
}