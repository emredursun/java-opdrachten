package nl.sogyo.javaopdrachten.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Lists {
    public static void main(String[] args) {
        int[] randomArray = new int[10];
        Random random = new Random();

        // 1. Create a program that will initialize an array
        // with 10 random numbers between 0 and 100. Display the list.
        // Initialize the array with random numbers between 0 and 100
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(101); // Generate a random number between 0 and 100 (inclusive)
        }

        System.out.println("\n====================================");
        // 1.Display the array
        System.out.println("1.Random numbers generated:");
        for (int num : randomArray) {
            System.out.print(num + " ");
        }

        System.out.println("\n====================================");
        // 2.The highest. Expand your program so that
        // the highest value in your array will be displayed.
        int max = randomArray[0]; // Assume the first element is the maximum
        for (int i = 0; i < randomArray.length; i++){
            if (randomArray[i] > max){
                max = randomArray[i];
            }
        }
        System.out.println("2.The highest value in the array is: \n" + max);
        System.out.println("\n====================================");

        // 3.The lowest two. Expand your program so that the result of adding
        // the two lowest values in the array will be displayed.
        int[] sortedArray = randomArray.clone(); // In order not to change the original array
        Arrays.sort(sortedArray); // Reorder the elements of the randomArray in ascending order

        // Print the sorted array
        System.out.println("Sorted array in ascending order: ");
        for (int number : sortedArray) {
            System.out.print(number + " ");
        }
        int sumLowest2 = sortedArray[0] + sortedArray[1];
        System.out.println("\n3.The sum of the lowest two: \n" + sumLowest2);
        System.out.println("\n====================================");

        // 4.Filter. Expand your program to display all values that are even.
        System.out.println("4.Filter all even values of the array: ");
        for (int el : randomArray){
            if (el % 2 == 0){
                System.out.print(el + " ");
            }
        }
        System.out.println("\n====================================");

        // 5.Split. Expand your program to generate four list. In the first list
        // should contain all numbers that can be divided by 2, the second numbers
        // tha can be divided by 3, the third list should contain numbers
        // that can be divided by 5, and the final list should contain
        // the remaining numbers.
        System.out.println("5.Split: ");
        ArrayList<Integer> numDivBy2 = new ArrayList<>();
        ArrayList<Integer> numDivBy3 = new ArrayList<>();
        ArrayList<Integer> numDivBy5 = new ArrayList<>();
        ArrayList<Integer> restNums = new ArrayList<>();
        System.out.print("Random Array: ");
        for (int el : randomArray) {
            System.out.print(el + " ");
        }

        for (int el : randomArray){
            if (el % 2 == 0){
                numDivBy2.add(el);
            }
            if (el % 3 == 0) {
                numDivBy3.add(el);
            }
            if (el % 5 == 0) {
                numDivBy5.add(el);
            }
            if (el % 2 != 0 && el % 3 != 0 && el % 5 != 0) {
                restNums.add(el);
            }
        }
        System.out.println("\nAll numbers that can be divided by 2: " + numDivBy2);
        System.out.println("All numbers that can be divided by 3: " + numDivBy3);
        System.out.println("All numbers that can be divided by 5: " + numDivBy5);
        System.out.println("All numbers that can not be divided by 2, 3, 5: " + restNums);

        System.out.println("\n====================================");

        //6.Sort. Expand your program so that it will display the result of sorting
        // the numbers in the array in ascending order. Use the BubbleSort algorithm.
        System.out.println("6.Sort: ");
        System.out.println("Original Array:");
        printArray(randomArray);

        bubbleSort(randomArray);
        System.out.println("\nSorted Array by using the BubbleSort algorithm:");
        printArray(randomArray);

        System.out.println("\n====================================");
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no swapping occurred in the inner loop, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}