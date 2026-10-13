
/*
public class exceptionExample {
    public static void main(String[] args){
        int balance = 5000;
        int withdrawal = 7000;

        try{
            if(withdrawal > balance){
                throw new IllegalArgumentException(
                        "Insufficient balance"
                );
            }
            balance -= withdrawal;
            System.out.println("Withdrawal was successfull");
            System.out.println("Remaining balance:"  + balance);
        }catch (IllegalArgumentException e ){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("program complete");
        }
    }
}
*/

public class exceptionExample {
    public static void main(String[] args) {
        try {
            System.out.println("Outer try block");
            try {
                int a = 10 / 0; // This causes ArithmeticException
            } catch (ArithmeticException e) {
                System.out.println("Inner catch: " + e);
            }
            String str = null;
            System.out.println(str.length()); // This causes NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Outer catch: " + e);
        }
    }
}