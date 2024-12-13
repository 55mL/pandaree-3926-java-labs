package somnueknaitham.pandaree.lab3;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int min, max, maxOfTries;

        // Section 1: Validate min and max values
        while (true) {
            System.out.print("Enter the min value: ");
            min = scanner.nextInt();

            System.out.print("Enter the max value: ");
            max = scanner.nextInt();

            if (min <= max) {
                break;
            } else {
                System.err.println("The max value must be at least equal to the min value.");
            }
        }

        // Section 2: Validate maximum number of tries
        while (true) {
            System.out.print("Enter the maximum number of tries: ");
            maxOfTries = scanner.nextInt();

            if (maxOfTries > 0) {
                break;
            } else {
                System.err.println("The maximum number of tries must be greater than 0.");
            }
        }

        // Welcome message
        System.out.println("Welcome to the number guessing game!");

        int answer = min + (int) (Math.random() * (max - min + 1));
        int numTries = 0;

        // Game loop
        while (numTries < maxOfTries) {
            System.out.print("Enter an integer between " + min + " and " + max + ": ");
            int guess = scanner.nextInt();

            if (guess < min || guess > max) {
                System.err.println("The number must be between " + min + " and " + max + ".");
                continue; // Skip incrementing the number of tries
            }

            numTries++;

            if (guess == answer) {
                System.out.println("Congratulations! You guessed correctly.");
                System.out.println("You have tried " + numTries + (numTries == 1 ? " time." : " times."));
                break;
            } else if (guess < answer) {
                System.out.println("Try a higher number!");
            } else {
                System.out.println("Try a lower number!");
            }

            if (numTries == maxOfTries) {
                System.out.println("You have tried " + numTries + " times. You ran out of guesses.");
                System.out.println("The answer is " + answer + ".");
            }
        }

        scanner.close();
    }
}
