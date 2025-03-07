/*
 * Author : Pandaree Somnueknaitham
 * Section : 2
 * Student ID : 673040392-6
 *  
 * The MobileDeviceCompleteV3 program
 *  This program extends MobileDeviceCompleteV2 program and implements ComponentListener to handle component events.
 * 
 * Last update : 7 Mar 2025
 */
package somnueknaitham.pandaree.lab11;

import java.awt.event.*;
import javax.swing.*;
public class MobileDeviceCompleteV3 extends MobileDeviceCompleteV2 implements ComponentListener { 
    // Constructor
    public MobileDeviceCompleteV3 (String title) {
        super(title);
    }

    // When resize window
    public void componentResized(ComponentEvent e) {
        JOptionPane.showMessageDialog(this, "Window resized to: " + e.getComponent().getWidth() + " x " + e.getComponent().getHeight()); // Display a message showing the new width and height when the frame is resized
    } 

    // When move window
    public void componentMoved(ComponentEvent e) {
        JOptionPane.showMessageDialog(this, "Window moved to: X=" + e.getComponent().getX() + " Y=" + e.getComponent().getY()); // Display a message showing the new position when the frame is moved
    }

    // When window is visible
    public void componentShown(ComponentEvent e) {
        JOptionPane.showMessageDialog(this, "Window is now visible."); // Display a message when the window is shown
    }

    // When window is not visible
    public void componentHidden(ComponentEvent e) {
        JOptionPane.showMessageDialog(this, "Window is now hidden."); // Display a message when the window is hidden
    }

    // Method to add listeners
    public void addListeners(){
        super.addListeners();
        this.addComponentListener(this); // Add this object as a component listener
    }

    // Method to setup and show GUI
    public static void createAndShowGUI(){
        MobileDeviceCompleteV3 window = new MobileDeviceCompleteV3("Mobile Device Complete V3");
        window.addComponents(); // Add components
        window.addMenus(); // Add menus
        window.addListeners(); // Add listeners
        window.setFrameFeatures(); // Setup frame features
    }

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater((new Runnable() {
            public void run(){
                createAndShowGUI(); // call createAndShowGUI method
            }
        }));
    }    
}
