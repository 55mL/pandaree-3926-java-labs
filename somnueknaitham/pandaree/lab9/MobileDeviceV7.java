/*
 * Author : Pandaree Somnueknaitham
 * Section : 2
 * Student ID : 673040392-6
 * 
 * The MobileDeviceV7 program
 *  This program extends MobileDeviceV6 to add image of Samsung Galaxy S25 Ultra 
 *  and pre-fill form data and select option with Samsung Galaxy S25 Ultra data 
 *  including device name, brand, price, type, operating system, features, vendor list, and device rating.
 * 
 * Last update : 14 Feb 2025
 */
package somnueknaitham.pandaree.lab9;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;


public class MobileDeviceV7 extends MobileDeviceV6 {

    protected JPanel newAndRatesPanel;
    // Constructor that call parents class
    public MobileDeviceV7(String title){
        super(title);
    }
    
    // Overriding addComponents method to pre-fill form and add image
    protected void addComponents(){
        super.addComponents();
        // Pre-fill data in device text field, brand text field, and price text field
        deviceNameTextField.setText("Samsung Galaxy S25 Ultra");
        brandTextField.setText("Samsung");
        priceTextField.setText("46900");
        // Set selection of type to smartphone
        smartphoneRButton.setSelected(true);
        // Set selection of operating system to Android
        systemChoice.setSelectedItem("Android");
        // Pre-fill data in feature text area
        featureTextArea.setText("- 200MP Camera\n - 1TB Storage\n - Snapdragon Gen 4 Processor\n - 5000mAh Battery\n - 6.8-inch AMOLED Display\n- 120Hz Refresh Rate\n - 5000mAh Battery with Fast Charging");
        // Set selection of vendor list to index 0
        vendorList.setSelectedIndex(0);
        // Set value of rate slider to 9
        rateSlider.setValue(9);
        // Get image from ReadImage class
        ReadImage image = new ReadImage();
        image.setPreferredSize(new Dimension(280,350));
        // Add Panel
        newAndRatesPanel = new JPanel(new BorderLayout());
        newAndRatesPanel.add(newPanel, BorderLayout.NORTH);
        newAndRatesPanel.add(ratesPanel, BorderLayout.SOUTH);
        extraPanel.add(newAndRatesPanel, BorderLayout.NORTH);
        extraPanel.add(image, BorderLayout.SOUTH);
    }

    // Method to show GUI
    public static void createAndShowGUI(){
        MobileDeviceV7 mdv7 = new MobileDeviceV7("Mobile Device V7");
        mdv7.createButton(); // call createButton method
        mdv7.createFormPanel(); // call createFormPanel method
        mdv7.addMenus(); // call addMenus method
        mdv7.addComponents(); // call addComponents method
        mdv7.setFrameFeatures(); // call setFrameFeatures method
    }

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                createAndShowGUI();
            }
        });
    }
}

// Class ReadImage to get image
class ReadImage extends JPanel{
    BufferedImage img;
    String filename = "images\\S25-ultra (1).jpg";
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(),getHeight(), this);
    }
    public ReadImage(){
        try {
            img = ImageIO.read((getClass().getClassLoader().getResource(filename)));
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}
