/*
 * Author : Pandaree Somnueknaitham
 * Student ID : 673040392-6
 * Section : 2
 * 
 * The GuessGameV2 Class
 *  This class has constructors that call parent class and
 *  add methods to configure and play single game with error check and method to display game configuration .
 * 
 * Last update : 24 Jan 2024
 */
package somnueknaitham.pandaree.lab6;

import java.util.Scanner;

public class GuessGameV2 extends GuessGame {

    // Default constructor that call parent class
    public GuessGameV2() {
        super();
    }

    // Parameterized constructor that call parent class
    public GuessGameV2(int newMin, int newMax, int new_max_of_tries) {
        super(newMin, newMax, new_max_of_tries);
    }

    // Method to allow user to configurable values and display error
    @Override
    public void configureGame(int newMin, int newMax, int new_max_of_tries) {
        Scanner scanner = NumberGuessingOOPGameV2.input;

        // Check that min less than or equal to max
        do {
            System.out.print("Enter the min value: ");
            newMin = scanner.nextInt();

            System.out.print("Enter the max value: ");
            newMax = scanner.nextInt();

            if (newMin > newMax) {
                System.err.println("Invalid input: max must be greater than or equal to min.");
            }
        } while (newMin > newMax);

        // Check that max of tries greater than 0
        do{
            System.out.print("Enter the maximum number of tries: ");
            new_max_of_tries = scanner.nextInt();
            if (new_max_of_tries <= 0) {
                System.err.println("Invalid input: maxTries must be greater than 0.");
            }
        } while (new_max_of_tries <= 0);
        
        setMin(newMin);
        setMax(newMax);
        setMaxTries(new_max_of_tries);
    }
    

    // Method to play game and check error 
    @Override
    public boolean playSingleGame() {
        boolean win = false;

        generateAnswer();
        System.out.println("Welcome to the Number Guessing Game V2!");

        setAttempts(0);

        // Loop for plays game according to maxTries
        while (getAttempts() < getMaxTries()) {
            System.out.print("Enter an integer between " + getMin() + " and " + getMax() + ": ");
            int guess = NumberGuessingOOPGameV2.input.nextInt();

            // Check that input is between min and max
            if (guess < getMin() || guess > getMax()) {
                System.err.println("Invalid input: guess must be between " + getMin() + " and " + getMax());
                continue;
            }

            // Increase attempt by 1
            setAttempts(getAttempts() + 1);


            // Print winning message based on the attempt
            if (guess == getAnswer()) {
                System.out.print("Congratulations!");
                win = true;
                if (getAttempts() == 1) {
                    System.out.println(" You've guessed the number in 1 attempt.");
                } else {
                    System.out.println(" You've guessed the number in " + getAttempts() + " attempts.");
                }
                break;
            } 
            // Give hint if answer is incorrect
            else {
                if (guess < getAnswer()) {
                    System.out.println("Try a higher number!");
                } else {
                    System.out.println("Try a lower number!");
                }
            }
        }

        // Print when all attempts are used
        if (!win) {
            System.out.println("Sorry, you've used all your attempts. The correct answer was: " + getAnswer());
        }

        // return win to true if win and false if not
        return win;
    }

    // Method to display game configuration
    public String toString() {
        return "Game Configuration: [Min: " + getMin() + ", Max: " + getMax() + ", Max Tries: " + getMaxTries()
                + ", Attempts: " + getAttempts() + "]";
    }

}
