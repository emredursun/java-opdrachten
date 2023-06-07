package nl.sogyo.javaopdrachten.experimental_projects;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IfStatement {
    public static void main(String[] args) {
        printDayType();
    }

    public static void printDayType() {
        System.out.println("Enter a day name...");
        Scanner scan = new Scanner(System.in);
        String dayName = scan.nextLine();

        if (!isValidDayName(dayName)) {
            System.out.println("Invalid day name. Please enter a valid day name.");
            printDayType();
            return;
        }

        boolean isWeekdayName = dayName.equalsIgnoreCase("Monday") ||
                dayName.equalsIgnoreCase("Tuesday") ||
                dayName.equalsIgnoreCase("Wednesday") ||
                dayName.equalsIgnoreCase("Thursday") ||
                dayName.equalsIgnoreCase("Friday");

        if (isWeekdayName) {
            System.out.println("Weekday");
        } else {
            boolean isWeekendDayName = dayName.equalsIgnoreCase("Saturday") ||
                    dayName.equalsIgnoreCase("Sunday");
            if (isWeekendDayName) {
                System.out.println("Weekend Day");
            }
        }

        System.out.println("Would you like to try again? (yes or no): ");
        String response = scan.next().toLowerCase();
        if (response.equals("yes")) {
            printDayType();
        }
    }

    public static boolean isValidDayName(String dayName) {
        List<String> validDayNames = Arrays.asList(
                "monday",
                "tuesday",
                "wednesday",
                "thursday",
                "friday",
                "saturday",
                "sunday"
        );
        return validDayNames.contains(dayName.toLowerCase());
    }
}
