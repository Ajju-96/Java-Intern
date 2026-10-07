import java.util.*;

//Question.. 3

class Sum {
    public static void largeNumber(int a, int b){
        if(a>b){
            System.out.println("A is large and it value is: "+ a);
        }else if(a < b){
            System.out.println("b is large and it value is: "+ b);
        }else{
            System.out.println("Both are same");
        }
    }
}

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
		Sum sum1 = new Sum();
	    System.out.print("Enter Number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter Number: ");
        int num2 = sc.nextInt();
        Sum.largeNumber(num1, num2);
	}
	
}