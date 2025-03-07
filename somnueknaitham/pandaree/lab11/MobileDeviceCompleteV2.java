/*
 * Author : Pandaree Somnueknaitham
 * Section : 2
 * Student ID : 673040392-6
 *  
 * The MobileDeviceCompleteV2 program
 *  This program extends MobileDeviceComplete program and implements ActionListener.
 *  To add listener for text fields (Device name, Brand, Price) when user presses Enter
 *  and display notification message dialog.
 * 
 * Last update : 7 Mar 2025
 */
package somnueknaitham.pandaree.lab11;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.awt.event.*;

public class MobileDeviceCompleteV2 extends MobileDeviceComplete implements ActionListener {

    // COnstructor
    public MobileDeviceCompleteV2(String title) {
        super(title);
    }

    // Method to handle action event of text field
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the source of the event
        Object srcObject = e.getSource();

        // Check if the event came from the deviceNameField
        if (srcObject == deviceNameField) {
            String deviceName = deviceNameField.getText(); // Get the text from the device name field
            JOptionPane.showMessageDialog(this, "You pressed Enter in Device Name field: " + deviceName, "Notification", JOptionPane.INFORMATION_MESSAGE); // Show a message dialog with the entered device name
            // Check if the event came from the brandField
        } else if (srcObject == brandField) {
            String brandName = brandField.getText(); // Get the text from the brand field
            JOptionPane.showMessageDialog(this, "Brand field says: " + brandName, "Notification", JOptionPane.INFORMATION_MESSAGE); // Show a message dialog with the entered brand name

            // Check if the event came from the priceField
        } else if (srcObject == priceField) {
            String priceName = priceField.getText(); // Get the text from the price field
            JOptionPane.showMessageDialog(this, "Price entered: " + priceName, "Notification", JOptionPane.INFORMATION_MESSAGE); // Show a message dialog with the entered price
        }

    }

    // Method to add listeners
    public void addListeners() {
        deviceNameField.addActionListener(this); // Add action listener to device name's text field
        brandField.addActionListener(this); // Add action listener to brand's text field
        priceField.addActionListener(this); // Add action listener to price's text field
    }

    // Method to setup and show GUI
    public static void createAndShowGUI() {
        MobileDeviceCompleteV2 window = new MobileDeviceCompleteV2("Mobile Device Complete V2");
        window.addComponents(); // Add components
        window.addMenus(); // Add menus
        window.addListeners(); // Add listeners
        window.setFrameFeatures(); // Setup frame features
    }

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater((new Runnable() {
            public void run() {
                createAndShowGUI(); // call createAndShowGUI method
            }
        }));
    }

}
