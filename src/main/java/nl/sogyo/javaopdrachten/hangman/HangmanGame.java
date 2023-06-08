package nl.sogyo.javaopdrachten.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HangmanGame {
    private static final String WORDS_FILE_PATH = "src/main/resources/beginner/random-words.txt";
    private static int MAX_WRONG_GUESSES = 10;
    private static final Scanner keyboard = new Scanner(System.in);
    private static final Random random = new Random();

    private static final List<String> wordList;
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


        String word = getRandomWord();
        System.out.println(word);
        List<Character> guessedLetters = new ArrayList<>();

        while (true) {
            printWordState(word, guessedLetters);
            char guessedLetter = getGuessedLetter();
            guessedLetters.add(guessedLetter);

            if (word.indexOf(guessedLetter) != -1) {
                //System.out.println((MAX_GUESSES - guessedLetters.size()) + " guesses left.");
                if (hasWon(word, guessedLetters)) {
                    System.out.println("You win!");
                    break;
                }
            } else {
                --MAX_WRONG_GUESSES;
                System.out.println(MAX_WRONG_GUESSES + " guesses left. Missed Letter: " + guessedLetter);
                if (MAX_WRONG_GUESSES == 0) {
                    System.out.println("You lose! The word was " + word + ".");
                    break;
                }
            }
        }
    }

    public static void printWordState(String word, List<Character> guessedLetters) {
        for (char c : word.toCharArray()) {
            if (guessedLetters.contains(c)) {
                System.out.print(c);
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
    }

    private static char getGuessedLetter() {
        while (true) {
            System.out.print("");
            String playerInput = keyboard.nextLine().toUpperCase();

            if (playerInput.length() == 1 && Character.isLetter(playerInput.charAt(0))) {
                return playerInput.charAt(0);
            }

            System.out.println("Invalid input! Please enter a letter.");
        }
    }

    private static boolean hasWon(String word, List<Character> guessedLetters) {
        for (char c : word.toCharArray()) {
            if (!guessedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }

    private static String getRandomWord() {
        return wordList.get(random.nextInt(wordList.size()));
    }
}

