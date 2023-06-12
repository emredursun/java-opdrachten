package nl.sogyo.javaopdrachten.quote;

import java.time.LocalDate;

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
        LocalDate today = LocalDate.now();
        String dayOfWeek = String.valueOf(today.getDayOfWeek());
        int dayOfMonth = today.getDayOfMonth();
        String monthOfYear = String.valueOf(today.getMonth());
        int dayOfYear = today.getDayOfYear();

        printDay(dayOfWeek, dayOfMonth, monthOfYear);
        printQuoteOfDay(dayOfYear);
    }

    public static void printQuoteOfDay(int dayOfYear){
        Quote quotes = new Quote();
        int index = (dayOfYear - 1) % quotes.quotes.length;
        String[] selectedQuote = quotes.quotes[index];

        String quoteText = selectedQuote[1];
        String quoteOwner = capitalize(selectedQuote[0]);



        String modifiedQuote = "\"" + quoteText.substring(0, 1).toUpperCase() + quoteText.substring(1);
        String modifiedOwner = quoteOwner.substring(0, 1).toUpperCase() + quoteOwner.substring(1);

        if (!Character.isLetter(quoteText.charAt(quoteText.length() -1))){
            System.out.println(modifiedQuote + "\" -- " + modifiedOwner);
        } else {
            System.out.println(modifiedQuote + ".\" -- " + modifiedOwner);
        }
    }

    public static String capitalize(String author) {
        String[] words = author.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {  // Skip empty words
                String capitalizedWord = Character.toUpperCase(word.charAt(0)) + word.substring(1);
                result.append(capitalizedWord).append(" ");
            }
        }

        return result.toString().trim();  // Trim leading/trailing spaces
    }

    private static void printDay(String dayOfWeek, int dayOfMonth, String monthOfYear){
        String formattedString = String.format("\nQuote for %s the %d%s of %s:", dayOfWeek, dayOfMonth, printSuffix(dayOfMonth), monthOfYear);
        System.out.println(formattedString);
    }


    private static String printSuffix(int dayOfMonth){
        String suffix;
        switch (dayOfMonth){
            case 1:
                suffix = "st";
                break;
            case 2:
                suffix = "nd";
                break;
            case 3:
                suffix = "rd";
                break;
            default:
                suffix = "th";
        }
        return suffix;
    }
}