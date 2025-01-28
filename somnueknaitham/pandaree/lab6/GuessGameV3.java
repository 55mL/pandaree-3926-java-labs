/*
 * Author : Pandaree Somnueknaitham
 * Student ID : 673040392-6
 * Section : 2
 * 
 * The NumberGuessingOOPGameV3 Program
 *  This class extends from GuessGameV2 and add more a getGameLog, addGameRecord, 
 *  getGameRecords and getRecordCount method.
 * 
 * Last update : 28 Jan 2025
 */
package somnueknaitham.pandaree.lab6;

import java.util.Scanner;

public class GuessGameV3 extends GuessGameV2 {

    // Declare variables
    private static final int MAX_GAMES = 100;
    private static GuessGameV3[] gameRecords = new GuessGameV3[MAX_GAMES];
    private static int recordIndex = 0;
    private int[] guesses;
    private int guessCount;
    private boolean win;

    // Default constructor that calls parent class
    public GuessGameV3() {
        super();
        guessCount = 0;
        win = false;
        guesses = new int[getMaxTries()];
    }

    // Parameterized constructor that calls parent class
    public GuessGameV3(int min, int max, int maxTries) {
        super(min, max, maxTries);
        guessCount = 0;
        win = false;
        guesses = new int[maxTries];
    }

    // Method to configure values, overriding parent class
    @Override
    public void configureGame(int min, int max, int maxTries) {
        
        Scanner scanner = NumberGuessingOOPGameV3.input;

        // Check that min less than or equal to max
        do {
            System.out.print("Enter the min value: ");
            min = scanner.nextInt();

            System.out.print("Enter the max value: ");
            max = scanner.nextInt();

            if (min > max) {
                System.err.println("Invalid input: max must be greater than or equal to min.");
            }
        } while (min > max);

        // Check that max of tries greater than 0
        do{
            System.out.print("Enter the maximum number of tries: ");
            maxTries = scanner.nextInt();
            if (maxTries <= 0) {
                System.err.println("Invalid input: maxTries must be greater than 0.");
            }
        } while (maxTries <= 0);
        
        // Set new variables
        setMin(min);
        setMax(max);
        setMaxTries(maxTries);
        guessCount = 0;
        win = false;
        guesses = new int[maxTries];
    }

    // Method to play a single game
    public boolean playSingleGame() {
        System.out.println("Welcome to the Record-Keeping Number Guessing Game!");
        int answer = getMin() + (int) (Math.random() * ((getMax() - getMin()) + 1));
        win = false;
        guessCount = 0;

        // Loop for play game
        for (int i = 0; i < getMaxTries();) {
            System.out.print("Enter an integer between " + getMin() + " and " + getMax() + ": ");
            int guess = NumberGuessingOOPGameV3.input.nextInt();

            // Check error
            if (guess < getMin() || guess > getMax()) {
                System.out.println("Invalid input: guess must be between " + getMin() + " and " + getMax());
                continue;
            }

            // Store guess
            guesses[guessCount++] = guess;

            // If answer is correct
            if (guess == answer) {
                System.out.println("Congratulations! You've guessed the number in " + (i + 1) + " attempts.");
                win = true;
                break;
            } else {
                System.out.println(guess < answer ? "Try a higher number!" : "Try a lower number!");
            }
            // Increase i by 1
            i++;
        }

        // Print when all attempts are used
        if (!win) {
            System.out.println("Sorry, you've used all your attempts. The correct answer was: " + answer);
        }

        // Add to game record
        addGameRecord(this);
        // return win to true if win and false if not
        return win;
        
    }

    // Method to display game log pattern
    public String getGameLog() {
        StringBuilder log = new StringBuilder();
        log.append("Range: [" + getMin() + "-" + getMax() + "], Max Tries: " + getMaxTries());
        log.append(", Attempts: " + guessCount + ", Result: " + (win ? "Win" : "Lose"));
        log.append(", Guesses: ");
        for (int i = 0; i < guessCount; i++) {
            log.append(guesses[i]);
            if (i < guessCount - 1) log.append(", ");
        }
        return log.toString();
    }

    // Method to store game record
    public static void addGameRecord(GuessGameV3 game) {
        if (recordIndex < MAX_GAMES) {
            gameRecords[recordIndex++] = game;
        } else {
            System.out.println("Game record limit reached! Unable to add more games.");
        }
    }

    // Method to return current game record
    public static GuessGameV3[] getGameRecords() {
        return gameRecords;
    }

    // Method to return current record count
    public static int getRecordCount() {
        return recordIndex;
    }
}