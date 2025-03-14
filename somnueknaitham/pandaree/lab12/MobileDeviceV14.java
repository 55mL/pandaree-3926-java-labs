/*
 * Author : Pandaree Somnueknaitham
 * Section : 2
 * Student ID : 673040392-6
 * 
 * The MobileDeviceV14 program
 *  This program extends MobileDeviceV13 to add two functions.
 *  1. Display save file dialog and Write device list when user save file to device.
 *  2. Display open file dialog and show text from read file when user open file.
 * 
 * Last update : 14 Mar 2025
 */
package somnueknaitham.pandaree.lab12;

import javax.swing.*;
import somnueknaitham.pandaree.lab7.MobileDevice;
import java.awt.event.*;
import java.io.*;

public class MobileDeviceV14 extends MobileDeviceV13{

    // Constructor
    public MobileDeviceV14(String title){
        super(title);
    }

    // Method to handle action events
    public void actionPerformed(ActionEvent e) {
        Object srcObj = e.getSource();

        // Check if Open menu item is clicked
        if (srcObj == openItem) {
            handleMenuOpen();
        }
        // Check if Save menu item is clicked
        else if (srcObj == saveItem) {
            handleMenuSave();
        } 
        else {
            super.actionPerformed(e);
        }
    }

    // Method when save menu item is clicked
    public void handleMenuSave(){
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showSaveDialog(this);
        // If user clicks Save
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                // Create a PrintWriter to write to the file
                PrintWriter writer = new PrintWriter(new FileWriter(selectedFile));
                
                // Write each device in the list to the file
                for (MobileDevice device : deviceList) {
                    writer.println(device.toString());
                }
                
                // Close the writer
                writer.close();
                
                // Show success message
                JOptionPane.showMessageDialog(this, "Data is saved to " + selectedFile.getName() + " successfully!", "Save", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving to file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Method when open menu item is clicked
    public void handleMenuOpen() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);
        
        // If user selects a file and clicks Open
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            
            // Show message about opening the file
            JOptionPane.showMessageDialog(this, 
                "Opening: " + selectedFile.getAbsolutePath(), "Message", JOptionPane.INFORMATION_MESSAGE);
            
            try {
                // Create a BufferedReader to read from the file
                BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                String line;
                
                // Clear the existing device list
                deviceList.clear();
                
                // Read each line from the file
                while ((line = reader.readLine()) != null) {
                    // Split the line into device type and details
                    String[] parts = line.split(": ", 2);
                    if (parts.length == 2) {
                        String deviceType = parts[0];
                        String details = parts[1];
                        
                        // Parse details to extract name, brand, and price
                        int nameEndIndex = details.indexOf(" (");
                        String name = details.substring(0, nameEndIndex);
                        
                        int brandStartIndex = details.indexOf("(") + 1;
                        int brandEndIndex = details.indexOf(")");
                        String brand = details.substring(brandStartIndex, brandEndIndex);
                        
                        int priceStartIndex = details.indexOf(") ") + 2;
                        int priceEndIndex = details.indexOf(" Baht");
                        double price = Double.parseDouble(details.substring(priceStartIndex, priceEndIndex));
                        
                        // Create appropriate device object based on type
                        MobileDevice device;
                        if (deviceType.equals("SmartPhone")) {
                            device = new SmartPhone(name, brand, price);
                        } else {
                            device = new Tablet(name, brand, price);
                        }
                        
                        // Add the device to the list
                        deviceList.add(device);
                    }
                }
                
                // Close the reader
                reader.close();

                // Show message with the list of devices read from the file
                StringBuilder message = new StringBuilder("Read devices from the file " + 
                    selectedFile.getAbsolutePath() + " are as follows:\n");
                for (MobileDevice device : deviceList) {
                    message.append(device.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(this, message.toString());
                
            }
        catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading from file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }
    }
    // Method to add action listener
    public void addListener(){
        super.addListeners();
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
    }
    // Method to setup and display the GUI
    public static void createAndShowGUI() {
        MobileDeviceV14 mdv14 = new MobileDeviceV14("Mobile Device V14");
        mdv14.createButton(); // Create buttons
        mdv14.createFormPanel(); // Create form panel
        mdv14.addMenus(); // Add menus
        mdv14.addComponents(); // Add components
        mdv14.addListeners();  // Add listeners
        mdv14.setFrameFeatures(); // Set frame features
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
