/*
 * Author : Pandaree Somnueknaitham
 * Student ID : 673040392-6
 * Section : 2
 * 
 * The NumberGuessingMethodGamesV3 Program
 * 
 * This program is a number guessing game that improve from NumberGuessingMethodGamesV3
 * The program add more 2 methods
 * 1. displayGameLog method  for summary one time game play
 * Game log:Answer: <answer>, Guesses: <guess>, Win: <boolean>
 * 
 * 2. displayAllGamesStats method for shows all games stats
 * ===== All Games Stats =====
 * Total games played: <total_games>
 * Total games win: <total_wins>
 * Win ratio: < xx.xx% >
 * Average number of guesses per game < >
 * High score (the lowest number of quesses): < >
 * 
 * Last update : 27 Dec 2024
 */
package somnueknaitham.pandaree.lab4;

import java.util.Scanner;
import java.util.Arrays;

public class NumberGuessingMethodGamesV3 {

    static Scanner scanner = new Scanner(System.in); // create a scanner
    static int min, max, max_of_tries, answer; // define integer variables
    static String choice; // define a string variable
    static int[] arr_guess = new int[10]; // store array 10 guesses
    static int num_guess; // define number of guesses

    // define variables to 0
    static int total_games = 0;
    static int total_wins = 0;
    static int total_guesses = 0;
    static int high_score = 0;

    // method for configure get min, max, number of tries from user
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
                System.err.println("The maximum number of tries must be greater than 0"); // display erors
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
        boolean win = false;

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
                win = true;
                total_wins++;

                // check if number of try equal to 1
                if (num_try == 0) {
                    System.out.println("You have tried " + (num_try + 1) + " time."); // display number of try
                    break; // exit loop
                } else {
                    System.out.println("You have tried " + (num_try + 1) + " times."); // display number of tries
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
                    System.out.print("You have tried " + (num_try + 1) + " times."); // display number of tries
                    System.out.println(" You ran out of guesses."); // display message
                    System.out.println("The answer is " + answer + "."); // display answer
                }

            }
            num_try++; // increse num_try by 1

            // set high score
            if (high_score < num_guess) {
                high_score = num_guess - 1;
            }
        }

        total_games++; // increase total_games by 1
        total_guesses += num_guess; // increase total_guesses by add num_guess
    }

    // method for displays all guesses
    static void displayGuesses() {
        for (int i = 0; i < num_guess; i++) {
            System.out.println("Guess " + (i + 1) + ": " + arr_guess[i]);
        }

    }

    // method for displays specific guess
    static void displayChooseGuesses(int n) {
        if (n > 0 && n <= num_guess) {
            System.out.println("Guess " + n + ": " + arr_guess[n - 1]);
        }

    }

    // method for ask and displays guess
    static void displayGuessesLoop() {
        while (true) {
            // ask user to input a(all guesses), g(specific guess), others(quit)
            System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any other key to quit: ");
            String list_choice = scanner.next();

            // if choice is a, call displayGuesses method
            if (list_choice.equalsIgnoreCase("a")) {
                displayGuesses();
            }
            // if choice is g, call displayChooseGuesses method
            else if (list_choice.equalsIgnoreCase("g")) {
                System.out.print("Enter the guess number: ");
                int num = scanner.nextInt();
                displayChooseGuesses(num);
            } else {
                break;
            }
        }
    }

    // method for displays summary one time game play
    static void displayGameLog() {
        System.out.println("Game Log:" + "Answer: " + answer + ", Guesses : " + num_guess + ", Win: " + (num_guess <= max_of_tries));
    }

    // method for displays all game stats
    static void displayAllGamesStats() {
        System.out.println("===== All Games Stats =====");
        System.out.println("Total games played: " + total_games);
        System.out.println("Total games win: " + total_wins);
        double winRatio = (total_wins * 100 / total_games);
        int averageGuess = total_guesses / total_games;
        System.out.println("Win ratio: " + winRatio + "%");
        System.out.println("Average guesses per game: " + averageGuess);
        System.out.println("High score (the lowest number of guesses): " + high_score);
    }

    // method that play multiple times
    static void playGames() {
        do {
            playGame(); // call playGame method
            displayGuessesLoop();
            displayGameLog();
            System.out.print("Want to play again (Y or y) : "); // ask user choice to play again
            choice = scanner.next(); // read input as choice
        } while (choice.equalsIgnoreCase("y")); // do loop when choice is 'y' or 'Y'
        System.out.println("Thank you for playing our games.  Bye!"); // display when choice is other
        displayAllGamesStats();
        scanner.close(); // close a scanner

    }

    // main method of the program
    public static void main(String[] args) {
        configure(); // call congfigure method
        playGames(); // call playGames method
    }
}
