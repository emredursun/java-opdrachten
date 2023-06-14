package nl.sogyo.javaopdrachten.fractional_calculation;

public class Fraction {

    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // double toDecimalNotation()
    public double toDecimalNotation() {
        return (double)numerator/ (double) denominator;

    }

    // string toString()
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Fraction add(int number):
    public Fraction add(int number) {
        int newNumerator = this.numerator + number * this.denominator;
        int newDenominator = this.denominator;
        int gcd = gcd(newNumerator, newDenominator);
        return new Fraction(newNumerator / gcd, newDenominator /gcd);
    }

    // Fraction add(Fraction fraction):
    public Fraction add(Fraction fraction) {
        int newNumerator = this.numerator * fraction.denominator + fraction.numerator * this.denominator;
        int newDenominator = this.denominator * fraction.denominator;
        int gcd = gcd(newNumerator, newDenominator);
        return new Fraction(newNumerator / gcd, newDenominator / gcd);
    }

    // GCD (Greatest Common Divisor
    // To simplify the result by dividing the numerator and denominator by their greatest common divisor.
    public int lcd(int a, int b) {
        return a * b / gcd(a, b);
    }

    // LCD (Least Common Denominator)
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Fraction subtract(int number):
    public Fraction subtract(int number){
        return add(-number);
    }

    // Fraction subtract(Fraction fraction): 1/2 - 1/6 should become 1/3
    public Fraction subtract(Fraction fraction){
        int newNumerator = this.numerator * fraction.denominator - this.denominator * fraction.numerator;
        int newDenominator = this.denominator * fraction.denominator;
        int gcd = gcd(newNumerator, newDenominator);
        return new Fraction(newNumerator / gcd, newDenominator / gcd);
    }

    // Fraction multiply(int number): 3/4 * 2 should become 3/2
    public Fraction multiply(int number){
        int newNumerator = this.numerator * number;
        int newDenominator = this.denominator;
        int gcd = gcd(newNumerator, newDenominator);
        return new Fraction(newNumerator / gcd, newDenominator / gcd);
    }

    // Fraction multiply(Fraction fraction): 3/4 * 2/5 should become 3/10
    public Fraction multiply(Fraction fraction){
        int newNumerator = this.numerator * fraction.numerator;
        int newDenominator = this.denominator * fraction.denominator;
        int gcd = gcd(newNumerator,newDenominator);
        return new Fraction(newNumerator / gcd,newDenominator / gcd);
    }

    // // Fraction divide(int number): 3/2 / 2 should become 3/4
    public Fraction divide(int number){
        int newNum = this.numerator;
        int newDen = this.denominator * number;
        int gcd = gcd(newNum, newDen);
        return new Fraction(newNum / gcd, newDen / gcd);
    }

    // Fraction divide(Fraction fraction): 3/10 / 2/5 should become 3/4
    public Fraction divide(Fraction fraction){
        int newNumerator = this.numerator * fraction.denominator;
        int newDenominator = this.denominator * fraction.numerator;
        int gcd = gcd(newNumerator,newDenominator);
        return new Fraction(newNumerator / gcd,newDenominator / gcd);
    }

    public double getNumerator() {
        return numerator;
    }

    public double getDenominator() {
        return denominator;
    }
}
