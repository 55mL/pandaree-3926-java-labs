/*
 * Author : Pandaree Somnueknaitham
 * Student ID : 673040392-6
 * Section : 2
 * 
 * The MatrixOperations Program
 * This program has two main phase.
 * 1.Matrix Creation that can create matrix with 5 options.
 *  1. Manual Input
 *  2. Random Numbers
 *  3. All Zeros
 *  4. All Ones
 *  5. Diagonal Matrix
 * 2.Matrix Operations that can perform the operations.
 *  1. Transpose Matrix
 *  2. Calculate Sums
 *  3. Find Min/Max Elements
 *  4. Display Diagonal
 * 
 *  * Last update : 27 dec 2024
 */
package somnueknaitham.pandaree.lab5;

import java.util.Random;
import java.util.Scanner;

public class MatrixOperations {
    private static int[][] matrix; // declare matrix
    private static int rows; // set rows as int
    private static int columns; // set columns as int
    private static final Scanner scanner = new Scanner(System.in); // create scanner

    public static void main(String[] args) {

        boolean continueProgram = true;

        while (continueProgram) {
            displayCreationMenu(); // call method for create matrix
            int choice = scanner.nextInt();

            // choice is 1. to 4.
            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter number of rows: "); // ask user to input rows
                rows = scanner.nextInt();
                System.out.print("Enter number of columns: "); // ask user to input columns
                columns = scanner.nextInt();

                // Display errors
                if (rows <= 0 || columns <= 0) {
                    System.out.println("Error: Dimensions must be greater than 0");
                    continue;
                }
                
                // create matrix
                matrix = new int[rows][columns];
                createMatrix(choice);
            } else if (choice == 5) { // choice is 5.
                System.out.print("Enter size of square matrix: "); // ask user to enter size
                rows = columns = scanner.nextInt();

                // display errors
                if (rows <= 0) {
                    System.out.println("Error: Size must be greater than 0");
                    continue;
                }

                // create diagonal matrix
                matrix = new int[rows][rows];
                createDiagonalMatrix();
            } else { // else display errors
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            // displays created matrix
            System.out.println("\nCreated Matrix:");
            displayMatrix(matrix);

            boolean continueOperations = true;

            // displays operations menu
            while (continueOperations) {
                displayOperationsMenu();
                int operation = scanner.nextInt(); // get input

                switch (operation) {
                    case 1:
                        transposeMatrix(); // call transpose matrix method
                        break;
                    case 2:
                        calculateSums(); // call calculate sum method
                        break;
                    case 3:
                        findMinMax(); // call find min and max method
                        break;
                    case 4:
                        displayDiagonal(); // call display diagonal method
                        break;
                    case 5:
                        continueOperations = false; // exit operations loop
                        continueProgram = false; // exit main loop
                        break;
                    default:
                        System.out.println("Invalid operation choice."); // else display errors
                }
            }
        }

        scanner.close(); // close a scanner
    }

    // method to display creation menu
    private static void displayCreationMenu() {
        System.out.println("Matrix Creation Menu:");
        System.out.println("1. User Input Matrix");
        System.out.println("2. Random Matrix (0-9)");
        System.out.println("3. All Zeros Matrix");
        System.out.println("4. All Ones Matrix");
        System.out.println("5. Diagonal Matrix");
        System.out.print("Enter your choice: ");
    }

    // method to create matrix
    private static void createMatrix(int choice) {
        switch (choice) {
            // create matrix with user input
            case 1:
                System.out.println("Enter matrix elements:");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        matrix[i][j] = scanner.nextInt();
                    }
                }
                break;
            // create matrix with 0-9 random numbers
            case 2:
                Random random = new Random();
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        matrix[i][j] = random.nextInt(10);
                    }
                }
                break;
            // create matrix with only zero
            case 3:
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        matrix[i][j] = 0;
                    }
                }
                break;
            // create matrix with only one
            case 4:
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        matrix[i][j] = 1;
                    }
                }
                break;
        }
    }

    // method to create a diagonal matrix
    private static void createDiagonalMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // method to display matrix
    private static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.print("  "); 
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    

    // method to display operations menu
    private static void displayOperationsMenu() {
        System.out.println("\nMatrix Operations Menu:");
        System.out.println("1. Find Transpose of the Matrix");
        System.out.println("2. Calculate Sum of Rows and Columns");
        System.out.println("3. Find Minimum and Maximum Elements");
        System.out.println("4. Display Diagonal Elements");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    // method to transpose matrix
    private static void transposeMatrix() {
        System.out.println("\nTransposed Matrix:"); 
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
    }

    // method to calculate sum of each row and column
    private static void calculateSums() {
        System.out.println("\nRow sums:");
        for (int i = 0; i < rows; i++) {
            int sum = 0;
            for (int j = 0; j < columns; j++) {
                sum += matrix[i][j];
            }
            System.out.println("Row " + (i + 1) + " sum: " + sum);
        }

        System.out.println("\nColumn sums:");
        for (int i = 0; i < columns; i++) {
            int sum = 0;
            for (int j = 0; j < rows; j++) {
                sum += matrix[j][i];
            }
            System.out.println("Column " + (i + 1) + " sum: " + sum);
        }
    }

    // method to find min and max in matrix
    private static void findMinMax() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int[] row : matrix) {
            for (int element : row) {
                if (element < min) {
                    min = element;
                }
                if (element > max) {
                    max = element;
                }
            }
        }

        // display minimum and maximum
        System.out.println("\nMinimum element: " + min);
        System.out.println("Maximum element: " + max);
    }

    // mathod to display diagonal
    private static void displayDiagonal() {
        if (rows != columns) {
            System.out.println("Matrix is not square. Cannot display diagonal elements.");
            return; // exit loop when matrix is not square
        }

        // display diagonal element
        System.out.println("\nDiagonal elements:");
        for (int i = 0; i < rows; i++) {
            System.out.print("  ");
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
    }
}
