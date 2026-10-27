/*
Problem statement - 2
Create a Java console application called MeetingTimeAssistant
 that allows a user to enter a meeting's date and time,
 calculate when it will end, and display the meeting time
  in a different time zone.

========== MEETING TIME ASSISTANT ==========

Enter meeting date (yyyy-MM-dd): 2026-11-10
Enter meeting time (HH:mm): 14:30
Enter meeting duration in minutes: 90

Choose an option:
1. Display meeting date and time
2. Display meeting end time
3. Display meeting time in another zone
4. Check whether the meeting is in the future
5. Exit

Enter choice: 2

Meeting starts at: 10 Nov 2026, 02:30 PM
Meeting ends at:   10 Nov 2026, 04:00 PM
 */


import java.lang.invoke.LambdaConversionException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MeetingTimeAssistant {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    // Formatters for parsing and output
        DateTimeFormatter inputDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter inputTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a");

        System.out.println("=================Meeting Time Assistant===================");
        System.out.println();

        LocalDate date = null;
        LocalTime time = null;
        int durationMinutes = 0;

        //Input Meeting Date
        while(date == null){
            System.out.println("Enter meeting date (yyyy-MM-dd): ");
            String dateStr = sc.nextLine().trim();
            try{
                date = LocalDate.parse(dateStr, inputDateFormatter);
            }catch (DateTimeParseException e){
                System.out.println("Invalid date format. Please try again: ");
            }
        }

        // Input Meeting time
        while(time == null){
            System.out.println("Enter meeting time (HH:mm): ");
            String timeStr = sc.nextLine().trim();

            try{
                time = LocalTime.parse(timeStr, inputTimeFormatter);
            }catch (DateTimeParseException e){
                System.out.println("Invalid time format, Please try again.");
            }
        }
        LocalDateTime startDateTime = LocalDateTime.of(date, time);
        LocalDateTime endDateTime = startDateTime.plusMinutes(durationMinutes);

        // Menu Loop
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Display meeting date and time");
            System.out.println("2. Display meeting end time");
            System.out.println("3. Display meeting time in another zone");
            System.out.println("4. Check whether the meeting is in the future");
            System.out.println("5. Exit");
            System.out.print("\nEnter choice: ");

            String choiceInput = sc.nextLine().trim();
            System.out.println();

            switch (choiceInput) {
                case "1":
                    System.out.println("Meeting starts at: " + startDateTime.format(displayFormatter));
                    break;

                case "2":
                    System.out.println("Meeting starts at: " + startDateTime.format(displayFormatter));
                    System.out.println("Meeting ends at:   " + endDateTime.format(displayFormatter));
                    break;

                case "3":
                    System.out.print("Enter target zone ID (e.g., UTC, Asia/Tokyo, America/New_York): ");
                    String zoneInput = sc.nextLine().trim();
                    try {
                        ZoneId targetZone = ZoneId.of(zoneInput);
                        ZoneId defaultZone = ZoneId.systemDefault();

                        ZonedDateTime localZdt = startDateTime.atZone(defaultZone);
                        ZonedDateTime targetZdt = localZdt.withZoneSameInstant(targetZone);

                        System.out.println("Local meeting time (" + defaultZone.getId() + "): "
                                + localZdt.format(displayFormatter));
                        System.out.println("Converted meeting time (" + targetZone.getId() + "): "
                                + targetZdt.format(displayFormatter));
                    } catch (Exception e) {
                        System.out.println("Invalid Zone ID. Example valid zone IDs: America/New_York, UTC, Asia/Kolkata, Europe/London.");
                    }
                    break;

                case "4":
                    LocalDateTime now = LocalDateTime.now();
                    if (startDateTime.isAfter(now)) {
                        System.out.println("The meeting is scheduled in the future.");
                    } else if (startDateTime.isBefore(now)) {
                        System.out.println("The meeting is in the past.");
                    } else {
                        System.out.println("The meeting is starting right now.");
                    }
                    break;

                case "5":
                    System.out.println("Exiting Meeting Time Assistant. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }

        }
    }
}
