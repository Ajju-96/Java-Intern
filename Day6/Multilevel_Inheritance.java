import java.util.*;

// Multi-Level Inheritance
// Base Class (Parent)
class Device1 {
    void powerOn() {
        System.out.println("Device powered ON");
    }
}

// Intermediate Class (Child of Device, Parent of Smartphone)
class DabbaPhone extends Device1 {
    void makeCall() {
        System.out.println("Calling the Number......");
    }
}

// Derived Class (Child of DabbaPhone)
class Smartphone1 extends DabbaPhone {
    void browseInternet() {
        System.out.println("Browsing the web on 5G...");
    }
}

public class MultipleInheritance {
    public static void main(String[] args) {
        // Create an instance of the bottom-most child class
        Smartphone1 samsung = new Smartphone1();

        // Inherited from top-level parent (Device)
        samsung.powerOn();

        // Inherited from intermediate parent (DabbaPhone)
        samsung.makeCall();

        // Specific to Smartphone
        samsung.browseInternet();
    }
}