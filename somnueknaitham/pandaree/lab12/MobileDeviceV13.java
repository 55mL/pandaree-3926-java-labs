/*
 * Author : Pandaree Somnueknaitham
 * Section : 2
 * Student ID : 673040392-6
 * 
 * The MobileDeviceV13 program
 *  This program extends MobileDeviceV12 to add more two action events.
 *  1. Display message when user clicks Add button.
 *  2. Display list of mobile devices when user clicks Display button.
 * 
 * Last update : 14 Mar 2025
 */
package somnueknaitham.pandaree.lab12;

import javax.swing.*;

import somnueknaitham.pandaree.lab7.MobileDevice;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MobileDeviceV13 extends MobileDeviceV12 {

    // Declare variables
    protected JButton addButton, displayButton;
    protected ArrayList<MobileDevice> deviceList = new ArrayList<MobileDevice>();
    MobileDevice device;
    
    // Constructor
    public MobileDeviceV13 (String title) {
        super(title);
    }

    // Method to create buttons
    protected void createButton() {
        super.createButton();
        addButton = new JButton("Add");
        displayButton = new JButton("Display");

        // Add buttons to button panel
        buttonPanel.add(addButton);
        buttonPanel.add(displayButton);
    }

    // Method to add component to main
    protected void addComponents(){
        super.addComponents();
        // Add button panel to main panel
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        setContentPane(mainPanel);
    }

    // Method to handle action events
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        // When user click add button
        if (src == addButton) {
            handleAddButton();
        } 
        // When user click display button
        else if (src == displayButton) {
            handleDisplayButton();
        } else {
            super.actionPerformed(e);
        }
    }

    // Method to display pattern message when click add button
    public void handleAddButton() {
        price = Double.parseDouble(priceTextField.getText());
        // If type is smartphone
        if (smartphoneRButton.isSelected() == true ) {
            device = new SmartPhone( deviceNameTextField.getText(), brandTextField.getText(), price);
            JOptionPane.showMessageDialog(this, smartphoneRButton.getText() + " " + deviceNameTextField.getText() + " is added" );
        } 
        // If type is tablet
        else if (tabletRButton.isSelected() == true) {
            device = new Tablet( deviceNameTextField.getText(), brandTextField.getText(), price);
            JOptionPane.showMessageDialog(this, tabletRButton.getText() + " " + deviceNameTextField.getText() + " is added" );
        }
        // Add device to device list
        deviceList.add(device);
    }

    // Method to display list when click display button
    public void handleDisplayButton() {
        StringBuilder message = new StringBuilder();
        // Add each one to list
        for (MobileDevice device : deviceList) {
            message.append(device.toString()).append("\n");
        }
        // Display list dialog
        JOptionPane.showMessageDialog(this, message);
    }

    // Method to add action listener
    public void addListeners() {
        super.addListeners();
        addButton.addActionListener(this);
        displayButton.addActionListener(this);
    }

    // Method to setup and display the GUI
    public static void createAndShowGUI() {
        MobileDeviceV13 mdv13 = new MobileDeviceV13("Mobile Device V13");
        mdv13.createButton(); // Create buttons
        mdv13.createFormPanel(); // Create form panel
        mdv13.addMenus(); // Add menus
        mdv13.addComponents(); // Add components
        mdv13.addListeners();  // Add listeners
        mdv13.setFrameFeatures(); // Set frame features
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
