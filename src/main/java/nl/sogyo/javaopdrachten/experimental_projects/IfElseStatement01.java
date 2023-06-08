package nl.sogyo.javaopdrachten.experimental_projects;

import java.util.Scanner;

public class IfElseStatement01 {
    public static void main(String[] args) {
        //Type a code to print its season after getting a month from user.

        printSeason();
    }

    public static void printSeason(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a month name: ");
        String month = scan.next().toLowerCase();
        if(month.equals("march") || month.equals("april") || month.equals("may")){
            System.out.println("Spring..");
            tryAgain();
        } else if ( month.equals("june") || month.equals("july") || month.equals("august") ){
            System.out.println("Summer..");
            tryAgain();
        } else if ( month.equals("september")  || month.equals("october") || month.equals("november")){
            System.out.println("Autumn..");
            tryAgain();
        } else if ( month.equals("december")  || month.equals("january") || month.equals("february")){
            System.out.println("Winter..");
            tryAgain();
        } else {
            System.out.println("Hey user! Are you sure that it is a month!!! Try again...");
            printSeason();
        }
    }

    public static void tryAgain(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to try again? (yes or no): ");
        String response = scan.next().toLowerCase();
        if (response.equals("yes")) {
            printSeason();
        } else if (response.equals("no")) {
            System.out.println("Execution stopped!");
        } else {
            System.out.println("Invalid input. Try again!");
            tryAgain();
        }
    }
}
