/*
 * Author : Pandaree Somnueknaitham
 * Section : 2
 * Student ID : 673040392-6
 * 
 * The MobileDeviceV10 program
 *  This class extends the MobileDeviceV9 program and implements ListSelectionListener and ChangeListener.
 *  To add more 3 Listeners
 *  1. Using ActionListener to handle Operating system's value changing.
 *  2. Using ListSelectionListener to handle Device's vendor changing.
 *  3. Using ChangeListener to handle Rating's value changing.
 * 
 * Last update : 7 Mar 2025
 */
package somnueknaitham.pandaree.lab10;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MobileDeviceV10 extends MobileDeviceV9 implements ListSelectionListener, ChangeListener {

    // Constructor
    public MobileDeviceV10(String title) {
        super(title);
    }

    // Method to listen for action events
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        // Check if the source is the system choice
        if (e.getSource() == systemChoice) {
            osInput = systemChoice.getSelectedItem().toString(); // Get selected OS
            JOptionPane.showMessageDialog(this, "You selected Operating System: " + osInput); // Show message dialog
        }
    }

    // Method to handle selection event from vendor list
    @Override
    public void valueChanged(ListSelectionEvent e) {
    // Check if vendor selection is not adjusting
    if (!e.getValueIsAdjusting()) {
        vendorInput = vendorList.getSelectedValuesList().toString().replaceAll("[\\[\\]]", "");
        // If there are selected vendors
        if (!vendorInput.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Device is available at: " +  vendorInput ); // Show message with selected vendors
            }
        }
    }

    // Method to handle changes in the rate slider
    @Override
    public void stateChanged(ChangeEvent e) {
        // If source is not the rate slider
        if (e.getSource() != rateSlider)
            return;

        // Check if rate slider is not adjusting
        if (!rateSlider.getValueIsAdjusting()) {
            ratesInput = rateSlider.getValue(); // Get selected rating value
            JOptionPane.showMessageDialog(this, "New rating: " + ratesInput); // Show message dialog
        }
    }

    // Add a Listeners
    public void addListeners() {
        super.addListeners();
        systemChoice.addActionListener(this); // Add action listener to system choice
        vendorList.addListSelectionListener(this); // Add selection listener to vendor list
        rateSlider.addChangeListener(this); // Add change listener to rate slider
    }

    // Method to setup and display the GUI
    public static void createAndShowGUI() {
        MobileDeviceV10 mdv10 = new MobileDeviceV10("Mobile Device V10");
        mdv10.createButton(); // Create buttons
        mdv10.createFormPanel(); // Create form panel
        mdv10.addMenus(); // Add menus
        mdv10.addComponents(); // Add components
        mdv10.addListeners(); // Add listeners
        mdv10.setFrameFeatures(); // Set frame features
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
