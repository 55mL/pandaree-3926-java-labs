/**
 * Name : Pandaree Somnueknaitham
 * ID : 673040392-6
 * Sec : 2
 * 
 * The SimpleStringManipulator Program :
 * This program accepts two arguments then processes and displays output.
 * The output should be :
 * First String: <string1>
 * Second String: <string2>
 * Resulting String: <string1string2_with_conditions>
 * 
 * Last Update : 6 dec 2024
 */

package somnueknaitham.pandaree.lab2;

public class SimpleStringManipulator {
    public static boolean Vowel(char c) { 
        return "aeiouAEIOU".indexOf(c) != -1;
        // check if character is a vowel (upper and lower)
    }
    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.println("Error: Invalid number of arguments. Please provide exactly two strings as arguments."); 
            // output when inputs not contain two arguments.
            return;
        }

        String string1 = args[0]; // set argument1 to string
        System.out.println("First String:" + string1); // output 1st line

        String string2 = args[1]; // set argument2 to string
        System.out.println("Second String:" + string2); // output 2nd line


        char char1 = string1.charAt(0);
        if (Vowel(char1)) { // if first letter is a vowel
            string1 = Character.toUpperCase(char1) + string1.substring(1);
            // convert first character to upper
        } else {
            string1 = Character.toLowerCase(char1) + string2.substring(1);
            // convert first character to lower
        }

        char lastChar = string2.charAt(string2.length() - 1);
        if (!Vowel(lastChar)) { // if last letter is not a vowel
            string2 = string2.substring(0, string2.length() - 1) + Character.toUpperCase(lastChar);
            // convert last character to upper
        } else {
            string2 = string2.substring(0, string2.length() - 1) + Character.toLowerCase(lastChar);
            // convert last character to lower
        }


        System.out.println("Resulting String: " + string1 +string2);
        // output 3rd line
    }
}
