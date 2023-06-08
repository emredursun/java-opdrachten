package nl.sogyo.javaopdrachten.experimental_projects;

import java.util.Scanner;

public class NestedIfStatement01 {

    /*
    Ask user to enter a password

    If the initial of the password is uppercase then check if it is ‘A’ or not.
    If it is ‘A’ the output will be “Valid Password”
    otherwise the output will be “Invalid Password”
    For example; Ali ==> Valid password    -     ali ==> Invalid    -    Mark ==> Invalid

    If the initial of the password is lowercase then check if it is ‘z’ or not.
    If it is ‘z’ the output will be “Valid Password”
    otherwise the output will be “Invalid Password”
    For example; zoe ==> Valid password    -     Zoe ==> Invalid    -    john ==> Invalid
    */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String pwd = scan.nextLine();

        // Best Way:
        char firstChar = pwd.charAt(0);

        if (firstChar >= 'A' && firstChar <= 'Z') {

            if (firstChar == 'A') {
                System.out.println("Valid Password");
            } else {
                System.out.println("Invalid Password!");
            }
        } else if(firstChar >= 'a' && firstChar <= 'z'){
            if(firstChar == 'z'){
                System.out.println("Valid Password! Which is " + pwd);
            } else {
                System.out.println("Invalid Password! Which is " + pwd);
            }
        } else{
            System.out.println("Invalid Password! Because first character must be letter! Your first character is " + firstChar);
        }

        tryAgain();
    }

    public static void tryAgain(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to try again? (yes or no): ");
        String response = scan.next().toLowerCase();
        if (response.equals("yes")) {
            main(new String[0]);
        } else if (response.equals("no")) {
            System.out.println("Execution stopped!");
        } else {
            System.out.println("Invalid input. Try again!");
            tryAgain();
        }
    }
}