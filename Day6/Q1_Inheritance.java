/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.


Practice question: Employee and Manager 🧑‍💻
Problem statement
Create a Java program with a parent class Employee and a child class Manager.
1. Parent class: Employee
- Variables: String name and double salary.
- Create a constructor that initializes both variables.
- Create a method displayDetails() that prints the employee's name and salary.
2. Child class: Manager
- Inherit from Employee.
- Add a variable String department.
- Create a constructor that accepts name, salary, and department.
- Use super() to initialize the parent's variables.
- Override displayDetails() to display the employee details, department, and the message "Role: Manager".
- Use super.displayDetails() instead of printing the name and salary again.
3. Main class
Create a Manager object with these values:
- Name: "Anish"
- Salary: 50000
- Department: "IT"
Call displayDetails().

*******************************************************************************/

class Employee {
    String name;
    double salary;
    
    Employee(String name, double salary){
        
        
    }
    
    void displayDetails(){
        System.out.println("Name of the employee: "+name);
        System.out.println("Salary is: "+Salary);
    }
}

class Manager extends Employee{
    String department;
    
    Manager(String name, double salary, String department){
        super("Ajay", 10000000);
    }
    
    void displayDetails(){
        System.out.println(department);
        System.out.println("Role: Manager");
        super.displayDetails();
        
    }
    
}

public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello Master");
		Manager m = new Manager ("Anish", 500000, "IT");
		m.displayDetails();
	}
}