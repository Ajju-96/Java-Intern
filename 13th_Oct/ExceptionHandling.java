
// ArithmeticException

public class ExceptionHandling {
    public static void main(String[] args){
        int a = 10;
        int b = 0;

        try{
            int result = a/b;
            System.out.println(result);
        }catch(ArithmeticException e){
            System.out.println("You cannot divide by 0.");
        }


    }
}
/*
ArithmeticException
Trying to divide an integer by zero.
10 / 0
- NullpointerException
Trying to access a method or field through a null reference.
String name null;
• calling an instance method on a null object (e.g., str.length() when str
is null).
• Accessing or modifying a field of a null object (e.g., user.nane) .
• Taking the length of a null array or accessing its slots.
- ArrayIndexOutOfBoundsException
Accessing an array index that doesn't exist.
int[] nums = {1, 2}; then nums[5]

*/