/*
 * Author : Pandaree Somnueknaitham
 * Section : 2
 * Student ID : 673040392-6
 * 
 * The MobileDeviceV9 program
 *  This class extends the MobileDeviceV8 program and implements ActionListener.
 *  Overriding actionPerformed method to add new listeners when select the menu item,
 *  including New menu, Open menu, Save menu, Exit menu, Small menu, Medium menu, Large menu, Extra menu, 
 *  Black menu, Red menu, Green menu, Blue menu, Font1 menu, Font2 menu, and Font3 menu.
 * 
 * Last update : 7 Mar 2025
 */
package somnueknaitham.pandaree.lab10;

import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class MobileDeviceV9 extends MobileDeviceV8 {

    // Constructor
    public MobileDeviceV9 (String title) {
        super(title);
    }

    // Method to handle action events
    public void actionPerformed(ActionEvent e){
        super.actionPerformed(e);

        // If click New menu, all input should be reset to empty and some are default values.
        if (srcObject == newItem ) {
            deviceNameTextField.setText("");
            brandTextField.setText("");
            priceTextField.setText("");
            smartphoneRButton.setSelected(true);
            systemChoice.setSelectedItem("Android");
            featureTextArea.setText("");
            vendorList.setSelectedIndex(0);
            rateSlider.setValue(5);
        } 
        
        // If click Open menu
        else if (srcObject == openItem ) {
            JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(MobileDeviceV9.this); // Display a file chooser dialog and allow user to select a file
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile(); // Get selected file
                    JOptionPane.showMessageDialog(MobileDeviceV9.this, "Opening: " + selectedFile.getName()); // Display a dialog informing that the file has been opened. 
                }
        } 
        
        // If click Save menu
        else if (srcObject == saveItem ) {
            JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showSaveDialog(MobileDeviceV9.this); // Display a file chooser dialog allowing the user to select a file
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile(); // Get selected file
                    JOptionPane.showMessageDialog(MobileDeviceV9.this, "Data is saved to " + selectedFile.getName() + " successfully!", "Save",JOptionPane.INFORMATION_MESSAGE); // Display a dialog informing that the file has been saved.            
                }
        } 
        
        // If click Exit menu
        else if (srcObject == exitItem ) {
            System.exit(0); // CLose the program
        } 
        
        // If click Small menu
        else if (srcObject == smallItem ) {
            // Change font size to 10px for all the text fields and text area
            deviceNameTextField.setFont(new Font("Arial", Font.PLAIN, 10));
            brandTextField.setFont(new Font("Arial", Font.PLAIN, 10));
            priceTextField.setFont(new Font("Arial", Font.PLAIN, 10));
            featureTextArea.setFont(new Font("Arial", Font.PLAIN, 10));
        } 
        
        // If click Medium menu
        else if (srcObject == mediumItem ) {
            // Change font size to 14px for all the text fields and text area
            deviceNameTextField.setFont(new Font("Arial", Font.PLAIN, 14));
            brandTextField.setFont(new Font("Arial", Font.PLAIN, 14));
            priceTextField.setFont(new Font("Arial", Font.PLAIN, 14));
            featureTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        } 
        
        // If click Large menu
        else if (srcObject ==  largeItem) {
            // Change font size to 18px for all the text fields and text area
            deviceNameTextField.setFont(new Font("Arial", Font.PLAIN, 18));
            brandTextField.setFont(new Font("Arial", Font.PLAIN, 18));
            priceTextField.setFont(new Font("Arial", Font.PLAIN, 18));
            featureTextArea.setFont(new Font("Arial", Font.PLAIN, 18));
        } 
        
        // If click Extra menu
        else if (srcObject ==  extraItem) {
            // Change font size to 22px for all the text fields and text area
            deviceNameTextField.setFont(new Font("Arial", Font.PLAIN, 22));
            brandTextField.setFont(new Font("Arial", Font.PLAIN, 22));
            priceTextField.setFont(new Font("Arial", Font.PLAIN, 22));
            featureTextArea.setFont(new Font("Arial", Font.PLAIN, 22));
        } 
        
        // If click Black menu
        else if (srcObject ==  blackItem) {
            // Change the font color to BLACK for all the text fields and text area
            deviceNameTextField.setForeground(Color.BLACK);
            brandTextField.setForeground(Color.BLACK);
            priceTextField.setForeground(Color.BLACK);
            featureTextArea.setForeground(Color.BLACK);
        } 
        
        // If click Red menu
        else if (srcObject ==  redItem ) {
            // Change the font color to RED for all the text fields and text area
            deviceNameTextField.setForeground(Color.RED);
            brandTextField.setForeground(Color.RED);
            priceTextField.setForeground(Color.RED);
            featureTextArea.setForeground(Color.RED);
        } 
        
        // If click Green menu
        else if (srcObject ==  greenItem) {
            // Change the font color to GREEN for all the text fields and text area
            deviceNameTextField.setForeground(Color.GREEN);
            brandTextField.setForeground(Color.GREEN);
            priceTextField.setForeground(Color.GREEN);
            featureTextArea.setForeground(Color.GREEN);
        } 
        
        // If click Blue menu
        else if (srcObject ==  blueItem) {
            // Change the font color to BLUE for all the text fields and text area
            deviceNameTextField.setForeground(Color.BLUE);
            brandTextField.setForeground(Color.BLUE);
            priceTextField.setForeground(Color.BLUE);
            featureTextArea.setForeground(Color.BLUE);
        } 
        
        // If click Font1 menu
        else if (srcObject ==  font1Item ) {
            // Change the font to Serif for all the text fields and text area.
            deviceNameTextField.setFont(new Font("Serif", Font.PLAIN, 10));
            brandTextField.setFont(new Font("Serif", Font.PLAIN, 10));
            priceTextField.setFont(new Font("Serif", Font.PLAIN, 10));
            featureTextArea.setFont(new Font("Serif", Font.PLAIN, 10));
        } 
        
        // If click Font2 menu
        else if (srcObject == font2Item ) {
            // Change the font to SansSerif for all the text fields and text area.
            deviceNameTextField.setFont(new Font("SansSerif", Font.PLAIN, 10));
            brandTextField.setFont(new Font("SansSerif", Font.PLAIN, 10));
            priceTextField.setFont(new Font("SansSerif", Font.PLAIN, 10));
            featureTextArea.setFont(new Font("SansSerif", Font.PLAIN, 10));
        } 
        
        // If click Font3 menu
        else if (srcObject == font3Item ) {
            // Change the font to Monospaced for all the text fields and text area.
            deviceNameTextField.setFont(new Font("Monospaced", Font.PLAIN, 10));
            brandTextField.setFont(new Font("Monospaced", Font.PLAIN, 10));
            priceTextField.setFont(new Font("Monospaced", Font.PLAIN, 10));
            featureTextArea.setFont(new Font("Monospaced", Font.PLAIN, 10));
        }
    }

    // Add an ActionListener to all menu items
    public void addListeners(){
        super.addListeners();
        
        newItem.addActionListener(this); // Add listeners to New menu
        openItem.addActionListener(this); // Add listeners to Open menu
        saveItem.addActionListener(this); // Add listeners to Save menu
        exitItem.addActionListener(this); // Add listeners to new menu

        smallItem.addActionListener(this); // Add listeners to Small menu
        mediumItem.addActionListener(this); // Add listeners to Medium menu
        largeItem.addActionListener(this); // Add listeners to Large menu
        extraItem.addActionListener(this); // Add listeners to Extra menu

        blackItem.addActionListener(this); // Add listeners to Black menu
        redItem.addActionListener(this); // Add listeners to Red menu
        greenItem.addActionListener(this); // Add listeners to Green menu
        blueItem.addActionListener(this); // Add listeners to Blue menu

        font1Item.addActionListener(this); // Add listeners to Font1 menu
        font2Item.addActionListener(this); // Add listeners to Font2 menu
        font3Item.addActionListener(this); // Add listeners to Font3 menu
    }
    
    // Method to setup and display the GUI
    public static void createAndShowGUI(){
        MobileDeviceV9 mdv9 = new MobileDeviceV9("Mobile Device V9");
        mdv9.createButton(); // Create buttons
        mdv9.createFormPanel(); // Create form panel
        mdv9.addMenus(); // Add menus
        mdv9.addComponents(); // Add components
        mdv9.addListeners();  // Add listeners
        mdv9.setFrameFeatures();  // Set frame features
    }
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                createAndShowGUI(); // call createAndShowGUI method
            }
        });
    }
    
}
