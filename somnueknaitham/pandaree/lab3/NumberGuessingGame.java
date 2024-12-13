/*
 * Author : Pandaree Somnueknaithaam
 * Student ID : 673040392-6
 * Section : 2
 * 
 * The NumberGuessingGame Program
 * 
 * This program is a number guessing game that accept a number 1 to 10 from user which the answer is randomly.
 * Game ends when guess the number incorrectly 5 times.
 *  
 * The output should be :
 * Welcome to a number guessing game!
 * Enter an integer between 1 and 10: <guess>
 * Congratulations!         (when enters number same as answer)
 * Try a lower number!      (when enters number higher than answer)
 * Try a higher number!     (when enters number lower than answer)
 * 
 * Last update : 13 dec 2024
 */

package somnueknaitham.pandaree.lab3;

import java.util.Scanner;

public class NumberGuessingGame {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // create a scanner

        System.out.println("Welcome to a number guessing game!"); // output first line

        int min = 1; // set a min
        int max = 10; // set a max
        int answer = min + (int)(Math.random()*((max-min)+1)); // use this formula to generate a random number for the answer
       
        int numTry = 1; // set try to 1
        while (numTry <= 5) {
            System.out.print("Enter an integer between 1 and 10 : " ); // output second line

            int guess = scanner.nextInt(); // read input

            if ( guess == answer ) {
                System.out.println("Congratulations!"); // output when win
                if ( numTry == 1) {
                    System.out.print("You have tried " + numTry + " time."); // output number of try when win
                    break ;
                } else {
                    System.out.print("You have tried " + numTry + " times."); // output number of try when win
                    break ;
                }
            } else if (guess != answer) {
                if (guess < answer) {
                    System.out.println("Try a higher number!"); // output when the input number less than an answer
                }
                else if (guess > answer){
                    System.out.println("Try a lower number!"); // output when the input number more than an answer
                }

                if ( numTry == 5) {
                    System.out.print("You have tried " + numTry + " times."); // output  number of try when try 5 times
                    System.out.println(" You ran out of guesses."); // output when try 5 times
                    System.out.println("The answer is "+ answer + "."); // output answer when try 5 times
                }  
                numTry += 1; // increse number of try by 1
            }
            
        }
        
        scanner.close(); 
    }
    
}
