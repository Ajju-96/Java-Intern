import java.util.*;
/*
Problem 1: The Campus Coffee Cart Wallet

A local campus coffee shop wants to eliminate physical punch cards and implement a digital prepaid wallet system for students.

When a student signs up, the system must set up their wallet with their name and an initial opening deposit.

Throughout the week, students perform transactions:

        1. They can add funds to their wallet at any time, which should immediately reflect in their total balance.
        2. When making a purchase, the system checks whether the wallet has enough funds. If it does, the amount is deducted and the new balance is shown. However, if a student tries to buy a latte that costs more than what is left in their wallet, the transaction must be blocked with an "Insufficient funds!" notice, leaving the balance untouched.
        3. At any point, a student can request a quick account overview showing their name and current balance.

Your Task: • Design the CoffeeWallet class to track a customer's wallet. • In your program's runner (main), simulate a customer opening an account with ₹500, topping up with ₹200, successfully buying a ₹150 snack, and finally attempting an invalid purchase of ₹800.
*/

class CoffeeWallet{
    String name;
    int balance;

    CoffeeWallet(String name, int balance){
        this.name = name;
        this.balance = balance;
        System.out.println("For opening account you have to make the initial payment of Rs500.");
    }

    //check balance
    void checkBalance(){
        System.out.println("Total Balance: "+ balance);
    }

    //Add funds
    void addFund(int amount){
        balance += amount;

        System.out.println("Rs." + amount + " added successfully.");
        System.out.println("Total Balance: Rs." + balance);
    }

    //Purchase
    void purchase(int purchaseAmount){
        if( purchaseAmount <= balance){
            balance -= purchaseAmount;
            System.out.println("Purchase successful");
            System.out.println("Amount deducted: Rs."+purchaseAmount);
            System.out.println("Total Balance: "+ balance);
        }else {
            System.out.println("Invalid Purchase");
        }
    }

    void quickAccOverview(){
        System.out.println("Account overview");
        System.out.println("Account holder name: "+ name);
        System.out.println("Your account total balance was: "+ balance);
    }

}
public class Wallet {
    public static void main(String[] args){

        //Oper account with Rs.500
        CoffeeWallet cf = new CoffeeWallet("AjayParbhane", 500);

        //Add Rs.200
        cf.addFund(200);

        //Buy Rs.150 snack
        cf.purchase(150);

        //try to buy Rs.800 item
        cf.purchase(800);

        //Quick Account Overview
        cf.quickAccOverview();


    }
}
