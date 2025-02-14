/*
 * Author : Pandaree Somnueknaitham
 * Section : 2
 * Student ID : 673040392-6
 * 
 * The MobileDeviceV6 program
 *  This program extends MobileDeviceV5 to set style of components.
 *  Set font style and font color of labels.
 *  Set background color, font color, and font style of text fields and text areas.
 *  Set background color, font style, and selection background color of vendor list.
 *  Set text color and background color of submit button and reset button.
 * 
 * Last update : 14 Feb 2025
 */
package somnueknaitham.pandaree.lab9;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingUtilities;

public class MobileDeviceV6 extends MobileDeviceV5 {

    // Constructor to call parents class
    public MobileDeviceV6(String title){
        super(title);
    }

    // Overriding addComponents method to set font, color, and style of components
    protected void addComponents(){
        super.addComponents();
        // Set labels' font
        Font fontLabel = new Font("Arial", Font.BOLD, 14);
        deviceNameLabel.setFont(fontLabel);
        brandLabel.setFont(fontLabel);
        priceLabel.setFont(fontLabel);
        typeLabel.setFont(fontLabel);
        osLabel.setFont(fontLabel);
        featureLabel.setFont(fontLabel);
        vendorLabel.setFont(fontLabel);
        ratesLabel.setFont(fontLabel);
        // Set labels' font to dark blue
        Color darkBlue = new Color(0x000080);
        deviceNameLabel.setForeground(darkBlue);
        brandLabel.setForeground(darkBlue);
        priceLabel.setForeground(darkBlue);
        typeLabel.setForeground(darkBlue);
        osLabel.setForeground(darkBlue);
        featureLabel.setForeground(darkBlue);
        vendorLabel.setForeground(darkBlue);
        ratesLabel.setForeground(darkBlue);
        // Set text fields' color to light gray
        Color lightGray = new Color(211, 211, 211);
        deviceNameTextField.setBackground(lightGray);
        brandTextField.setBackground(lightGray);
        priceTextField.setBackground(lightGray);
        // Set text area's background color to light yellow
        featureTextArea.setBackground(new Color(255,255,237));
        // Set text area's font
        featureTextArea.setFont(new Font("Arial", Font.ITALIC, 14));
        // Set text area's font color to dark gray
        featureTextArea.setForeground(new Color(169,169,169));
        // Set vendor list color
        vendorList.setForeground(new Color(0x006400));
        vendorList.setBackground(lightGray);
        vendorList.setSelectionBackground(Color.YELLOW);
        vendorList.setSelectionForeground(Color.BLACK);
        // Set button color
        submitButton.setForeground(Color.GREEN);
        submitButton.setBackground(Color.WHITE);
        resetButton.setForeground(Color.RED);
        resetButton.setBackground(Color.WHITE);
    }

    // Method to show GUI
    public static void createAndShowGUI(){
        MobileDeviceV6 mdv6 = new MobileDeviceV6("Mobile Device V6");
        mdv6.createButton(); // call createButton method
        mdv6.createFormPanel(); // call createFormPanel method
        mdv6.addMenus(); // call addMenus method
        mdv6.addComponents(); // call addComponents method
        mdv6.setFrameFeatures(); // call setFrameFeatures method
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
