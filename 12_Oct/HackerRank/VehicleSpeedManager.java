/*
Question 2: Vehicle Speed Manager

Problem Statement:
Create a Car class to manage a vehicle's speed.

Requirements:
- Fields: model (String) and speed (int).
- Constructor initializes the car's model and starting speed.
- start() prints "{model} has started."
- accelerate(int increment) increases speed and prints the updated speed.
- brake(int decrement) decreases speed and prints the updated speed.

Input:
Four lines:
1. Car model (one word)
2. Initial speed
3. Acceleration increment
4. Braking decrement
*/

import java.util.Scanner;

class Car {
    private final String model;
    private int speed;

    Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    void start() {
        System.out.println(model + " has started.");
    }

    void accelerate(int increment) {
        speed += increment;
        System.out.println("Speed after acceleration: " + speed);
    }

    void brake(int decrement) {
        speed -= decrement;
        System.out.println("Speed after braking: " + speed);
    }
}

public class VehicleSpeedManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String model = sc.next();
        int initialSpeed = sc.nextInt();
        int acceleration = sc.nextInt();
        int braking = sc.nextInt();

        Car car = new Car(model, initialSpeed);
        car.start();
        car.accelerate(acceleration);
        car.brake(braking);

        sc.close();
    }
}
