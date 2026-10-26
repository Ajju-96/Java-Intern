// 1..Question

/*Create a Java program called DateExplorer that asks the user
 to enter a date in the format yyyy-MM-dd. The program should
 then display a menu that allows the user to explore different
 details about that date.

For example, the user enters 2026-10-26 and gets the following menu:

Requirements
1. Ask the user to input a date using Scanner.
2. Use LocalDate.parse() to convert the input into a LocalDate object.
3. Use a switch statement to handle the menu options.
4. Use minusMonths() to look back by a number of months specified by the user.
5. Use getMonth(), getYear(), and getDayOfWeek() to display date information.
6. Use an if-else statement to check whether the entered year is a leap year.
7. Use a loop to keep displaying the menu until the user chooses Exit.
8. Create a DateExplorer class with methods such as displayMonth(), displayYear(), and lookBackMonths().

*/


import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class NewUserClass {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LocalDate userDate = null;

        while(userDate == null){
            System.out.println("Enter a date in the format (yyyy-MM-dd)");
            String inputDate = sc.next();
            try{
                userDate = LocalDate.parse(inputDate);
            }catch (DateTimeParseException e){
                System.out.println("Invalid format. Please use the yyyy-MM-dd pattern (e.g., 2026-10-26).\\n");
            }
        }




        int choice = 0;
        do{
            System.out.println("\n--- DateExplorer Menu ---");
            System.out.println("1. Display Month");
            System.out.println("2. Display Year");
            System.out.println("3. Display Day of the Week");
            System.out.println("4. Check if Leap Year");
            System.out.println("5. Look Back by Months");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");


            if(sc.hasNextInt()){
                choice = sc.nextInt();
                System.out.println();


                switch (choice){
                    case 1:
                        displayMonth(userDate);
                        break;
                    case 2:
                        displayYear(userDate);
                        break;
                    case 3:
                        // call getDayOfWeek() directly
                        System.out.println("Day of the week: "+ userDate.getDayOfWeek());
                        break;
                    case 4:
                        // Use and if-else to check for leap year
                        int year = userDate.getYear();
                        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
                            System.out.println(year + " is a leap year");
                        }else{
                            System.out.println(year + " is NOT a leap year.");
                        }
                        break;
                    case 5:
                        // ask user for lookback value
                        System.out.println("Enter how many months to look back; ");
                        if(sc.hasNextInt()){
                            int monthsToSubtract = sc.nextInt();
                            // call lookBackMonths method
                            lookBackMonths(userDate, monthsToSubtract);
                        }else{
                            System.out.println("Invalid input! Please enter a valid number of months.");
                            sc.next();
                        }
                        break;
                    case 6:
                        System.out.println("Exiting DateExplorer. Goodbye!");
                        break;
                    default:
                        System.out.println();
                }
            }else {
                System.out.println(("\nInvalid choice! Please enter a number."));
                sc.next();
            }
        }while (choice != 6);

        sc.close();
    }

    //Method to display month
    public static void displayMonth(LocalDate date){
        System.out.println("Month: "+ date.getMonth());
    }

    //Method to display the year
    public static void displayYear(LocalDate date){
        System.out.println("Year: "+ date.getYear());
    }

    //Method to look back by months
    public static void lookBackMonths(LocalDate date, int months){
        LocalDate pastDate = date.minusMonths(months);
        System.out.println(months + " months ago, the date was: "+ pastDate);
    }



}
