/**
* The Dealer Program
* This program accepts three arguments then processes and displays dealer information.
* The output should be
* Dealer's name : <dealer_name>.
* Number of clients : <num_clients>
* Gender : <dealer_gender>
* 
* Author : Pandaree Somnueknaitham
* ID : 673040392-6
* Sec : 2
* Last update : 6 dec 2024
*/

package somnueknaitham.pandaree.lab2;

public class Dealer {
    public static void main(String[] args) {

        if (args.length != 3) {
            System.err.println("Error: Invalid number of arguments. Please provide exacly three arguments.");
            // output when inputs not contain three arguments.
        } 

        String a1 = args[0]; // set argument1 to a1
        System.out.println("Dealer's Name: " + a1); // output 1st line

        long a2 = Long.parseLong(args[1]); // set argument2 to a2
        System.out.println("Number of clients: " + a2); // output 2nd line

        String a3 = args[2]; // set argument3 to a3
        System.out.println("Gender: " + a3); // output 3rd line

    }

}
