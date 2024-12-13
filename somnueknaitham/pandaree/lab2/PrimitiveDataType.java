/**
 * Name : Pandaree Somnueknaitham
 * ID : 673040392-6
 * Sec : 2
 * 
 * The PrimitiveDataType Program :
 * This program accepts two arguments then processes and displays output.
 * The output should be
 * Student ID : <my_student_ID>
 * First Name : <first_name>
 * Byte Value : <num_letters_first_name>
 * Short Value : <byte_value*21>
 * Int Value : <last_six_digits_student_ID>
 * Long Value : <student_ID_without_dash>
 * FLoat Value : <0.xx>   
 * Double Value : <0.yyyy>  
 * Char Value : <first_letter_of_first_name>
 * Boolean Value : <checks_last_digit_student_ID>
 * 
 * Last Update : 6 dec 2024
 */

package somnueknaitham.pandaree.lab2;

public class PrimitiveDataType {
    public static void main(String[] x) {

        String studentNumber = x[0]; // set argument1 to studentNumber
        System.out.println("Student ID : " + studentNumber); // output 1st line

        String firstName = x[1]; // set argument2 to firstName
        System.out.println("First Name : " + firstName ); // output 2nd line
        
        byte myByte = (byte)(firstName.length()); // set myByte to first name length
        System.out.println("Byte Value : " + myByte ); // output 3rd line

        short myShort = (short) (myByte * 21); // set myShort as myByte multiple 21
        System.out.println( "Short Value : " + myShort ); // output 4th line

        int myInt = Integer.parseInt(studentNumber.replace("-","").substring(5)); // parse last six digits of the student ID to myInt
        System.out.println("Int Value : " + myInt); // output 5th line

        long myLong = Long.parseLong(studentNumber.replace("-", "")); // parse student ID without dash to myLong
        System.out.println("Long Value : " + myLong); // output 6th line
        
        float myFloat = (float) (myByte%10) /100 ; //set myFloat to 0.xx when xx is myByte
        System.out.println("Float Value : " + myFloat); // output 7th line

        double myDouble = 0.0001 * (myInt % 10000); // set myDouble to 0.yyyy when yyyy is last four digits of myInt
        System.out.println("Double Value : " + myDouble ); // output 8th line

        char myChar = firstName.charAt(0); // set myChar to first letter of first name
        System.out.println("Char Value : " + myChar ); // output 9th line

        boolean myBoolean = myLong % 2 != 0; // output true if the last digit of student ID is odd
        System.out.println("Boolean Value : " + myBoolean ); // output 10th line

    }
}
