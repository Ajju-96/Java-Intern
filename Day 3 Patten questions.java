import java.util.*;

public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello Master");
		Scanner sc = new Scanner(System.in);
		
		
// 		System.out.print("enter the number:");
// 		int num = sc.nextInt();
		
		//1..question
// 		for(int i=0; i<num; i++){
// 		    for(int j=0; j<num; j++){
// 		        System.out.print("*");
// 		    }
// 		    System.out.println();
// 		}
        //Output
        // *****
        // *****
        // *****
        // *****
        // *****
		
		//2..question
// 		for(int i=1; i<=num; i++){
// 		    for(int j=1; j<=i;j++){
// 		        System.out.print("*");
// 		    }
// 		    System.out.println();
// 		}
        //Output
        // *
        // **
        // ***
        // ****
        // *****
		
		//3..question
// 		for(int i=1; i<=num;i++){
// 		    for(int j=1; j<=num; j++){
// 		        if(i==1 || i==num || j==1 || j==num){
// 		            System.out.print("*");
// 		        }else{
// 		            System.out.print(" ");
// 		        }
// 		    }
// 		    System.out.println();
// 		}
		//Output 
		// *****
		// *   *
		// *   * 
		// *   *
		// *****
		
		//4..question
// 		for(int i=1; i<=num; i++){
// 		    for(int j=num; j>=i;j--){
// 		        System.out.print("*");
// 		    }
// 		    System.out.println();
// 		}
		//Output
		// *****
		// ****
		// ***
		// **
		// *

		//5..question
// 		for (int i = 1; i <= num; i++) {
//             for (int h = 1; h <= num - i; h++) {
//                 System.out.print("-");
//             }
//             for (int s = 1; s <= i; s++) {
//                     System.out.print("*");
//             }
//     		    System.out.println();
// 		}
		//Output
// 		----*
// 		---**
// 		--***
// 		-****
// 		*****

        //6..question
        // for(int i = 1; i <= num; i++){
        //     for(int j = 1; j <= num; j++){
        //         System.out.print("*");
        //     }
        //     for(int k = 1; k <= num; k++){
        //         System.out.print("-");
        //     }
        //     System.out.println();
        // }
        
        //Output
        // *****
        // -****
        // --***
        // ---**
        // ----*
		
		//7..question
//         for(int i=1; i<=num; i++){
// 		    for(int j=1; j<=i;j++){
// 		        System.out.print(j);
// 		    }
// 		    System.out.println();
// 		}
		//Output
// 		1
// 		12
// 		123
// 		1234
// 		12345

        //8..question
//         for(int i=1; i<=num; i++){
//             int k = 1;
// 		    for(int j=num; j>=i;j--){
// 		        System.out.print(k);
// 		        k++;
// 		    }
// 		    System.out.println();
// 		}
		//Output
// 		12345
// 		1234
// 		123
// 		12
// 		1
        
        //9..question
//         int k = 1;
//         for(int i=1; i<=num; i++){
// 		    for(int j=1; j<=i;j++){
// 		        System.out.print(k);
// 		        k++;
// 		    }
// 		    System.out.println();
// 		}
		//Output
// 		1
// 		23
// 		456
// 		78910
// 		1112131415

        //10..question
//         int k = 0;
//         for(int i=1; i<=num; i++){
// 		    for(int j=1; j<=i;j++){
// 		        if(k%2 == 0){
// 		            System.out.print("1");
// 		        }else{
// 		            System.out.print("0");
// 		        }
// 		        k++;
// 		    }
// 		    System.out.println();
// 		}
		//Output
// 		1 
// 		01 
// 		101 
// 		0101 
// 		10101
		
		//11..question
		System.out.println("Enter the chooice: 1)triangle, 2)Squre, 3)Rectangel");
		int num1 = sc.nextInt();
		
		switch(num1){
		    case 1:
		        System.out.println("needed filds like..");
		        System.out.print("Enter the breath: ");
		        int b = sc.nextInt();
		        System.out.print("Enter the hight: ");
		        int h = sc.nextInt();
		        System.out.print("So the area of triangle is: "+ 0.5*b*h);
		        break;
		        
		    case 2:
		        System.out.println("needed filds like..");
		        System.out.print("Enter the side: ");
		        int s = sc.nextInt();
		        System.out.print("So the area of Squre is: "+ (s*s));
		        break;
		        
		    case 3:
		        System.out.println("needed filds like..");
		        System.out.print("Enter the width: ");
		        int w = sc.nextInt();
		        System.out.print("Enter the length: ");
		        int l = sc.nextInt();
		        System.out.print("So the area of triangle is: "+ (w*l));
		        
		    default:
                System.out.println("Invalid choice!");
                break;
		    
		    
		}
		
		
		
	}
}