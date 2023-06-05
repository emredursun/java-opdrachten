package nl.sogyo.javaopdrachten.lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
public class Example {
    public static void main(String[] args) {
        Random rd = new Random(); // creating Random object
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(10); // Generate a random number between 0 and 9 (inclusive)
            System.out.println(arr[i]); // printing each array element
        }

        //defining an array of integer type
        int [] array = new int [] {90, 23, 5, 109, 12, 22, 67, 34};
        //invoking sort() method of the Arrays class
        int[] sortedArr = array.clone();
        // sorts array[] in ascending order
        Arrays.sort(sortedArr);
        System.out.println("Elements of array sorted in ascending order: ");
        //prints array using the for loop
        for (int i = 0; i < sortedArr.length; i++)
        {
            System.out.println(sortedArr[i]);
        }

        // sorts array[] in descending order
        //Arrays.sort(sortedArr, Collections.reverseOrder());
        System.out.println("Array elements in descending order: " +Arrays.toString(array));
    }
}


