import java.lang.invoke.LambdaConversionException;
import java.time.LocalDate;
import java.time.Month;

class dateTime{
    public static void main(String[] args){
          //1..Practice code
//        LocalDate now = LocalDate.now();
//        System.out.println("Today's date is: "+ now);
//
//        int dayOfMonth = now.getDayOfMonth();
//        Month month = now.getMonth();
//        int year = now.getYear();
//
//        System.out.println("Date: "+dayOfMonth);
//        System.out.println("Month: "+month);
//        System.out.println("Year: "+year);


        // 2..Practice code
//
//        LocalDate now = LocalDate.now();
//
//        LocalDate customDate = LocalDate.of(2026, 12, 13);
//        System.out.println("After set the Date; "+customDate);
//
//        int dayOfMonth = now.getDayOfMonth();
//        int month = now.getMonthValue();
//        int year = now.getYear();
//
//
//        System.out.println("Day: "+ dayOfMonth);
//        System.out.println("Month: "+ month);
//        System.out.println("Year: "+ year);

        // 3..Practice code
        LocalDate now = LocalDate.now();
        System.out.println("Today's date: "+now);

        LocalDate yesterday = now.minusDays(1);
        System.out.println("Yesterday was: "+ yesterday);

        LocalDate pastDate = now.minusMonths(100);
        System.out.println("100 Months before was: "+ pastDate);
    }
}