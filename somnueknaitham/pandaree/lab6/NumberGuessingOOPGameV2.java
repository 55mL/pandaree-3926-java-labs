/*
 * Author : Pandaree Somnueknaitham
 * Student ID : 673040392-6
 * Section : 2
 * 
 * The NumberGuessingOOPGameV2 Program
 *  This driver class contain configure, play games and main method.
 * 
 * Last update : 24 Jan 2025
 */
package somnueknaitham.pandaree.lab6;

import java.util.Scanner;

public class NumberGuessingOOPGameV2 {
    public static Scanner input = new Scanner(System.in); // Create a scanner
    private GuessGameV2 game;

    // Method to use configureGame method
    public void configure() {
        if (this.game == null){
            this.game = new GuessGameV2();
        }
        // Create a new GuessGame object
        this.game.configureGame(0, 0, 0);
        System.out.println(game.toString());
    }

    // Method to play game loop
    public void playGames() {
        boolean playAgain;
        do {
            boolean result = this.game.playSingleGame();
            System.out.println(result ? "You win!" : "Better luck next time.");

            // Play again if user input y or Y
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = input.next().equalsIgnoreCase("y");
            if (playAgain) {
                configure(); 
            }
        } while (playAgain);

        System.out.println("Thank you for playing the Number Guessing Game V2!");
        input.close(); // Close a scanner
    }

    public static void main(String[] args) {
        NumberGuessingOOPGameV2 program = new NumberGuessingOOPGameV2();
        program.configure(); 
        program.playGames(); 
    }
}
