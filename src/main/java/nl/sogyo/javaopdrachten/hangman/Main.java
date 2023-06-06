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

        String word = pickAWord();
        System.out.println(word);

        List<Character> playerGuesses = new ArrayList<>();
        printWordState(word, playerGuesses);
        playerGuesses.add(getPlayerGuess());
        printWordState(word, playerGuesses);
    }

    public static void printWordState(String word, List<Character> playerGuesses) {
        for (int i = 0; i < word.length(); i++){
            if (playerGuesses.contains(word.charAt(i))){
                System.out.print(word.charAt(i));
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
    }

    public static char getPlayerGuess(){
        Scanner keyboard = new Scanner(System.in);
        char userInput;

        do {
            System.out.print("Please enter a letter: ");
            String input = keyboard.nextLine().toUpperCase();

            if (input.length() == 1) {
                userInput = input.charAt(0);
                if (Character.isLetter(userInput)) {
                    break;  // Exit the loop if a valid character is entered
                }
            }

            System.out.println("Invalid input! Please enter a letter.");
        } while (true);

        //System.out.println("You entered the character: " + userInput);
        return userInput;
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
