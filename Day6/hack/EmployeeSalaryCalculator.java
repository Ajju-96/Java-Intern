import java.util.Scanner;

class Employee {
    protected String name;
    protected double basicSalary;

    public Employee(String name, double basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public double calculateSalary() {
        return basicSalary + (basicSalary * 0.10); // 10% bonus
    }
}

class Manager extends Employee {
    public Manager(String name, double basicSalary) {
        super(name, basicSalary);
    }

    @Override
    public double calculateSalary() {
        return basicSalary + (basicSalary * 0.20); // 20% bonus
    }
}

public class EmployeeSalaryCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: employee name, employee basic salary, manager name, manager basic salary
        String employeeName = sc.nextLine().trim();
        double employeeBasicSalary = Double.parseDouble(sc.nextLine().trim());
        String managerName = sc.nextLine().trim();
        double managerBasicSalary = Double.parseDouble(sc.nextLine().trim());

        Employee employee = new Employee(employeeName, employeeBasicSalary);
        Employee manager = new Manager(managerName, managerBasicSalary);

        System.out.printf("Employee: %s, Total Salary: %.2f%n",
                employee.name, employee.calculateSalary());
        System.out.printf("Manager: %s, Total Salary: %.2f%n",
                manager.name, manager.calculateSalary());

        sc.close();
    }
}
