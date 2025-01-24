/*
 * Author : Pandaree Somnueknaitham
 * Student ID : 673040392-6
 * Section : 2
 * 
 * The NumberGuessingOOPGame Program
 *  This driver class has main method
 * Last update : 24 Jan 2025
 */
package somnueknaitham.pandaree.lab6;

import java.util.Scanner;

public class NumberGuessingOOPGame {

    public static Scanner scanner = new Scanner(System.in); // Create a scanner
    private GuessGame game; 

    // Method to allow user to configurable values
    public void configure() {
        System.out.print("Enter the min value: ");
        int min = scanner.nextInt();
        System.out.print("Enter the max value: ");
        int max = scanner.nextInt();
        System.out.print("Enter the maximum number of tries: ");
        int max_of_tries = scanner.nextInt();

        // Create a new GuessGame object
        this.game = new GuessGame(min, max, max_of_tries);
    }

    // Method to play game loop
    public void playGames() {
        boolean playAgain;
        // Play again if user input y or Y
        do {
            boolean result = this.game.playSingleGame();
            System.out.println(result ? "You win!" : "Better luck next time.");
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next().equalsIgnoreCase("y");
            if (playAgain) {
                configure();
            }
        } while (playAgain);

        System.out.println("Thank you for playing the Number Guessing Game!");
    }

    // Main method
    public static void main(String[] args) {
        NumberGuessingOOPGame program = new NumberGuessingOOPGame();
        program.configure(); // Configure values
        program.playGames(); // Start loop
        scanner.close(); // Close a scanner
    }
}
