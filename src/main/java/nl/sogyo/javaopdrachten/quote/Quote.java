package nl.sogyo.javaopdrachten.quote;

import java.time.LocalDate;
import java.util.Scanner;

public class Quote {
    String[][] quotes = {
            {"galileo", "eppur si muove"},
            {"archimedes", "eureka!"},
            {"erasmus", "in regione caecorum rex est luscus"},
            {"socrates", "I know nothing except the fact of my ignorance"},
            {"rené descartes", "cogito, ergo sum"},
            {"sir isaac newton", "if I have seen further it is by standing on the shoulders of giants"}
    };

    public static void main(String... args) {
        //TODO
        boolean tryAgain = true;

        while (tryAgain) {
            printDay();
            printQuoteOfDay();
            tryAgain = tryAgain();
        }
    }

    public static boolean tryAgain(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nWould you like to try again? (yes or no): ");
        String response = scanner.next().toLowerCase();
        if (response.equals("yes")) {
            return true;
        } else if (response.equals("no")) {
            System.out.println("\nKeep in progress! Execution stopped...\n");
            return false;
        } else {
            System.out.println("\nInvalid input!!!");
            return tryAgain();
        }
    }

    public static void printQuoteOfDay(){
        Quote quotes = new Quote();
        int dayOfYear = LocalDate.now().getDayOfYear();
        int index = (dayOfYear - 1) % quotes.quotes.length;
        String[] selectedQuote = quotes.quotes[index];

        String quoteText = selectedQuote[1];
        String quoteOwner = selectedQuote[0];

        String modifiedQuote = "\"" + quoteText.substring(0, 1).toUpperCase() + quoteText.substring(1);
        String modifiedOwner = quoteOwner.substring(0, 1).toUpperCase() + quoteOwner.substring(1);

        if (!Character.isLetter(quoteText.charAt(quoteText.length() -1))){
            System.out.println(modifiedQuote + "\" -- " + modifiedOwner);
        } else {
            System.out.println(modifiedQuote + ".\" -- " + modifiedOwner);
        }
    }

    public static void printDay(){
        LocalDate today = LocalDate.now();
        System.out.println("Quote for " + today.getDayOfWeek() + " the " + today.getDayOfMonth() + "th of " + today.getMonth() + ":");
    }
}