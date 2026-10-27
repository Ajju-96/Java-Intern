/*
- LocalDate
- LocalTime
- LocalDateTime
 */

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;
import java.util.Set;

public class dateTime1 {
    public static void main(String[] args){
        // 1..
//        LocalDate now = LocalDate.now();
//        System.out.println(now);
//
//        LocalTime customTime = LocalTime.of(11, 32,45);
//        System.out.println(customTime);
//        LocalTime  par = LocalTime.parse("15:30:45");
//        System.out.println(par);

//        // 2..
//        ZonedDateTime now = ZonedDateTime.now();
//        System.out.println(now);

        // 3..
//        ZonedDateTime now = ZonedDateTime.now();
//
//        Set<String> availableZones = ZoneId.getAvailableZoneIds();
//        availableZones.forEach(System.out::println);

        // 4..  Question

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a time zone (eg: Asia/Tokyo): ");
        String zoneInput = sc.nextLine();

        try{
            // Use ZoneId.of() to parse the input zone string
            ZoneId zone = ZoneId.of(zoneInput);
            
            // Get the current date and time in the specified time zone
            ZonedDateTime currentTime = ZonedDateTime.now(zone);
            System.out.println("Time zone: "+ zone);
            System.out.println("Current date and time: "+ currentTime);

        }catch (java.time.DateTimeException e){
            System.out.println("Invalid time zone! Please enter");
        }

        sc.close();



    }
}
