/*
 * Author : Pandaree Somnueknaitham
 * Student ID : 673040392-6
 * Section : 2
 * 
 * The NumberGuessingOOPGameV3 Program
 *  This driver class that has methods to configure, viewRecords, playGames and main method.
 * 
 * Last update : 25 Jan 2025
 */
package somnueknaitham.pandaree.lab6;

import java.util.Scanner;

public class NumberGuessingOOPGameV3 {

    public static Scanner input = new Scanner(System.in); // Create a scanner
    private GuessGameV3 game; 

    // Method to call configureGame
    public void configure() {
        this.game = new GuessGameV3();
        game.configureGame(0, 0, 0);
    }

    // Method to allow user to choose to view game record
    public void viewRecords() {
        System.out.println("View:");
        System.out.println("1. Complete Records");
        System.out.println("2. Specific Game Record");
        int choice = input.nextInt(); // Get user input

        // Complete record
        if (choice == 1) {
            GuessGameV3[] records = GuessGameV3.getGameRecords();
            int count = GuessGameV3.getRecordCount();

            // Display all game record
            for (int i = 0; i < count; i++) {
                System.out.println("Game " + (i + 1) + ": " + records[i].getGameLog());
            }
        } 
        // Specific game record
        else if (choice == 2) {
            System.out.print("Enter the game number to view: ");
            int gameNum = input.nextInt();

            // Display only user's game record
            if (gameNum > 0 && gameNum <= GuessGameV3.getRecordCount()) {
                GuessGameV3[] records = GuessGameV3.getGameRecords();
                System.out.println("Game " + gameNum + ": " + records[gameNum - 1].getGameLog());
            } else {
                System.out.println("Invalid game number.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // Method to run loop and at the end will allow user to choose menu
    public void playGames() {
        boolean nextGame = true;

        while (nextGame) {
            if (game != null) {
                game.playSingleGame();
            }

            boolean validChoice = false;
            while (!validChoice) {
                // Display menu 
                System.out.println("Do you want to:");
                System.out.println("1. Play again");
                System.out.println("2. View game records");
                System.out.println("3. Quit");

                int choice = input.nextInt(); // Get user's input

                switch (choice) {
                    // Play again and call configure method to configure new values
                    case 1:
                        configure();
                        validChoice = true;
                        break;
                    // Call viewRecords method to display game record
                    case 2:
                        viewRecords();
                        break;
                    // Exit loop
                    case 3:
                        nextGame = false;
                        validChoice = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        System.out.println("Thank you for playing Number Guessing Game V3!");
    }

    // Main method
    public static void main(String[] args) {
        NumberGuessingOOPGameV3 program = new NumberGuessingOOPGameV3();
        program.configure();
        program.playGames();
        input.close(); // Close a scanner
    }
}
