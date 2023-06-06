package nl.sogyo.javaopdrachten.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        /*
        System.out.println("Welcome to Hangman! \n" +
                "In this game, you will be guessing a word that has been\n" +
                "randomly picked from a list of words. You will guess a letter, and if it’s\n" +
                "contained in the word, the corresponding letters in the word will be shown. If\n" +
                "it’s not in the word, you will lose a guess. Be careful, as you only have 10\n" +
                "wrong guesses before the computer wins. Good luck!\n\n");
        */


        Scanner keyboard = new Scanner(System.in);

        String word = pickAWord();
        System.out.println(word);

        List<Character> playerGuesses = new ArrayList<>();

        while (true){
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
        for (int i = 0; i < word.length(); i++){
            if (playerGuesses.contains(word.charAt(i))){
                System.out.print(word.charAt(i));
                correctCount++;
            } else {
                System.out.print("-");
            }
        }
        if (!(word.length() == correctCount)){
            System.out.println();
        } else {
            System.out.println("You win!");
        }
    }

    static int playerGuessLeft = 10;
    private static void getPlayerGuessedLetter(Scanner keyboard, String word, List<Character> playerGuess){
        char guessedLetterOfPlayer;
        do {
            System.out.print("\nPlease enter a letter: ");
            String playerInput = keyboard.nextLine().toUpperCase();

            if (playerInput.length() == 1) {
                guessedLetterOfPlayer = playerInput.charAt(0);
                if (Character.isLetter(guessedLetterOfPlayer)) {
                    break;  // Exit the loop if a valid character is entered
                }
            }

            System.out.println("Invalid player Input! Please enter a letter.");
        } while (true);
        //System.out.println("You entered the character: " + guessedLetterOfPlayer);

        int index = word.indexOf(guessedLetterOfPlayer);

        if (index != -1) {
            playerGuess.add(guessedLetterOfPlayer);
            //printWordState(word, playerGuesses);
        } else {
            playerGuessLeft--;
            System.out.println(playerGuessLeft + " guesses left. Missed Letter: " + guessedLetterOfPlayer);
        }

    }

    private static void getPlayerGuessedWord(Scanner keyboard, String word){
        String guessedWordOfPlayer;

        System.out.print("\nPlease enter your guess for the word: ");
        String playerInput = keyboard.nextLine().toUpperCase();

        if (playerInput.equals(word)) {
            System.out.println("You win!");
        } else {
            guessedWordOfPlayer = playerInput;
            playerGuessLeft--;
            System.out.println(playerGuessLeft + " guesses left. Missed Word: " + guessedWordOfPlayer);
        }

        //printWordState(word, playerGuess);
    }

    public static String pickAWord() throws FileNotFoundException {
        Scanner scanWords = new Scanner(new File("C:\\Users\\sogyo\\SogyoWorkspace\\java-opdrachten\\src\\main\\resources\\beginner\\random-words.txt"));

        List<String> words = new ArrayList<>();
        while (scanWords.hasNext()){
            words.add(scanWords.nextLine().toUpperCase());
        }

        Random random = new Random();
        String word = words.get(random.nextInt(words.size()));
        //System.out.println(word);
        return word;
    }

}
