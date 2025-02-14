/*
 * Author : Pandaree Somnueknaitham
 * Section : 2
 * Student ID : 673040392-6
 * 
 * The MobileDeviceV4 program
 *  This program extends MobileDeviceV3 to add icons to menu items including new item, open item, save item, and exit item
 *  by using images from images files.
 *  
 * Last update : 14 Feb 2025
 */
package somnueknaitham.pandaree.lab9;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import java.awt.*;

import somnueknaitham.pandaree.lab8.MobileDeviceV3;

public class MobileDeviceV4 extends MobileDeviceV3{
    
    // Constructor that implement parent class
    public MobileDeviceV4(String title){
        super(title);
    }

    // Overriding and add image icon
    protected void addMenus() {
        super.addMenus(); 
        // Get and set image icon from URL resource
        newItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images\\new_icon.png"))); // set newItem's image icon
        saveItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images\\save_icon.png"))); // set saveItem's image icon
        openItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images\\open_icon.png"))); // set openItem's image icon
        exitItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images\\exit_icon.png"))); // set exitItem's image icon

        // Set font size of size menu
        smallItem.setFont(new Font("Arial", Font.PLAIN, 10)); // set smallItem's size to 10
        mediumItem.setFont(new Font("Arial", Font.PLAIN, 14)); // set mediumItem's size to 14
        largeItem.setFont(new Font("Arial", Font.PLAIN, 18)); // set largeItem's size to 18
        extraItem.setFont(new Font("Arial", Font.PLAIN, 22)); // set extraItem's size to 22

        // Set color font of color menu
        blackItem.setForeground(Color.BLACK); // set blackItem's color to black
        redItem.setForeground(Color.RED); // set redItem's color to red
        greenItem.setForeground(Color.GREEN); // set greenItem's color to green
        blueItem.setForeground(Color.BLUE); // set blueItem's color to blue

        // Set font in font font menu
        font1Item.setFont(new Font("Serif", Font.PLAIN, 14)); // set font1Item's font to Serif
        font2Item.setFont(new Font("SansSerif", Font.PLAIN, 14)); // set font2Item's font to SansSerif
        font3Item.setFont(new Font("Monospaced", Font.PLAIN, 14)); // set font3Item's font to Monospaced
    }

    // Method to add components
    protected void addComponents() {
        super.addComponents();
        setContentPane(mainPanel);
    }

    // Method to show GUI
    public static void createAndShowGUI(){
        MobileDeviceV4 mdv4 = new MobileDeviceV4("Mobile Device V4");
        mdv4.createButton(); // call createButton method
        mdv4.createFormPanel(); // call createFormPanel method
        mdv4.addMenus(); // call addMenus method
        mdv4.addComponents(); // call addComponents method
        mdv4.setFrameFeatures(); // call setFrameFeatures method
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
