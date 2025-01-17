/*
 * Author : Pandaree Somnueknaitham
 * Student ID : 673040392-6
 * Section : 2
 * 
 * The NumberAnalyzer Program
 * This program has three methods.
 * 1.findMinMax method that can find min and max value of array.
 * 2.calculateRunningAverages method that can calculate the running average of numbers up to each position.
 * 3.isSorted method that can check your input Is array in ascending order.
 * 
 * The output should be :
 * Testing with array: {4, 2, 7, 1, 9}
 * Minimum value: 1
 * Maximum value: 9
 * 
 * Running averages:
 * Position 0: 4.00
 * Position 1: 3.00
 * Position 2: 4.33
 * Position 3: 3.50
 * Position 4: 4.60
 * 
 * Testing if arrays are sorted:
 * 4 2 7 1 9
 * numbers1 is sorted: false
 * 1 2 3 4 5
 * numbers2 is sorted: true
 * 
 * Last update : 27 dec 2024
 */
package somnueknaitham.pandaree.lab5;

import java.util.Arrays;

public class NumberAnalyzer {

    // method to find min and max in array
    public static int[] findMinMax(int[] numbers) {
        int min = numbers[0], max = numbers[0]; // set min and max as int
        for (int num : numbers) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        return new int[]{min, max};
    }

    // method to calculate the running average of numbers up to each position.
    public static double[] calculateRunningAverages(int[] numbers) {
        double[] averages = new double[numbers.length]; // set average as double
        int sum = 0; // set sum to 0
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i]; // increase sum by number
            averages[i] = (double) sum / (i + 1);
        }
        return averages;
    }

    // method to check input in ascending order.
    public static boolean isSorted(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // main method
    public static void main(String[] args) {
        
        // if input is 4, 2, 7, 1, 9
        int[] numbers1 = {4, 2, 7, 1, 9};
        System.out.println("Testing with array: " + Arrays.toString(numbers1).replace("[", "{").replace("]", "}")); // replace [] with {}

        // call method find min and max
        int[] minMax = findMinMax(numbers1);
        System.out.println("Minimum value: " + minMax[0]); // display min
        System.out.println("Maximum value: " + minMax[1]); // display max

        // call method calculateRunningAverages
        System.out.println("\nRunning averages:");
        double[] averages = calculateRunningAverages(numbers1);
        for (int i = 0; i < averages.length; i++) {
            System.out.printf("Position %d: %.2f\n", i, averages[i]); // display with two point decimal
        }

        // call method isSorted
        System.out.println("\nTesting if arrays are sorted:");
        System.out.println("4 2 7 1 9");
        System.out.println("numbers1 is sorted: " + isSorted(numbers1));

        // call method isSorted if input is 1 2 3 4 5
        int[] numbers2 = {1, 2, 3, 4, 5};
        System.out.println("1 2 3 4 5");
        System.out.println("numbers2 is sorted: " + isSorted(numbers2));
    }
}
