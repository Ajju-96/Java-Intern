import java.util.*;

//Question.. 6

class Sum {
    public static void InfiniteLoop(){
        do{
            System.out.println("Running");
        }while(true);
        
    }
}

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
		Sum sum1 = new Sum();
		
		sum1.InfiniteLoop();
	    
	    
	}
	
}