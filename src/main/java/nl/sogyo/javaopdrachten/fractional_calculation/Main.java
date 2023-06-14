package nl.sogyo.javaopdrachten.fractional_calculation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.print("Enter your numerator for first fraction: ");
        Scanner scan = new Scanner(System.in);
        int firstNumerator = scan.nextInt();
        System.out.print("Enter your denominator for first fraction: ");
        int firstDenominator = scan.nextInt();
        Fraction firstFraction = new Fraction(firstNumerator, firstDenominator);

        System.out.print("Enter your test number: ");
        int testNumber = scan.nextInt();

        System.out.print("Enter your numerator for second fraction: ");
        int secondNumerator = scan.nextInt();
        System.out.print("Enter your denominator for second fraction: ");
        int secondDenominator = scan.nextInt();
        Fraction secondFraction = new Fraction(secondNumerator,secondDenominator);

        // double toDecimalNotation(): 1/3 should return 0.33333
        double toDecimalNotation = firstFraction.toDecimalNotation();
        System.out.println(toDecimalNotation);

        // string toString(): 1/3 should return “1/3”
        String toString = firstFraction.toString();
        System.out.println(toString);

        // Fraction add(int number): 1/3 + 1 should become 4/3
        Fraction F1AddTestNum = firstFraction.add(testNumber);
        System.out.print(firstFraction.toString() + " + " + testNumber + " = ");
        System.out.println(F1AddTestNum);

        // Fraction add(Fraction firstFraction): 1/3 + 1/6 should become 1/2
        System.out.print(firstFraction.toString() + " + " + secondFraction.toString() + " = ");
        Fraction F1AddF2 = firstFraction.add(secondFraction);
        System.out.println(F1AddF2);

        // Fraction subtract(int number): 4/3 - 1 should become 1/3
        Fraction F1MinTestNum = firstFraction.subtract(testNumber);
        System.out.print(firstFraction.toString() + " - " + testNumber + " = ");
        System.out.println(F1MinTestNum);

        // Fraction subtract(Fraction fraction): 1/2 - 1/6 should become 1/3
        System.out.print(firstFraction.toString() + " - " + secondFraction.toString() + " = ");
        Fraction F1MinF2 = firstFraction.subtract(secondFraction);
        System.out.println(F1MinF2);

        // Fraction multiply(int number): 3/4 * 2 should become 3/2
        System.out.print(firstFraction.toString() + " * " + testNumber + " = ");
        Fraction F1MultiplyTestNum = firstFraction.multiply(testNumber);
        System.out.println(F1MultiplyTestNum);

        // Fraction multiply(Fraction fraction): 3/4 * 2/5 should become 3/10
        System.out.print(firstFraction.toString() + " * " + secondFraction.toString() + " = ");
        Fraction F1MultiplyF2 = firstFraction.multiply(secondFraction);
        System.out.println(F1MultiplyF2);

        // Fraction divide(int number): 3/2 / 2 should become 3/4
        System.out.print(firstFraction.toString() + " / " + testNumber + " = ");
        Fraction F1DivideTestNum = firstFraction.divide(testNumber);
        System.out.println(F1DivideTestNum);

        // Fraction divide(Fraction fraction): 3/10 / 2/5 should become 3/4
        System.out.print(firstFraction.toString() + " / " + secondFraction.toString() + " = ");
        Fraction F1DivideF2 = firstFraction.divide(secondFraction);
        System.out.println(F1DivideF2);

    }
}
