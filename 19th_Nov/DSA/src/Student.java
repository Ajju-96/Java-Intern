import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class Student {
    String Name;
    int RollNo;
    int Marks;

    Student(String Name, int RollNo, int Marks){
        this.Name = Name;
        this.RollNo = RollNo;
        this.Marks = Marks;
    }

    void display() {
        System.out.println("Name: " + Name);
        System.out.println("Roll No: " + RollNo);
        System.out.println("Marks: " + Marks);
        System.out.println("------------------");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        boolean a = true;

        while (a) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int num = sc.nextInt();

            switch (num) {
                case 1:
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Roll No: ");
                    int rollNo = sc.nextInt();

                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();

                    Student s = new Student(name, rollNo, marks);
                    students.add(s);

                    System.out.println("Student Added Successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students found!");
                    } else {
                        for (Student s1 : students) {
                            s1.display();
                        }
                    }
                    break;

                case 3:
                    a = false;
                    System.out.println("Program Ended!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        }

        sc.close();


    }
}
