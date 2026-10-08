import java.util.*;

class Bankaccout1{
    private String accountHolderName;
    private double balance;

    public Bankaccout1(String accountHolderName, double balance){
        this.accountHolderName = accountHolderName;
        setBalance(balance);
    }

    public double getBalance(){
        return this.balance;
    }

    public void setBalance(double amount){
        if(amount >= 0){
            this.balance = amount;
        }else {
            System.out.println("Invalid balance: cannot be negative!");
        }
    }
}

public class BankAccout {
    public static void main(String[] args){
        Bankaccout1 acc = new Bankaccout1("AJAY PARBHAEN", 9000);

        acc.setBalance(-900);
        System.out.println(acc.getBalance());


    }
}
