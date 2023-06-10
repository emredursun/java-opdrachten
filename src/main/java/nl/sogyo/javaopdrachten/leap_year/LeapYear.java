package nl.sogyo.javaopdrachten.leap_year;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        System.out.println("This Java program prompts the user to enter a year and determines whether it is a leap year or not.\n" +
                "The program uses a while loop to allow the user to try again if desired.\n");

        Scanner scanner = new Scanner(System.in);
        boolean tryAgain = true;
        while (tryAgain) {
            System.out.print("Enter a year: ");
            int year = scanner.nextInt();

            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                System.out.println(year + " is a leap year.");
            } else {
                System.out.println(year + " is not a leap year.");
            }

            System.out.print("Would you like to try again? (yes or no): ");
            String response = scanner.next().toLowerCase();
            if (response.equals("no")) {
                tryAgain = false;
            }
        }
    }
}