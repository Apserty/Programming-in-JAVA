import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextLine()) {
            // Read both date strings
            String startDateStr = scanner.nextLine().trim();
            String endDateStr = scanner.nextLine().trim();
            
            // Parse strings directly into LocalDate (ISO-8601 format yyyy-mm-dd is supported by default)
            LocalDate startDate = LocalDate.parse(startDateStr);
            LocalDate endDate = LocalDate.parse(endDateStr);
            
            // Calculate the absolute number of complete weeks between the two dates
            long weeks = ChronoUnit.WEEKS.between(startDate, endDate);
            long absoluteWeeks = Math.abs(weeks);
            
            // Print out the formatted result
            System.out.println(absoluteWeeks + " weeks");
        }
        
        scanner.close();
    }
}
