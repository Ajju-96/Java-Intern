import java.util.*;

abstract class paymentGateway{
    void  printReceipt(){
        System.out.println("Receipt generated.");
    }

    abstract void processPayment(double amount);
}

class UPIPayment extends paymentGateway{
    void processPayment(double amount){
        System.out.println("Processing ₹"+ amount + " via UPI QR code.");
    }
}

class CreditCardPayment extends paymentGateway{
    void processPayment(double amount){
        System.out.println("Processing ₹" + amount + " via Card swipe and OTP.");
    }
}

public class PamentGatway {
    public static void main(String[] args){

        paymentGateway UPIpay = new UPIPayment();
        UPIpay.processPayment(575830);
        UPIpay.printReceipt();

    }
}
