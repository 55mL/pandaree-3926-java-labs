/*
 * Author : Pandaree Somnueknaitham
 * Section : 2
 * Student ID : 673040392-6
 * 
 * The MobileDeviceV15 program
 *  This program extends MobileDeviceV14 to add the ability to choose file format.
 *  It adds a Format menu with Text and Binary options.
 *  It can save and read objects in both text and binary formats.
 *  SmartPhone and Tablet classes are modified to implement Serializable.
 * Last update : 14 Mar 2025
 */
package somnueknaitham.pandaree.lab12;

import javax.swing.*;
import somnueknaitham.pandaree.lab7.MobileDevice;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class MobileDeviceV15 extends MobileDeviceV14 {

    // Declare variables for format menu
    protected JMenu formatMenu;
    protected JRadioButtonMenuItem textFormatItem, binaryFormatItem;
    protected ButtonGroup formatButtonGroup;
    protected boolean isTextFormat = true; // Default is text format

    public MobileDeviceV15(String title) {
        super(title);
    }

    // Override addMenus method to add Format, Text, Binary menu.
    protected void addMenus() {
        super.addMenus();

        // Create format menu
        formatMenu = new JMenu("Format");

        // Create radio button menu items
        textFormatItem = new JRadioButtonMenuItem("Text", true);
        binaryFormatItem = new JRadioButtonMenuItem("Binary", false);

        // Create button group for radio button menu items
        formatButtonGroup = new ButtonGroup();
        formatButtonGroup.add(textFormatItem);
        formatButtonGroup.add(binaryFormatItem);

        // Add radio button menu items to format menu
        formatMenu.add(textFormatItem);
        formatMenu.add(binaryFormatItem);

        // Add format menu to Config menu
        menuConfig.add(formatMenu);
    }

    // Method to handle event of text and binary format.
    public void actionPerformed(ActionEvent e) {
        Object srcObj = e.getSource();

        // Check if text format is selected
        if (srcObj == textFormatItem) {
            isTextFormat = true;
        }
        // Check if binary format is selected
        else if (srcObj == binaryFormatItem) {
            isTextFormat = false;
        }
        // Handle other events using parent's method
        else {
            super.actionPerformed(e);
        }
    }

    // Method to handle save file action event
    public void handleMenuSave() {
        // Check if text format is selected
        if (isTextFormat) {
            super.handleMenuSave(); // Use parent's method for text format
        } else {
            // Create and show file chooser dialog
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showSaveDialog(this);

            // If user selects a file and clicks Save
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    // Create an ObjectOutputStream to write to the file
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(selectedFile));

                    // Write the list of devices to the file
                    oos.writeObject(deviceList);

                    // Close the output stream
                    oos.close();

                    // Show success message
                    JOptionPane.showMessageDialog(this,
                            "Data is saved to " + selectedFile.getAbsolutePath() + " successfully!",
                            "Save", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    // Show error message if saving fails
                    JOptionPane.showMessageDialog(this,
                            "Error saving to file: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    // Method to handle save file action event
    public void handleMenuOpen() {

        // Check if text format is selected
        if (isTextFormat) {
            super.handleMenuOpen();
        }

        else {

            // Create and show file chooser dialog
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(this);

            // If user selects a file and clicks Open
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();

                // Show message about opening the file
                JOptionPane.showMessageDialog(this,
                        "Opening: " + selectedFile.getAbsolutePath(),
                        "Message", JOptionPane.INFORMATION_MESSAGE);

                try {

                    // Create an ObjectInputStream to read from the file
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(selectedFile));

                    // Read the list of devices from the file
                    @SuppressWarnings("unchecked")
                    ArrayList<MobileDevice> loadedDevices = (ArrayList<MobileDevice>) ois.readObject();

                    // Replace the current device list with the loaded one
                    deviceList.clear();
                    deviceList.addAll(loadedDevices);

                    // Close the input stream
                    ois.close();

                    // Show message with the list of devices read from the file
                    StringBuilder message = new StringBuilder("Reading from file " +
                            selectedFile.getAbsolutePath() + "\n");
                    for (MobileDevice device : deviceList) {
                        message.append(device.toString()).append("\n");
                    }

                    JOptionPane.showMessageDialog(this, message.toString());

                } catch (IOException | ClassNotFoundException ex) {
                    // Show error message if reading fails
                    JOptionPane.showMessageDialog(this,
                            "Error reading from file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void addListeners() {
        super.addListeners();
        textFormatItem.addActionListener(this); // Add action listener to text format menu item
        binaryFormatItem.addActionListener(this); // Add action listener to binary format menu item
    }

    // Method to setup and display the GUI
    public static void createAndShowGUI() {
        MobileDeviceV15 mdv15 = new MobileDeviceV15("Mobile Device V15");
        mdv15.createButton(); // Create buttons
        mdv15.createFormPanel(); // Create form panel
        mdv15.addMenus(); // Add menus
        mdv15.addComponents(); // Add components
        mdv15.addListeners(); // Add listeners
        mdv15.setFrameFeatures(); // Set frame features
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
