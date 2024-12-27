/*
 * Author : Pandaree Somnueknaitham
 * Student ID : 673040392-6
 * Section : 2
 * 
 * The NumberGuessingMethodGamesV2 Program
 * 
 * This program is a number guessing game that improve from NumberGuessingMethodGames
 * When game ends 1 time the program will ask question "Enter 'a' to list all guesses, 'g' for a specific guess, or any other key to quit: "
 * The program add more 3 methods
 * 1. displayGuesses method for displays all guesses
 * 2. displayChooseGuesses method for displays specifis guess
 * 3. displayGuessesLoop method for ask and call displayGuesses and displayGuessesLoop method 
 * 
 * 
 * Last update : 19 Dec 2024
 */

package somnueknaitham.pandaree.lab4;

import java.util.Scanner;
import java.util.Arrays;

public class NumberGuessingMethodGamesV2 {

    static Scanner scanner = new Scanner(System.in); // create a scanner
    static int min, max, max_of_tries, answer; // define integer variables
    static String choice; // define a string variable
    static int[] arr_guess = new int[10]; // store array 10 guesses
    static int num_guess ; // define number of guesses

    // method for configure min, max, number of tries from user
    static void configure() {

        while (true) {
            System.out.print("Enter the min value : "); // ask user to input min value
            min = scanner.nextInt(); // read input as min

            System.out.print("Enter the max value : "); // ask user to input max value
            max = scanner.nextInt(); // read input as max

            // check if min least equal to max
            if (min <= max) {
                break; // exit loop
            } else {
                System.err.println("The max value must be at least equal to the min value"); // display errors
            }
        }
        while (true) {

            System.out.print("Enter the maximum number of tries : "); // ask user to input number of tries
            max_of_tries = scanner.nextInt(); // read input as max_of_tries

            // check if number of tries more than 0
            if (max_of_tries > 0) {
                break; // exit loop
            } else {
                System.err.println("The maximum number of tries must be greater than 0"); // display errors
            }
        }

    }

    // method for generate random answer
    static void genAnswer() {
        answer = min + (int) (Math.random() * ((max - min) + 1)); // generate random answer
        num_guess = 0;
    }

    // method for play one time
    static void playGame() {

        genAnswer(); // call genAnswer method
        System.out.println("Welcome to a number guessing game!"); // display welcome message

        int num_try = 0; // set number of try to 1

        // when number of tries least equal to maximum number of tries
        while (num_try <= max_of_tries - 1) {
            System.out.print("Enter an integer between " + min + " and " + max + " : "); // display range of number
                                                                                         
            int guess = scanner.nextInt(); // ask user to guess number

            // check if guess less than min or more than max
            if (guess < min || guess > max) {
                // display errors
                System.err.println("The  number must be between " + min + " and " + max);
                continue; // restart loop
            }

            // store num_try as array
            arr_guess[num_try] = guess;
            num_guess++; // increse num_guess by 1

            // check if guess equal to answer (win)
            if (guess == answer) {
                System.out.println("Congratulations!"); // display message

                // check if number of try equal to 1
                if (num_try == 0) {
                    System.out.println("You have tried " + (num_try +1) + " time."); // display number of try
                    break; // exit loop
                } else {
                    System.out.println("You have tried " + (num_try+1) + " times."); // display number of tries
                    break; // exit loop
                }
            }
            // give hints
            else if (guess != answer) {
                if (guess < answer) {
                    System.out.println("Try a higher number!"); // display when guess less than answer
                } else if (guess > answer) {
                    System.out.println("Try a lower number!"); // display when guess more than answer
                }
                // check if run out maximum number of tries
                if (num_try == max_of_tries - 1) {
                    System.out.print("You have tried " + (num_try+1) + " times."); // display number of tries
                    System.out.println(" You ran out of guesses."); // display message
                    System.out.println("The answer is " + answer + "."); // display answer
                }

            }
            num_try++; // increse num_try by 1
        }
        
    }

    // method for display all guesses
    static void displayGuesses() {
        for (int i = 0; i < num_guess; i++) {
            System.out.println("Guess " + (i+1) + ": " + arr_guess[i]);
        }

    }

    // method for display a specific guess
    static void displayChooseGuesses (int n){
        if (n > 0 && n <= num_guess) {
            System.out.println("Guess " + n + ": " + arr_guess[n - 1]);
        }

    }

    // method for ask to display guess 
    static void displayGuessesLoop(){

        while (true) {
            // ask user to input a(all guesses), g(specific guess), others(quit)
            System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any other key to quit: ");
            String guess_choice = scanner.next();

            // if choice is a, call displayGuesses method
            if (guess_choice.equalsIgnoreCase("a")){
                displayGuesses();
            } 
            // if choice is g, call displayChooseGuesses method
            else if (guess_choice.equalsIgnoreCase("g")) {
                System.out.print("Enter the guess number: ");
                int num = scanner.nextInt();
                displayChooseGuesses(num);
            } 
            // others, exit loop
            else {
                break; 
            }
        }
    }

    // method for play multiple times
    static void playGames() {
        do {
            playGame(); // call playGame method
            displayGuessesLoop(); // call displayGuessesLoop method
            System.out.print("Want to play again (Y or y) : "); // ask user choice to play again
            choice = scanner.next(); // read input as choice
        } while (choice.equalsIgnoreCase("y")); // do loop when choice is 'y' or 'Y'
        System.out.println("Thank you for playing our games.  Bye!"); // display when choice is other
        scanner.close(); // close a scanner

    }

    // main method of the program
    public static void main(String[] args) {
        configure(); // call congfigure method
        playGames(); // call playGames method
    }
}
