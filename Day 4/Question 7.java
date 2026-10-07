import java.util.*;

//Question.. 7

class Sum {
}

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
		Sum sum1 = new Sum();
		
		int positive = 0;
		int negative = 0;
		int zero = 0;
		
		char choice;
		do{
		    System.out.println("Enter the number: ");
		    int a = sc.nextInt();
		    
		    if(a > 0 ){
		        positive++;
		    }else if(a < 0){
		        negative++;
		    }else{
		        zero++;
		    } 
		    System.out.print("Do you want to take number (y/n)");
		    choice = sc.next().charAt(0);
		    
		  }while(choice == 'y' || choice == 'Y' );
		  
		  System.out.println("Positive numbers are: "+positive);
		  System.out.println("Negative numbers are: "+negative);
		  System.out.println("Zero numbers are: "+zero);
		
	    
	    
	}
	
}