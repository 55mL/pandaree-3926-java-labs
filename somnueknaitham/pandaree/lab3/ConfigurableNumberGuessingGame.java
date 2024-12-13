/*
 * Author : Pandaree Somnueknaitham
 * Student ID : 673040392-6
 * Section : 2
 * 
 * The ConfigurableNumberGuessingGame Program
 * 
 * This program is a number guessing game.
 * First the program will accept a min value, max value and maximum number of tries.
 * Then accept number from user which the answer is randomly.
 * Game ends when guess the number incorrectly for maximum number of tries times.
 *  
 * The output should be :
 * Welcome to a number guessing game!
 * Enter the min value : <min>
 * Enter the max value : <max>
 * Enter the maximum number of tries : <max_of_tries>
 * Enter an integer between <min> and <max> : <guess>
 * Congratulations!         (when enters number same as answer)
 * Try a lower number!      (when enters number higher than answer)
 * Try a higher number!     (when enters number lower than answer)
 * 
 * Last update : 13 dec 2024
 */

package somnueknaitham.pandaree.lab3;

import java.util.Scanner;

public class ConfigurableNumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // create a scanner

        int min, max, max_of_tries; // set variables as integer

        while (true) {

            System.out.print("Enter the min value : "); // ask user to input min value
            min = scanner.nextInt(); // read input as min

            System.out.print("Enter the max value : "); // ask user to input max value
            max = scanner.nextInt(); // read input as max

            if (min <= max) {
                break; 
            } else {
                System.err.println("The max value must be at least equal to the min value"); // shows error when max value less than min value
            }
        }
        while (true) {

            System.out.print("Enter the maximum number of tries : "); // ask user to input maximum number of tries
            max_of_tries = scanner.nextInt(); // read input as max_of_tries

            if (max_of_tries > 0) {
                break;
            } else {
                System.err.println("The maximum number of tries must be greater than 0"); // shows error when max_of_tries less than 0
            }
        }

        System.out.println("Welcome to a number guessing game!"); // output welcome message

        int num_try = 1; // set number of try as 1
        int answer = min + (int) (Math.random() * ((max - min) + 1)); // generate a random answer

        while (num_try <= max_of_tries) {
            System.out.print("Enter an integer between " + min + " and " + max + " : "); // ask user to guess number
            int guess = scanner.nextInt(); // read input as guess

            if (guess < min || guess > max) {
                System.err.println("The  number must be between " + min + " and " + max); // shows error when the input number less than min or more than max
                continue;
            }
            if (guess == answer) {
                System.out.println("Congratulations!"); // output when win
                if (num_try == 1) {
                    System.out.print("You have tried " + num_try + " time."); // output number of try when win
                    break;
                } else {
                    System.out.print("You have tried " + num_try + " times."); // output number of try when win
                    break;
                }
            } else {
                if (guess < answer) {
                    System.out.println("Try a higher number!"); // output when the input number less than an answer
                } else if (guess > answer) {
                    System.out.println("Try a lower number!"); // output when the input number more than an answer
                }

                if (num_try == max_of_tries) {
                    System.out.print("You have tried " + num_try + " times."); // output number of try when try maximum times
                    System.out.println(" You ran out of guesses."); // output when try maximum times
                    System.out.println("The answer is " + answer + "."); // output when try maximum times
                }

            }
            num_try += 1; // increse number of try by 1
        }
    scanner.close(); // close a scanner
    }
}
