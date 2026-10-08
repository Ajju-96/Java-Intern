
import java.util.*;

class BankHandling{
    
    String name;
    int accountNumber;
    double totalBalance;
    
    BankHandling(String name, int accountNumber, double totalBalance){
        this.name = name;
        this.accountNumber = accountNumber;
        this.totalBalance = totalBalance;
        
    }

    void deposit(long amount){
        totalBalance = totalBalance + amount;
        
        System.out.println("₹" + amount + " has been added to your bank account.");
    
        System.out.println("And you account blance is: "+ totalBalance);
    }

    void checkBalance(){
        System.out.println("Your account blance is: "+ totalBalance);
    }
    
    void displayAccountInfo(){
        System.out.println("Account holder name is: "+ name);
        System.out.println("Your account number is: "+ accountNumber);
        System.out.println("And you account blance is: "+ totalBalance);
        
    }
    
    void withdraw(long amount){
        if(amount <= totalBalance){
            totalBalance = totalBalance - amount;
            System.out.println("₹" + amount + " has been withdraw form your bank account.");
            System.out.println("And you account blance is: "+ totalBalance);
        }else{
            System.out.println("Insufficient balance");
        }
    }
}



public class Main {
    public static void main(String[] args){
        BankHandling bank = new BankHandling("Ajay Parbhane", 990565, 950000);
        
        bank.displayAccountInfo();
        
        bank.deposit(5897348);
        bank.checkBalance();
        bank.withdraw(49993);
        bank.displayAccountInfo();
    }

}
