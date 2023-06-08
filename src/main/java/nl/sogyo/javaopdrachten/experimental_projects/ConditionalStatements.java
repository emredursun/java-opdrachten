package nl.sogyo.javaopdrachten.experimental_projects;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConditionalStatements {
    public static void main(String[] args) {
        printDayType();
    }

    public static void printDayType() {
        System.out.print("Enter a day name: ");
        Scanner scan = new Scanner(System.in);
        String dayName = scan.nextLine();

        if (!isValidDayName(dayName)) {
            System.out.println("Invalid day name. Try again!");
            printDayType();
            return;
        }

        boolean isWeekdayName = dayName.equalsIgnoreCase("Monday") ||
                dayName.equalsIgnoreCase("Tuesday") ||
                dayName.equalsIgnoreCase("Wednesday") ||
                dayName.equalsIgnoreCase("Thursday") ||
                dayName.equalsIgnoreCase("Friday");
        boolean isWeekendDayName = dayName.equalsIgnoreCase("Saturday") ||
                dayName.equalsIgnoreCase("Sunday");

        if (isWeekdayName) {
            System.out.println(dayName.toUpperCase() + " is a Weekday!");
        }

        if (isWeekendDayName) {
                System.out.println(dayName.toUpperCase() + " is a Weekend Day!");
        }

        tryAgain();
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

    public static void tryAgain(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to try again? (yes or no): ");
        String response = scan.next().toLowerCase();
        if (response.equals("yes")) {
            printDayType();
        } else if (response.equals("no")) {
            System.out.println("Execution stopped!");
        } else {
            System.out.println("Invalid input. Try again!");
            tryAgain();
        }
    }
}