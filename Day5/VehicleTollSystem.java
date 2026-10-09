import java.util.*;
/*
Problem 2: Vehicle Toll System (Inheritance & Polymorphism)

Challenge Build a simplified toll calculation system using a base class and two subclasses to demonstrate inheritance and method overriding.

Requirements:
        1. Base Class Vehicle: o Field: registrationNumber (String). o Constructor: Accepts registrationNumber. o Method calculateToll(): Returns a base fee of 50.0.
        2. Subclass Car extends Vehicle: o Constructor: Accepts registrationNumber and passes it up using super(...). o Overrides calculateToll(): Cars pay the standard base fee of 50.0 plus an extra passenger fee of 20.0 (total 70.0).
        3. Subclass Truck extends Vehicle: o Field: axles (int). o Constructor: Accepts registrationNumber and axles. o Overrides calculateToll(): Trucks pay a flat rate of 100.0 plus 50.0 per axle.
        4. Main Method: o Use parent references (Vehicle) to store a Car and a Truck. o Call calculateToll() on each and observe dynamic method dispatch at work.


*/


// 1. Base Class
class Vehicle {
    protected String registrationNumber;

    public Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public double calculateToll() {
        return 50.0; // Base toll
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}

// 2. Child Class: Car
class Car extends Vehicle {
    public Car(String registrationNumber) {
        super(registrationNumber); // Calls Vehicle's constructor
    }

    @Override
    public double calculateToll() {
        return 50.0 + 20.0; // Flat toll for cars = 70.0
    }
}

// 3. Child Class: Truck
class Truck extends Vehicle {
    private int axles;

    public Truck(String registrationNumber, int axles) {
        super(registrationNumber);
        this.axles = axles;
    }

    @Override
    public double calculateToll() {
        return 100.0 + (axles * 50.0); // Base + per axle charge
    }
}

// 4. Test Runner
public class VehicleTollSystem {
    public static void main(String[] args) {
        // Polymorphic references: Vehicle type holding child instances
        Vehicle myCar = new Car("MH-04-AB-1234");
        Vehicle myTruck = new Truck("MH-43-XY-9999", 4);

        System.out.println("Vehicle: " + myCar.getRegistrationNumber() +
                " | Toll Due: ₹" + myCar.calculateToll());

        System.out.println("Vehicle: " + myTruck.getRegistrationNumber() +
                " | Toll Due: ₹" + myTruck.calculateToll());
    }
}