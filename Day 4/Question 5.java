import java.util.*;

//Question.. 5

class Sum {
    public static void voteEligibility(int a){
        if(a >= 18){
            System.out.println("You are eligible to vote");
        }else{
            System.out.println("You are not eligible to vote");
        }
        
    }
}

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
		Sum sum1 = new Sum();
		System.out.println("Enter your age: ");
		int age = sc.nextInt();
		sum1.voteEligibility(age);
	    
	    
	}
	
}