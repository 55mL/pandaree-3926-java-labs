/*
 * Author : Pandaree Somnueknaitham
 * Section : 2
 * Student ID : 673040392-6
 * 
 * The MobileDeviceV5 program
 *  This program extends MobileDeviceV4 to add new two panels including vendorPanel that allow user to choose vendor that has this device
 *  and ratesPanel that allow user to rate the device with JSlider 1-10.
 * 
 * Last update : 14 Feb 2025
 */
package somnueknaitham.pandaree.lab9;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Dictionary;
import javax.swing.*;

public class MobileDeviceV5 extends MobileDeviceV4{

    // Declare variables
    protected JPanel vendorPanel, ratesPanel, newPanel;
    protected JLabel vendorLabel, ratesLabel;
    protected JList<String> vendorList;
    protected String[] vendors = {"AIS", "True", "DTAC", "Shopee"};
    protected JScrollPane vendorScrollPane;
    protected JSlider rateSlider;

    // Constructor that call parents class
    public MobileDeviceV5(String title){
        super(title);
    }

    // Overriding createFormPanel method to add new two panels
    protected void createFormPanel(){
        super.createFormPanel();
        // Set layout
        newPanel = new JPanel(new GridLayout(2,2));
        vendorPanel = new JPanel(new GridLayout(1,2));
        ratesPanel = new JPanel(new BorderLayout());
        // Set Label text
        vendorLabel = new JLabel("The device is avalable at:");
        ratesLabel = new JLabel("Rate the device (0-10):");
        // Create vendor list with JScrollPane
        vendorList = new JList<>(vendors);
        vendorScrollPane = new JScrollPane(vendorList);
        vendorList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        vendorList.setSelectedIndex(0);
        vendorScrollPane.setPreferredSize(new Dimension(150,80));
        vendorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // Create rate slider
        rateSlider = new JSlider(0, 10);
        rateSlider.setMajorTickSpacing(1);
        rateSlider.setPaintTicks(true);
        rateSlider.setPaintLabels(true);
        rateSlider.setValue(5);
        // Set layout
        ratesPanel.add(ratesLabel, BorderLayout.NORTH);
        ratesPanel.add(rateSlider, BorderLayout.SOUTH);
        extraPanel = new JPanel(new BorderLayout());
        newPanel = new JPanel(new GridLayout(3,2));
        newPanel.add(osLabel);
        newPanel.add(systemChoice);
        newPanel.add(featureLabel);
        newPanel.add(featureScrollPane);
        newPanel.add(vendorLabel);
        newPanel.add(vendorScrollPane);
        // Add panel
        extraPanel.add(newPanel, BorderLayout.CENTER);
        extraPanel.add(ratesPanel, BorderLayout.SOUTH);
    }

    // Method to add component
    protected void addComponents(){
        super.addComponents();
        mainPanel.add(extraPanel, BorderLayout.CENTER); // add extra panel to main panel
        setContentPane(mainPanel);
    }

    // Method to show GUI
    public static void createAndShowGUI(){
        MobileDeviceV5 mdv5 = new MobileDeviceV5("Mobile Device V5");
        mdv5.createButton(); // call createButton method
        mdv5.createFormPanel(); // call createFormPanel method
        mdv5.addMenus(); // call addMenus method
        mdv5.addComponents(); // call addComponents method
        mdv5.setFrameFeatures(); // call setFrameFeatures method
    }

    //Main method
    public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run(){
            createAndShowGUI(); // call createAndShowGUI method
        }
    });
    }
}
