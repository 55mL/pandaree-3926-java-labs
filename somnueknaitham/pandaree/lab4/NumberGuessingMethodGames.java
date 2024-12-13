package somnueknaitham.pandaree.lab4;

import java.util.Scanner;

public class NumberGuessingMethodGames {
    static Scanner scanner = new Scanner(System.in);
    static int min, max, max_of_tries, answer;
    static String choice;

    static void configure() {

        while (true) {
            System.out.print("Enter the min value : ");
            min = scanner.nextInt();

            System.out.print("Enter the max value : ");
            max = scanner.nextInt();

            if ( min <= max ) {
                break;
            } else {
                System.err.println("The max value must be at least equal to the min value");
            }
        }
        while (true) {
            
            System.out.print("Enter the maximum number of tries : ");
            max_of_tries = scanner.nextInt();
                
            if (max_of_tries>0) {
                break;
            } else {
                System.err.println("The maximum number of tries must be greater than 0");
            }
        }

        

    }

    static void genAnswer() {
        answer = min + (int)(Math.random()*((max-min)+1));
    }

    static void playGame() {
        
        
                
                                    
                genAnswer();
                System.out.println("Welcome to a number guessing game!");
        
                int num_try = 1;
                        
                while ( num_try <= max_of_tries ) {
                    System.out.print("Enter an integer between " + min + " and " + max + " : ");
                    int num = scanner.nextInt();
        
                    if (num < min || num > max) {
                        System.err.println("The  number must be between " + min + " and " + max);
                        continue ;
                    }
                    if ( num == answer ) {
                        System.out.println("Congratulations!"); // output when win
                        if ( num_try == 1) {
                            System.out.println("You have tried " + num_try + " time."); // output number of try when win
                            break ;
                        } else {
                            System.out.println("You have tried " + num_try + " times."); // output number of try when win
                            break ;
                        }
                    } else if (num != answer) {
                        if (num < answer) {
                            System.out.println("Try a higher number!"); // output when the input number less than an answer
                        } else if (num > answer){
                            System.out.println("Try a lower number!"); // output when the input number more than an answer
                        }
                    
                        if ( num_try == max_of_tries) {
                            System.out.print("You have tried " + num_try + " times."); // output  number of try when try 5 times
                            System.out.println(" You ran out of guesses."); // output when try 5 times
                            System.out.println("The answer is "+ answer + "."); // output answer when try 5 times
                        }  
                    
                    }
                    num_try += 1;
                }
            
                
                
    }

    static void playGames() {
        do {
            playGame();
            System.out.print("Want to play again (Y or y) : ");
            choice = scanner.next();
        } while ( choice.equalsIgnoreCase("y"));
        System.out.println("Thank you for playing our games.  Bye!");
        
    }

    public static void main(String[] args) {
        configure();
        playGames();
    }

    
}
