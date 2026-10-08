import java.util.*;
/*
Problem 2: The Academy Admissions Portal.
A coding academy is building an automated student profile manager for its batch admissions..

When a student enrolls, their profile must track their full name, student ID, and their final exam score. However, applicants join under two different scenarios: • Exam Takers: Students who took an entrance evaluation prior to joining provide their name, ID, and their actual score on day one. • Direct Walk-ins: Beginners who haven't taken the entrance test yet register with only their name and ID; their initial score must automatically start at 0.0.

The portal also needs an automated grading engine. When a report card is generated, it should evaluate the student's score and assign a letter grade based on academy criteria:
• A for 90 or above
• B for scores from 75 up to 89
• C for scores from 50 up to 74
• F for anything below 50

Your Task:
• Design the StudentProfile class using two separate constructors to support both types of enrollments.
• Include a behavior to determine the letter grade and another to print the complete report card (name, ID, score, and grade).
• In main, register one student with a score of 82.5 and another walk-in student with no initial score, then print out both report cards.

*/



class StudentProfile{
    String fullName;
    int studentId;
    double score;
    
    StudentProfile(String fullName, int studentId, double score){
        this.fullName = fullName;
        this.studentId = studentId;
        this.score = score;
    }
    
    StudentProfile(String fullName, int studentId){
        this.fullName = fullName;
        this.studentId = studentId;
        this.score = 0.0;
    }
    
    char getGrade(){
        if(score >= 90){
            return 'A';
        } else if (score >= 75) {
            return 'B';
        } else if (score >= 50) {
            return 'C';
        }else {
            return 'F';
        }
    }

    void printReportCard(){
        System.out.println("Name: "+ fullName);
        System.out.println("Student ID: "+ studentId);
        System.out.println("Score: "+ score);
        System.out.println("Grade: "+ getGrade());
        System.out.println("-------------------------");
    }
}

public class AdmissionPortal {
    public  static void main(String[] args){

        StudentProfile student1 = new StudentProfile("Ajay", 101, 84);
        StudentProfile student2 = new StudentProfile("Mayur", 102);

        student1.printReportCard();
        student2.printReportCard();
    }
}
