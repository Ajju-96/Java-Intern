/*
Question 1: Shape Area Calculator

Problem Statement:
Create a Java program to calculate the areas of a circle and a rectangle
using inheritance and method overriding.

Requirements:
1. Create an abstract class Shape with:
   - A String field named color.
   - setColor(String color) to set the shape's color.
   - calculateArea() to calculate and return the area.
2. Create Circle, which stores a radius and calculates pi * radius * radius.
3. Create Rectangle, which stores length and width and calculates length * width.
4. In main, read the circle radius, rectangle length, and rectangle width.
5. Use "Orange" for the circle and "Light Blue" for the rectangle.
6. Print each shape's color and area rounded to two decimal places.

Input:
Three numeric values, one per line:
- Circle radius
- Rectangle length
- Rectangle width
*/

import java.util.Scanner;

abstract class Shape {
    String color;

    void setColor(String color) {
        this.color = color;
    }

    abstract double calculateArea();
}

class Circle extends Shape {
    private final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private final double length;
    private final double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }
}

public class ShapeAreaCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double radius = sc.nextDouble();
        double length = sc.nextDouble();
        double width = sc.nextDouble();

        Circle circle = new Circle(radius);
        Rectangle rectangle = new Rectangle(length, width);

        circle.setColor("Orange");
        rectangle.setColor("Light Blue");

        System.out.printf("%s %.2f%n", circle.color, circle.calculateArea());
        System.out.printf("%s %.2f%n", rectangle.color, rectangle.calculateArea());

        sc.close();
    }
}
