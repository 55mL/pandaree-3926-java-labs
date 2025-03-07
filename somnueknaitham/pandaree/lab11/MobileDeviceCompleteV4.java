/*
 * Author : Pandaree Somnueknaitham
 * Section : 2
 * Student ID : 673040392-6
 *
 * The MobileDeviceCompleteV4 program
 *  This program extends MobileDeviceCompleteV3 program and implements JColorChooser
 *  to change the text color of the text fields.
 *
 * Last update : 7 Mar 2025
 */
package somnueknaitham.pandaree.lab11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MobileDeviceCompleteV4 extends MobileDeviceCompleteV3 {
    // Declare variables
    protected JMenu configMenu, colorMenu;
    protected JMenuItem customItem;
    protected Color selectedColor;

    // Constructor
    public MobileDeviceCompleteV4(String title) {
        super(title);
    }

    // Override addMenus method to add the "Config" and "Color" menus
    @Override
    protected void addMenus() {
        super.addMenus();
        // Create menus and menu item
        configMenu = new JMenu("Config");
        colorMenu = new JMenu("Color");
        customItem = new JMenuItem("Custom");
        // Add menus and menu item to menu bar
        colorMenu.add(customItem);
        configMenu.add(colorMenu);
        menuBar.add(configMenu); 
    }

    // Method to implement ActionListener to custom menu item
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == customItem) {
            Color newColor = JColorChooser.showDialog(this, "Choose Text Color", selectedColor);
            if (newColor != null) {
                selectedColor = newColor;
                // Change texts' color of the text fields
                deviceNameField.setForeground(selectedColor);
                brandField.setForeground(selectedColor);
                priceField.setForeground(selectedColor);
            }
        }
    }

    // Method to add listeners
    public void addListeners(){
        super.addListeners();
        customItem.addActionListener(this);
    }

    // Method to setup and show GUI
    public static void createAndShowGUI() {
        MobileDeviceCompleteV4 window = new MobileDeviceCompleteV4("Mobile Device Complete V4");
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