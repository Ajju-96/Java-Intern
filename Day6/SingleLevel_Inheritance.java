import java.util.*;

// Parent class (Superclass)
class Device {
    String brand = "Generic Device";

    void powerOn() {
        System.out.println("Device is turning on...");
    }
}

// Child class (Subclass) inheriting from Device
class Smartphone extends Device {
    String model = "Galaxy S24";

    void makeCall() {
        System.out.println("Calling from " + brand + " " + model + "...");
    }
}

public class SingleLevel_Inheritance {
    public static void main(String[] args) {
        // Create an instance of the child class
        Smartphone myPhone = new Smartphone();

        // Access method inherited from Device parent class
        myPhone.powerOn();

        // Access method from Smartphone child class
        myPhone.makeCall();
    }
}