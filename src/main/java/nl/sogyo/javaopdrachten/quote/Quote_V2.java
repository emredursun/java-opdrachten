package nl.sogyo.javaopdrachten.quote;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quote_V2 {
    private static List<QuoteObj> quotes = new ArrayList<>();

    static {
        quotes.add(new QuoteObj("galileo", "eppur si muove"));
        quotes.add(new QuoteObj("archimedes", "eureka!"));
        quotes.add(new QuoteObj("erasmus", "in regione caecorum rex est luscus"));
        quotes.add(new QuoteObj("socrates", "I know nothing except the fact of my ignorance"));
        quotes.add(new QuoteObj("rené descartes", "cogito, ergo sum"));
        quotes.add(new QuoteObj("sir isaac newton", "if I have seen further it is by standing on the shoulders of giants"));
    }

    public static void main(String... args) {
        boolean tryAgain = true;

        while (tryAgain) {
            printDay();
            printQuoteOfDay();
            tryAgain = tryAgain();
        }
    }

    private static class QuoteObj {
        private String author;
        private String quote;

        public QuoteObj(String author, String quote) {
            this.author = author;
            this.quote = quote;
        }

        public String getAuthor() {
            return author;
        }

        public String getQuote() {
            return quote;
        }
    }

    private static void printQuoteOfDay(){
        int dayOfYear = LocalDate.now().getDayOfYear();
        int index = (dayOfYear - 1) % quotes.size();
        QuoteObj selectedQuote = quotes.get(index);

        String quoteText = selectedQuote.getQuote();
        String quoteOwner = selectedQuote.getAuthor();

        String modifiedQuote = Character.toUpperCase(quoteText.charAt(0)) + quoteText.substring(1) + ".";
        modifiedQuote = modifiedQuote.replaceAll("\\.{2,}$", ".");

        String modifiedOwner = quoteOwner.substring(0, 1).toUpperCase() + quoteOwner.substring(1);

        System.out.println("\"" + modifiedQuote + "\"" + " -- " + modifiedOwner);
    }

    private static void printDay(){
        LocalDate today = LocalDate.now();
        System.out.println("Quote for " + today.getDayOfWeek() + " the " + today.getDayOfMonth() + "th of " + today.getMonth() + ":");
    }

    private static boolean tryAgain(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nWould you like to try again? (yes or no): ");
            String response = scanner.next().toLowerCase();
            if (response.equals("yes")) {
                return true;
            } else if (response.equals("no")) {
                System.out.println("\nKeep in progress! Execution stopped...\n");
                return false;
            } else {
                System.out.println("\nInvalid input!!!");
            }
        }
    }
}

