package nl.sogyo.javaopdrachten.hangman;

import java.util.Scanner;

public class GetUserInput {
    public GetUserInput() {
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
