import java.util.*;

//Question.. 9

public class Main
{
    public static int gcd(int a, int b){
        int gcd = 1;
        
        for(int i=0; i <= a && i <= b; i++){
            if(a == 0){
                gcd = b;
            }else if(b == 0){
                gcd = a;
            }
            else if(a%i == 0 && b%i == 0){
                gcd = i;
            }
        }
        return gcd;
    }
    
    
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the value of a: ");
		int a = sc.nextInt();
		System.out.println("Enter the value of b: ");
		int b = sc.nextInt();
		
		int result = gcd(a, b);
		System.out.println("GCD of " + a + " and " + b + " is: " + result);
	    
	    
	}
	
}