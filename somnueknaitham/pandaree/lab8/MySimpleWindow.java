/*
 * Author : Pandaree Somnuekanitham
 * Section : 2
 * Student ID : 673040392-6
 * 
 * The MySimpleWindow program
 *  This class is the base class for all other programs that implement JFrame, 
 *  including constructor, createButton, addComponents, setFrameFeatures, and createAndShowGUI methods.
 * 
 * Last update : 7 Feb 2025
 */
package somnueknaitham.pandaree.lab8;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MySimpleWindow extends JFrame {
    // Declare variables
    protected JButton resetButton, submitButton;
    protected String resetString, submitString;
    protected JPanel mainPanel, buttonPanel;

    // Constructor method to call parents method
    public MySimpleWindow(String title) {
        super(title);
    }

    // Method to create buttons and button panel
    protected void createButton(){
        // Create buttons and panel
        buttonPanel = new JPanel();
        resetButton = new JButton("Cancel");
        submitButton = new JButton("OK");

        // Add buttons to button panel
        buttonPanel.add(resetButton);
        buttonPanel.add(submitButton);
    }

    // Method to add component to main
    protected void addComponents(){
        // Add button panel to main panel
        mainPanel = new JPanel();
        mainPanel.add(buttonPanel);
        setContentPane(mainPanel);
    }

    // Method to set window frame
    protected void setFrameFeatures(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // set window to close when exit
        this.pack(); // size the window appropriately
        this.setVisible(true); // make the window visible
        this.setLocationRelativeTo(null); // set screen to center

    }

    // Method to show GUI
    public static void createAndShowGUI(){
        MySimpleWindow msw = new MySimpleWindow("My Simple Window");
        msw.createButton(); // call createButton method
        msw.addComponents(); // Call addComponent method
        msw.setFrameFeatures(); // Call setFrameFeatures method
    }

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); // Call createAndShowGUI method
            }
        });
    }
}
