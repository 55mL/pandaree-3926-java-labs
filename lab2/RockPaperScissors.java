/**
 * Name : Pandaree Somnueknaitham
 * ID : 673040392-6
 * Sec : 2
 * 
 * The RockPaperScissors Program :
 * This program accepts two arguments which are each choice of player then processes and displays output.
 * The output should be
 * Player 1 chooses: < >
 * Player 2 chooses: < >
 * Player <1 or 2> wins! or "It's a tie!"
 * Last Update : 6 dec 2024
 */

package somnueknaitham.pandaree.lab2;

public class RockPaperScissors {
    
    public enum Choice {
        ROCK, PAPER, SCISSORS;
    }
    /**
     * @param x
     */
    public static void main(String[] x) {


        if (x.length != 2) {
            System.err.println("Error: Invalid number of arguments. Please provide exactly two arguments.");
            // output error when inputs not contain two arguments.
            return;
        } 

        String choice_1 = x[0]; // set argument1 to choice_1 
        System.out.println("Player 1 chooses: " + choice_1); // output 1st line

        String choice_2 = x[1]; // set argument2 to choice_2
        System.out.println("Player 2 chooses: " + choice_2); // output 2nd line
        
        choice_1 = choice_1.toUpperCase(); // convert choice_1 to all uppercase
        choice_2 = choice_2.toUpperCase(); // convert choice_2 to all uppercase

        Choice case_choice1 = null; // set case_choice1
        Choice case_choice2 = null; // set case_choice2

        try {
            case_choice1 = Choice.valueOf(choice_1); // convert choice_1 to enum
            case_choice2 = Choice.valueOf(choice_2); // cinvert choice_2 to enum
        } catch (IllegalArgumentException e) {
            System.err.println("Error: Invalid choice(s). Valid choices are 'rock', 'paper', or 'scissors'. ");
            // output error when input not in condition.
            return ;
        }
        

        if (case_choice1 == case_choice2) {
            System.out.println("It's a tie!"); // output 3rd line when 2 players tie
        } else if 
         ( (case_choice1 == Choice.PAPER && case_choice2 == Choice.ROCK) || 
           (case_choice1 == Choice.SCISSORS && case_choice2 == Choice.PAPER) ||
           (case_choice1== Choice.ROCK && case_choice2 == Choice.SCISSORS))
         {
            System.out.println("Player 1 wins!"); // output 3rd line when player 1 wins
        } else {
            System.out.println("Player 2 wins!"); // output 3rd line when player 2 wins
        }

    }
}
