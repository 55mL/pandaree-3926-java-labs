/*
 * Author : Pandaree Somnueknaitham
 * Section : 2
 * Student ID : 673040392-6
 * 
 * The MobileDeviceV12 program
 *  This program extends MobileDeviceV11 to action events from device, brand, and price text fields.
 * 
 * Last update : 9 Mar 2025
 */
package somnueknaitham.pandaree.lab12;

import javax.swing.*;
import java.awt.event.*;

import somnueknaitham.pandaree.lab10.MobileDeviceV11;

public class MobileDeviceV12 extends MobileDeviceV11 {
    // Convert text to number
    protected double price ; 

    // Constructor
    public MobileDeviceV12(String title){
        super(title);
    }

    // Method to handle action events
    public void actionPerformed(ActionEvent e){
        super.actionPerformed(e);
        Object srcObject = e.getSource();
        // If user enters device name
        if (srcObject == deviceNameTextField) {
            deviceNameTextField.setName("Device Name");
            handleNormalTextField(deviceNameTextField, brandTextField);

        }
        // If user enters brand name
        else if (srcObject == brandTextField) {
            brandTextField.setName("Brand");
            handleNormalTextField(brandTextField, priceTextField);
        }
        // If the user enters price
        else if (srcObject == priceTextField){
            priceTextField.setName("Price");
            handlePosNumTextField(priceTextField, systemChoice);
        }

    }

    // Method to handle normal text fields
    public void handleNormalTextField(JTextField tf, JComponent nextComponent){
        tf.requestFocusInWindow();
        // Check if the text field is empty
        if (tf.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter some data in " + tf.getName());
            nextComponent.setEnabled(false);  // Disable the next input field
        } 
        // If the text field is not empty
        else if (!tf.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, tf.getName() +  " is changed to " + tf.getText());
            nextComponent.setEnabled(true); // Enable the next input field
        } 
    }

    // Method to handle price text field 
    public void handlePosNumTextField(JTextField tf, JComponent nextComponent){
        tf.requestFocusInWindow();
        nextComponent.setEnabled(false);
        // Check if the text field is empty
        if (tf.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter some data in " + tf.getName());
        }
        else if (!tf.getText().isEmpty()) {
            try {
                // Convert text to number
                price = Double.parseDouble(tf.getText());
                // Check if the number is negative
                if (price < 0) {
                    JOptionPane.showMessageDialog(this, tf.getName() + " must be a positive number", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, tf.getName() + " is changed to " + price);
                }
            } 
            // Check if number does not a number
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number in " + tf.getName());
            }
        }
    }

    // Method to setup and display the GUI
    public void addListeners() {
        super.addListeners();
        deviceNameTextField.addActionListener(this);
        brandTextField.addActionListener(this);
        priceTextField.addActionListener(this);
    }

    // Method to setup and display the GUI
    public static void createAndShowGUI() {
        MobileDeviceV12 mdv12 = new MobileDeviceV12("Mobile Device V12");
        mdv12.createButton(); // Create buttons
        mdv12.createFormPanel(); // Create form panel
        mdv12.addMenus(); // Add menus
        mdv12.addComponents(); // Add components
        mdv12.addListeners();  // Add listeners
        mdv12.setFrameFeatures(); // Set frame features
    }

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); // call createAndShowGUI method
            }
        });
    }

}
