import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class Main 
{
    public static void main(String args[]) 
    {
        Scanner scanner = new Scanner(System.in);
        
        // Read the two date strings from user input
        String startDateStr = scanner.nextLine();
        String endDateStr = scanner.nextLine();
        
        // Define the date format matching "yyyy-MM-dd"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        // Parse the strings into LocalDate objects
        LocalDate startDate = LocalDate.parse(startDateStr, formatter);
        LocalDate endDate = LocalDate.parse(endDateStr, formatter);
        
        // Calculate the absolute difference in days
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        long result = Math.abs(daysBetween);
        
        // Print the output according to formatting specifications
        System.out.println(result + " days");
        
        scanner.close();
    }
}
