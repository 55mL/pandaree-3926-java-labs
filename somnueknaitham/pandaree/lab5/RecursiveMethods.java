/*
 * Author : Pandaree Somnueknaitham
 * Student ID : 673040392-6
 * Section : 2
 * 
 * The RecursiveMethods Program
 * This program has three methods.
 * 1.sumOfDigits method that can find sum of all input digits.
 * 2.reverseArray method that can reverse your input array.
 * 3.isPalindrome method that can check your input Is it a palindrome.
 * 
 * The output should be :
 * Sum of digits in 45: 9
 * Sum of digits in 12345: 15
 * 
 * Original array:
 * 1 2 3 4 5
 * Reversed array:
 * 5 4 3 2 1
 * 
 * Testing palindrome:
 * 1 2 3 2 1
 * Is palindrome: true
 * 
 * Testing palindrome:
 * 1 2 1 2
 * Is palindrome: false
 * 
 * Last update : 27 dec 2024
 */
package somnueknaitham.pandaree.lab5;


public class RecursiveMethods {

    static int number, start, end, sum; // declare variable
    static int[] arr; // declare variable

    // method to find sum of digits
    public static int sumOfDigits(int number) {
    if (number == 0) 
            return 0;

        sum = number % 10 + sumOfDigits(number / 10);
        return sum;
    }

    // method to reverse array
    public static void reverseArray(int[] arr, int start, int end) {
        if (start >= end) 
            return;

        int x = arr[start];
        arr[start] = arr[end];
        arr[end] = x;

        reverseArray(arr, start + 1, end - 1);
    }

    // method to check palindrome
    public static boolean isPalindrome(int[] arr, int start, int end) {
        if (start >= end) 
            return true;

        if (arr[start] != arr[end])
            return false;

        return isPalindrome(arr, start + 1, end - 1);
    }

    // main method
    public static void main(String[] args) {

        // call method sum of digits
        System.out.println("Sum of digits in 45: " + sumOfDigits(45)); // if input is 45
        System.out.println("Sum of digits in 12345: " + sumOfDigits(12345)); // if input is 12345
        System.out.println(" ");

        // call method array
        arr = new int[]{1, 2, 3, 4, 5};
        reverseArray(arr, 0, arr.length - 1);
        System.out.println("Original array:");
        System.out.println("1 2 3 4 5"); // if input is 1 2 3 4 5
        System.out.println("Reverse array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
        System.out.println(" ");

        // call method Ispalindrome
        arr = new int[]{1, 2, 3, 2, 1};
        System.out.println("Testing palindrome:");
        System.out.println("1 2 3 2 1"); // if input is 1 2 3 2 1
        System.out.println("Is palindrome: " + isPalindrome(arr, 0, arr.length - 1));
        System.out.println(" ");

        arr = new int[]{1, 2, 1, 2};
        System.out.println("Testing palindrome:");
        System.out.println("1 2 1 2"); // if input is 1 2 1 2
        System.out.println("Is palindrome: " + isPalindrome(arr, 0, arr.length - 1));
    }
}

