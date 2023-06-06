package nl.sogyo.javaopdrachten.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final String WORDS_FILE_PATH = "D:\\SOGYO\\java-opdrachten\\src\\main\\resources\\beginner\\random-words.txt";
    private static final List<String> wordList;
    private static int playerGuessLeft = 10;

    static {
        wordList = new ArrayList<>();
        try (Scanner scanWords = new Scanner(new File(WORDS_FILE_PATH))) {
            while (scanWords.hasNext()) {
                wordList.add(scanWords.nextLine().toUpperCase());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to load words from file: " + e.getMessage());
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Hangman!\n" +
                "In this game, you will be guessing a word that has been\n" +
                "randomly picked from a list of words. You will guess a letter, and if it’s\n" +
                "contained in the word, the corresponding letters in the word will be shown. If\n" +
                "it’s not in the word, you will lose a guess. Be careful, as you only have 10\n" +
                "wrong guesses before the computer wins. Good luck!\n");

        Scanner keyboard = new Scanner(System.in);

        String word = pickAWord();
        System.out.println(word);

        List<Character> playerGuesses = new ArrayList<>();

        while (true) {
            printWordState(word, playerGuesses);
            getPlayerGuessedLetter(keyboard, word, playerGuesses);
            printWordState(word, playerGuesses);
            getPlayerGuessedWord(keyboard, word);

//            if (printWordState(word, playerGuesses)){
//                System.out.println("\nYou win!");
//                break;
//            }
//
//            System.out.print("\nPlease enter your guess for the word: ");
//            if (keyboard.nextLine().toUpperCase().equals(word)){
//                System.out.println("\nYou win!");
//                break;
//            } else {
//                System.out.println("Nope! Try again.");
//            }
        }
    }

    public static void printWordState(String word, List<Character> playerGuesses) {
        int correctCount = 0;
        for (char c : word.toCharArray()) {
            if (playerGuesses.contains(c)) {
                System.out.print(c);
                correctCount++;
            } else {
                System.out.print("-");
            }
        }
        System.out.println(correctCount == word.length() ? "\nYou win!" : "");
    }

    private static void getPlayerGuessedLetter(Scanner keyboard, String word, List<Character> playerGuess) {
        char guessedLetter;
        while (true) {
            System.out.print("\nPlease enter a letter: ");
            String playerInput = keyboard.nextLine().toUpperCase();

            if (playerInput.length() == 1 && Character.isLetter(playerInput.charAt(0))) {
                guessedLetter = playerInput.charAt(0);
                break; // Exit the loop if a valid character is entered
            }

            System.out.println("Invalid input! Please enter a letter.");
        }

        if (word.indexOf(guessedLetter) != -1) {
            playerGuess.add(guessedLetter);
        } else {
            System.out.println((--playerGuessLeft) + " guesses left. Missed Letter: " + guessedLetter);
        }
    }

    private static void getPlayerGuessedWord(Scanner keyboard, String word) {
        System.out.print("\nPlease enter your guess for the word: ");
        String guessedWord = keyboard.nextLine().toUpperCase();

        if (guessedWord.equals(word)) {
            System.out.println("You win!");
        } else {
            System.out.println((--playerGuessLeft) + " guesses left. Missed Word: " + guessedWord);
        }
    }

    public static String pickAWord() {
        Random random = new Random();
        return wordList.get(random.nextInt(wordList.size()));
    }
}
