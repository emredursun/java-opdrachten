package nl.sogyo.javaopdrachten.hangman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Hangman! \n" +
                "In this game, you will be guessing a word that has been\n" +
                "randomly picked from a list of words. You will guess a letter, and if it’s\n" +
                "contained in the word, the corresponding letters in the word will be shown. If\n" +
                "it’s not in the word, you will lose a guess. Be careful, as you only have 10\n" +
                "wrong guesses before the computer wins. Good luck!");

        Scanner scanner = new Scanner(System.in);
        char userInput;

        do {
            System.out.print("Please enter a letter: ");
            String input = scanner.nextLine().toUpperCase();

            if (input.length() == 1) {
                userInput = input.charAt(0);
                if (Character.isLetter(userInput)) {
                    break;  // Exit the loop if a valid character is entered
                }
            }

            System.out.println("Invalid input! Please enter a letter.");
        } while (true);

        System.out.println("You entered the character: " + userInput);

    }
}
