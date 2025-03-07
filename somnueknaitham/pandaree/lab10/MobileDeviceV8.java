/*
 * Author : Pandaree Somnueknaitham
 * Section : 2
 * Student ID : 673040392-6
 * 
 * The MobileDeviceV8 program
 *  This class extends the MobileDeviceV7 program and implements ActionListener.
 *  Including addListeners method to add actions listeners to ok and cancel button,
 *  overriding actionPerformed method to add more ok and cancel button function when it is clicked.
 * 
 * Last update : 7 Mar 2025
 */
package somnueknaitham.pandaree.lab10;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import somnueknaitham.pandaree.lab9.MobileDeviceV7;

public class MobileDeviceV8 extends MobileDeviceV7 implements ActionListener{
    // Declare variables
    protected String deviceInput, brandInput, priceInput, typeInput, osInput, featureInput, vendorInput;
    protected int ratesInput;
    protected Object srcObject;

    // Constructor method
    public MobileDeviceV8(String title){
        super(title);
    }

    // Method to handle action events
    public void actionPerformed(ActionEvent e){
        srcObject = e.getSource();
        // If click OK button, information dialog will be displayed.
        if (srcObject == submitButton){
            deviceInput = deviceNameTextField.getText(); // Get device name's text
            brandInput = brandTextField.getText(); // Get brand name's text
            priceInput = priceTextField.getText(); //Get price's text
            // Get type's text
            if (smartphoneRButton.isSelected()) {
                typeInput = smartphoneRButton.getText(); // If smartphone is clicked
            } else {
                typeInput = tabletRButton.getText(); // If radio is clicked
            }
            osInput = systemChoice.getSelectedItem().toString(); //
            featureInput = featureTextArea.getText();
            vendorInput = vendorList.getSelectedValuesList().toString().replaceAll("[\\[\\]]", "");
            ratesInput = rateSlider.getValue(); //
            // Information dialog pattern
            JOptionPane.showMessageDialog(this, "Device Name:" + deviceInput + 
            "\nBrand: " + brandInput +
            "\nPrice: " + priceInput +
            "\nType: " +  typeInput +
            "\nOperating System: " + osInput +
            "\nFeatures: " + featureInput +
            "\nAvailable at: " + vendorInput + 
            "\nRating: " + ratesInput);
        }

        // If click Cancel button, all input should be reset to empty and some are default values.
        if(srcObject == resetButton) {
            // Replace all input with empty string
            deviceNameTextField.setText("");
            brandTextField.setText("");
            priceTextField.setText("");
            smartphoneRButton.setSelected(true);
            systemChoice.setSelectedItem("Android");
            featureTextArea.setText("");
            vendorList.setSelectedIndex(0);
            rateSlider.setValue(5);
        }
    }

    // Add an ActionListener to the button
    public void addListeners(){
        submitButton.addActionListener(this); // Add listeners to OK button
        resetButton.addActionListener(this); // Add listeners to Cancel button
    }

    // Method to setup and display the GUI
    public static void createAndShowGUI(){
        MobileDeviceV8 mdv8 = new MobileDeviceV8("Mobile Device V8");
        mdv8.createButton(); // Create buttons
        mdv8.createFormPanel(); // Create form panel
        mdv8.addMenus(); // Add menus
        mdv8.addComponents(); // Add components
        mdv8.addListeners();  // Add listeners
        mdv8.setFrameFeatures();  // Set frame features
    }
    
    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                createAndShowGUI(); // call createAndShowGUI method
            }
        });
    }
}
