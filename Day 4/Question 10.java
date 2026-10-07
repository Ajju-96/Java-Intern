import java.util.*;

//Question.. 10

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of terms: ");
        int n = sc.nextInt();

        int a = 0;
        int b = 1;

        System.out.println("Fibonacci Series:");

        for(int i = 1; i <= n; i++){
            System.out.print(a + " ");

            int c = a + b;
            a = b;
            b = c;
        }
    }
}