import java.util.*;

//Question.. 4

class Sum {
    public void circumference(int a){
        System.out.print("So the circumference is: "+ 2 * 3.14 * a);
    }
}

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
		Sum sum1 = new Sum();
	    System.out.print("Enter the radius: ");
	    int radius = sc.nextInt();
		sum1.circumference(radius);
	}
}