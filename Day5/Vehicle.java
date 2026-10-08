import java.util.*;

class Vehicle1{
    String brand;

    void stringEngine(){
        System.out.println(brand + " engine started.");
    }
}

class Bike extends Vehicle1{
    boolean hasCarrier;

    void kickStand(){
        System.out.println("Kickstand put down.");
    }
}

public class Vehicle {
    public static void main(String[] args){
        Bike myBike = new Bike();
        myBike.brand = "Shine";
        myBike.stringEngine();
        myBike.kickStand();
    }
}
