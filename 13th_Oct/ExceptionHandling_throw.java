
import java.util.Scanner;

public class ExceptionHandling_throw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        if (age < 0) {
            throw new IllegalArgumentException(
                    "Age cannot be negative"
            );
        }

        System.out.println("Age: " + age);

        sc.close();
    }
}

/*
Exception Handling concepts:
1. try-catch
2. finally
3. throw
4. throws
*/
