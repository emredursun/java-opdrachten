## *Fractional calculation (required)*
Some numbers cannot be represented accurately in the decimal system, think of 1/3rd. Make a class Fraction that is constructed with a numerator and a denominator. The program should be able to get the values of the numerator and the denominator, but should not be able to modify them. Implement the following functions:

- double toDecimalNotation(): 1/3 should return 0.33333
- string toString(): 1/3 should return “1/3”
- Fraction add(int number): 1/3 + 1 should become 4/3
- Fraction add(Fraction fraction): 1/3 + 1/6 should become 1/2
- Fraction subtract(int number): 4/3 - 1 should become 1/3
- Fraction subtract(Fraction fraction): 1/2 - 1/6 should become 1/3
- Fraction multiply(int number): 3/4 * 2 should become 3/2
- Fraction multiply(Fraction fraction): 3/4 * 2/5 should become 3/10
- Fraction divide(int number): 3/2 / 2 should become 3/4
- Fraction divide(Fraction fraction): 3/10 / 2/5 should become 3/4

### *Learning goals*
- Creating an immutable object
- Creating a technical api on an object

### *References*
- [Wikipedia](https://en.wikipedia.org/wiki/Fraction)