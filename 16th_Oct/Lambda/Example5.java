import java.util.Random;
import java.util.function.*;

public class Example5 {
    public static void main(String[] args){
        Supplier<String> otpGen = () -> {
            Random random = new Random();
            int number = 1000000 + random.nextInt(9000000);
            return String.valueOf(number);
        };

        String userOtp = otpGen.get();
        System.out.println("The OTP is: "+ userOtp);

    }
}
