
import java.util.function.*;
//public class Example4 {
//    public static void main(String[] args){
//        Supplier<String> message = () -> "Welcome to the world";
//        System.out.println(message.get());
//    }
//}

//Check for consumer

public class Example4 {
    public static void main(String[] args){
        Consumer<String> smsNotifier = mobNo -> {
            System.out.println("Sending the OTP to the ph no.: "+ mobNo);
        };
        smsNotifier.accept("+9876543210");
    }
}