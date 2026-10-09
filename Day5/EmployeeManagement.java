import java.util.*;
/*
Problem 1: Employee Management (Encapsulation & Constructors) 

  Challenge Create an Employee class that models an employee record with proper data protection.   

Requirements: 1. Private Fields: o id (int) o name (String) o salary (double) 
              2. Constructor: o Accepts id, name, and an initial salary. o Ensure salary cannot be negative when setting it initially (if negative, set it to 0.0). 
              3. Methods: o Getters for all fields (getId(), getName(), getSalary()). 
                      o A setter for salary (setSalary(double salary)): Only update if salary >= 0. Otherwise, print an error message. 
                      o giveRaise(double percent): Increases the salary by the given percentage (e.g., 10 means a 10% raise). 
              4. Main Method: o Create an employee with ID 101, name "Alice", and salary 50000.0. 
                      o Apply an 8% raise. o Print the updated salary. 
                      o Try setting a negative salary to test validation.

*/

class Employee{
    private int id;
    private String name;
    private double salary;

    Employee(int id, String name, double salary){
        this.id = id;
        this.name = name;
        if(salary >= 0){
            this.salary = salary;
        }else {
            this.salary = 0.0;
        }
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public double getSalary(){
        return salary;
    }

    public void setSalary(double salary){
        if(salary >=0){
            this.salary = salary;
        }else {
            System.out.println("Error: Salary cannot be negative.");
        }
    }

    public void giveRaise(double percent){
        if(percent > 0){
            double raiseAmount = this.salary * (percent / 100.0);
            this.salary += raiseAmount;
            System.out.println(name  +" received a "+ percent + "% raise.new salary: Rs" + this.salary);
        }else{
            System.out.println("Raise percentage must be positive.");
        }
    }

}


public class EmployeeManagement{
    public static void main(String[] args){
        Employee emp = new Employee(101, "Ajay", 500000.0);

        System.out.println("Initial salary: Rs"+ emp.getSalary());

        emp.giveRaise(8);

        emp.setSalary(-25000);

        System.out.println("Final Verified Salary: Rs"+ emp.getSalary());
    }
}








