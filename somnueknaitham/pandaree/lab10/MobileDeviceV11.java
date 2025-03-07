/*
 * Author : Pandaree Somnueknaitham
 * Section : 2
 * Student ID : 673040392-6
 * 
 * The MobileDeviceV11 program
 *  This class extends the MobileDeviceV10 program and implements ItemListener.
 *  Add more 2 function.
 *  1. Use ItemListener to handle selection from radio button.
 *  2. Add the mnemonic keys and accelerator keys for menu item including New, Open, Save, and Exit.
 * 
 * Last update : 7 Mar 2025
 */
package somnueknaitham.pandaree.lab10;

import java.awt.event.*;
import javax.swing.*;

public class MobileDeviceV11 extends MobileDeviceV10 implements ItemListener {

    // Constructor
    public MobileDeviceV11(String title) {
        super(title);
    }

    // Method to handle item state changes for radio buttons
    public void itemStateChanged(ItemEvent e) {
        // Check if the radio button was selected
        if (e.getStateChange() == ItemEvent.SELECTED) {
            // Get source
            Object rButtonSource = e.getSource();
            // If select smartphone radio button
            if (rButtonSource == smartphoneRButton) {
                JOptionPane.showMessageDialog(this, "Smartphone is selected"); // Display a message
            } 
            // If select tablet radio button
            else if (rButtonSource == tabletRButton) {
                JOptionPane.showMessageDialog(this, "Tablet is selected"); // Display a message 
            }
        }
    }

    // Add mnemonics and accelerators to menu items
    protected void addMenus() {
        super.addMenus();

        //Add mnemonic keys (when the user already clicks menu File)
        newItem.setMnemonic(KeyEvent.VK_N); // Type N instead of click new menu item
        openItem.setMnemonic(KeyEvent.VK_O); // Type O instead of click open menu item
        saveItem.setMnemonic(KeyEvent.VK_S); // Type S instead of click save menu item
        exitItem.setMnemonic(KeyEvent.VK_X); // Type X instead of click exit menu item

        // Add accelerator keys
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK)); // Ctrl + N instead of click new menu item
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK)); // Ctrl + O instead of click open menu item
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK)); // Ctrl + S instead of click save menu item
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK)); // Ctrl + X instead of click exit menu item
    }

    // Method to setup and display the GUI
    public void addListeners() {
        super.addListeners();
        smartphoneRButton.addItemListener(this); // Add item listener to smartphoneRButton
        tabletRButton.addItemListener(this); // Add item listener to tabletRButton
    }

    // Method to setup and display the GUI
    public static void createAndShowGUI() {
        MobileDeviceV11 mdv11 = new MobileDeviceV11("Mobile Device V11");
        mdv11.createButton(); // Create buttons
        mdv11.createFormPanel(); // Create form panel
        mdv11.addMenus(); // Add menus
        mdv11.addComponents(); // Add components
        mdv11.addListeners();  // Add listeners
        mdv11.setFrameFeatures(); // Set frame features
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