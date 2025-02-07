/*
 * Author : Pandaree Somnuekanitham
 * Section : 2
 * Student ID : 673040392-6
 * 
 * The MobileDeviceV2 program
 *  This class implement MobileDeviceV1 to add more extra panel
 *  including operating system label with JComboBox and feature label with JTextArea.
 * 
 * Last update : 7 Feb 2025
 */
package somnueknaitham.pandaree.lab8;
import java.awt.*;
import javax.swing.*;

public class MobileDeviceV2 extends MobileDeviceV1 {
    // Declare variables
    protected JComboBox<String> systemChoice;
    protected JLabel osLabel, featureLabel;
    protected JTextArea featureTextArea;
    protected JScrollPane featureScrollPane;
    protected JPanel extraPanel;
    // Constructor that call parents method
    public MobileDeviceV2(String title){
        super(title);
    }
    // Override and add extra panel
    protected void createFormPanel(){
        super.createFormPanel();
        // Create new panel in grid layout
        extraPanel = new JPanel(new GridLayout(2, 2));
        // Create labels
        osLabel = new JLabel("Operating System:");
        featureLabel = new JLabel("Features:");
        // Create combo box
        String choice[] = {"Android", "iOS", "Windows","Others"}; 
        systemChoice = new JComboBox<>(choice);
        // Create text area
        featureTextArea = new JTextArea(3,25);
        featureScrollPane = new JScrollPane(featureTextArea);
        // Add labels to extra panel in order
        extraPanel.add(osLabel);
        extraPanel.add(systemChoice);
        extraPanel.add(featureLabel);
        extraPanel.add(featureScrollPane);
    }
    // Override addComponent method
    protected void addComponents(){
        super.addComponents();
        mainPanel.add(extraPanel, BorderLayout.CENTER); // Add extra panel to center
        setContentPane(mainPanel);
    }
    // Method to show GUI
    public static void createAndShowGUI(){
        MobileDeviceV2 mdv2 = new MobileDeviceV2("Mobile Device V2");
        mdv2.createButton(); // call createButton method
        mdv2.createFormPanel(); // call createForm method
        mdv2.addComponents(); // call addComponents method
        mdv2.setFrameFeatures(); // call setFrameFeatures method
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
