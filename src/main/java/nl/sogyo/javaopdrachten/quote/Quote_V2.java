package nl.sogyo.javaopdrachten.quote;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quote_V2 {
    static LocalDate currentDate = LocalDate.now();
    private static final List<QuoteObj> quotes = new ArrayList<>();

    static {
        quotes.add(new QuoteObj("galileo", "eppur si muove"));
        quotes.add(new QuoteObj("archimedes", "eureka!"));
        quotes.add(new QuoteObj("erasmus", "in regione caecorum rex est luscus"));
        quotes.add(new QuoteObj("socrates", "I know nothing except the fact of my ignorance"));
        quotes.add(new QuoteObj("rené descartes", "cogito, ergo sum"));
        quotes.add(new QuoteObj("sir isaac newton", "if I have seen further it is by standing on the shoulders of giants"));
    }

    public static void main(String... args) {
        printAuthorsQuotes();
        System.out.println("================================================");
        boolean tryAgain = true;

        while (tryAgain) {
            printDay();
            printQuoteOfDay();
            tryAgain = tryAgain();
        }
    }

    private static void printAuthorsQuotes(){
        StringBuilder sb = new StringBuilder();
        for (QuoteObj quote : quotes) {
            sb.append("Author: ")
                    .append(quote.getAuthorName())
                    .append(" => Quote: ")
                    .append(quote.getQuoteText())
                    .append("\n");
        }
        System.out.println(sb.toString());
    }

    private static class QuoteObj {
        private final String authorName;
        private final String quoteText;

        public QuoteObj(String authorName, String quoteText) {
            this.authorName = authorName;
            this.quoteText = quoteText;
        }

        public String getAuthorName() {
            return authorName;
        }

        public String getQuoteText() {
            return quoteText;
        }
    }

    public static void printDay() {
        String dateString = String.format("\nQuote for %s the %d%s of %s:",
                currentDate.getDayOfWeek(),
                currentDate.getDayOfMonth(),
                getDayOfMonthSuffix(currentDate.getDayOfMonth()),
                currentDate.getMonth()
        );
        System.out.println(dateString);
    }

    private static String getDayOfMonthSuffix(int day) {
        if ((day >= 11 && day <= 13) || (day >= 21 && day <= 23) || (day == 31)) {
            return "th";
        }
        switch (day % 10) {
            case 1:  return "st";
            case 2:  return "nd";
            case 3:  return "rd";
            default: return "th";
        }
    }

    private static void printQuoteOfDay() {
        int dayOfYear = currentDate.getDayOfYear();
        int index = (dayOfYear - 1) % quotes.size();

        QuoteObj selectedQuote = quotes.get(index);
        String quoteText = selectedQuote.getQuoteText();
        String authorName = selectedQuote.getAuthorName();

        char firstChar = Character.toUpperCase(quoteText.charAt(0));
        String modifiedQuote = firstChar + quoteText.substring(1) + ".";
        modifiedQuote = modifiedQuote.replaceAll("\\.{2,}$", ".");

        String modifiedOwner = authorName.substring(0, 1).toUpperCase() + authorName.substring(1);

        String output = String.format("\"%s\" -- %s", modifiedQuote, modifiedOwner);
        System.out.println(output);
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

