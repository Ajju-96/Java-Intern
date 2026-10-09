
import java.util.*;
//Use of Super keyword

//1. Use of super with Variables
/*
class Employee{
    double salary = 300000;
}

class Manager extends Employee{
    double salary = 60000;

    void displaySalary(){
        System.out.println("Manager salary: "+ salary);
        System.out.println("Manager salary: "+ super.salary);
    }
}


public class SuperKeyword {
    public static void main(String[] args){
        Manager m = new Manager();
        m.displaySalary();
    }
}

*/

/*
//2. Use of super with Methods
class Animal{
    void eat(){
        System.out.println("Animal is eating.");
    }
}

class Dog extends Animal{
    void eat(){
        System.out.println("Dog is eating");
        super.eat();
    }
}

public class SuperKeyword {
    public static void main(String[] args){
        Dog d = new Dog();
        d.eat();
    }
}


 */

//3. Use of super with Constructors

class Person{
    Person(){
        System.out.println("Person class constructor");
    }
}

class Student extends Person{
    Student(){

        super();
        System.out.println("Student class constructor");
    }
}

public class SuperKeyword {
    public static void main(String[] args){
        Student s = new Student();

    }
}