/*
 * Author : Pandaree Somnueknaitham
 * Student ID : 673040392-6
 * Section : 2
 * 
 * The GuessGame Class
 *  This class has constructors to setting up and parameterize the guesses and
 *  methods to set, get, configure, generate answers and play single game.
 * 
 * Last update : 24 Jan 2025
 */
package somnueknaitham.pandaree.lab6;

import java.util.Scanner;

public class GuessGame {

    private int min, max, max_of_tries, answer, attempts; // Declare variables
    public static Scanner input = new Scanner(System.in); // Create a scanner

    // Default constructor
    public GuessGame() {
        min = 1;
        max = 100;
        max_of_tries = 10;
        answer = 0;
        attempts = 0;
    }

    // Parameterized constructor
    public GuessGame(int newMin, int newMax, int new_max_of_tries) {
        min = newMin;
        max = newMax;
        max_of_tries = new_max_of_tries;
        answer = 0;
        attempts = 0;
    }

    // Method to return a current min
    public int getMin() {
        return min;
    }

    // Method to set a new value for min
    public void setMin(int newMin) {
        min = newMin;
    }

    // Method to return a current max
    public int getMax() {
        return max;
    }

    // Method to set a new value of max
    public void setMax(int newMax) {
        max = newMax;
    }

    // Method to return a current maxTries
    public int getMaxTries() {
        return max_of_tries;
    }

    // Method to set a new value of maxTries
    public void setMaxTries(int new_max_of_tries) {
        max_of_tries = new_max_of_tries;
    }

    // Method to return a current answer
    public int getAnswer() {
        return answer;
    }

    // Method to set a new value of answer
    public void setAnswer(int newAnswer) {
        answer = newAnswer;
    }

    // Method to a current attempts
    public int getAttempts() {
        return attempts;
    }

    // Method to set a new value of attempts
    public void setAttempts(int newAttempts) {
        attempts = newAttempts;
    }

    // Method to configure values
    public void configureGame(int newMin, int newMax, int new_max_of_tries){
        min = newMin;
        max = newMax;
        max_of_tries = new_max_of_tries;
    }

    // Method to random answer
    public void generateAnswer() {
        answer = min + (int) (Math.random() * ((max - min) + 1));
    }

    // Method to play game
    public boolean playSingleGame() {

        boolean win = false;

        generateAnswer();
        System.out.println("Welcome to the Number Guessing Game!");

        attempts = 1;

        // Loop for plays game according to maxTries
        while (attempts <= max_of_tries) {
            System.out.print("Enter an integer between " + min + " and " + max + " : ");

            int guess = input.nextInt();

            // Check if answer is correct
            if (guess == answer) {
                System.out.print("Congratulations!");
                win = true;
                // Print winning message based on the attempt
                if (attempts == 1) {
                    System.out.println(" You've guessed the number in " + attempts + " attempt.");
                    break;
                } else {
                    System.out.println(" You've guessed the number in " + attempts + " attempts.");
                    break;
                }
            }

            // Check if answer is incorrect
            else if (guess != answer) {
                // Give hints
                if (guess < answer) {
                    System.out.println("Try a higher number!");
                } else if (guess > answer) {
                    System.out.println("Try a lower number!");
                }
                // Print when all attempts are used
                if (attempts == max_of_tries) {
                    System.out.println("Sorry, you've used all your attempts. The correct answer was: " + answer);
                }
            }
            // Increase attempt by 1
            attempts++;
        }

        // return win to true if win and false if not
        return win;
    }

}
