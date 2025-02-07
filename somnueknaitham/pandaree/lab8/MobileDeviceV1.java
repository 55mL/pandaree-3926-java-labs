/*
 * Author : Pandaree Somnuekanitham
 * Section : 2
 * Student ID : 673040392-6
 * 
 * The MobileDeviceV1 program
 *  This program will show basic mobile device details including device name, brand, and price label with text field.
 *  And type label with two choice as radio button.
 * 
 * Last update : 2 Feb 2025
 */
package somnueknaitham.pandaree.lab8;
import javax.swing.*;
import java.awt.*;

public class MobileDeviceV1 extends MySimpleWindow {
    // Declare variables
    protected JLabel deviceNameLabel, brandLabel, priceLabel, typeLabel;
    protected JTextField deviceNameTextField, brandTextField, priceTextField, typeTextField;
    protected JRadioButton smartphoneRButton, tabletRButton;
    protected ButtonGroup buttonGroup;
    protected JPanel formPanel, typePanel;
    // Constructor that call parents method
    public MobileDeviceV1(String title){
        super(title);
    }
    // Method to create user input form in panel
    protected void createFormPanel(){
        // Create panel with grid layout
        formPanel = new JPanel(new GridLayout(4,2));
        // Create labels
        deviceNameLabel = new JLabel("Device Name:");
        brandLabel = new JLabel("Brand:");
        priceLabel = new JLabel("Price:");
        typeLabel = new JLabel("Type:");
        // Create text fields
        deviceNameTextField = new JTextField(15);
        brandTextField = new JTextField(15);
        priceTextField = new JTextField(15);
        typeTextField = new JTextField(15);
        // Add labels and text field to panel in order
        formPanel.add(deviceNameLabel);
        formPanel.add(deviceNameTextField);

        formPanel.add(brandLabel);
        formPanel.add(brandTextField);

        formPanel.add(priceLabel);
        formPanel.add(priceTextField);
        // create button group and radio buttons
        buttonGroup = new ButtonGroup();
        smartphoneRButton = new JRadioButton("Smartphone", true);
        tabletRButton = new JRadioButton("Tablet");
        buttonGroup.add(smartphoneRButton);
        buttonGroup.add(tabletRButton);
        // Add radio buttons to panel in order
        typePanel = new JPanel(new FlowLayout());
        typePanel.add(smartphoneRButton);
        typePanel.add(tabletRButton);
        // Add type label and radio buttons to panel in order
        formPanel.add(typeLabel);
        formPanel.add(typePanel);
    }
    // Override addComponents method
    protected void addComponents(){
        super.addComponents();
        // Set layout to add component
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(formPanel, BorderLayout.NORTH); // Add form panel to top
        mainPanel.add(buttonPanel, BorderLayout.SOUTH); // Add button panel to button
        setContentPane(mainPanel);
    }
    // Method to show new GUI
    public static void createAndShowGUI() {
        MobileDeviceV1 mdv1 = new MobileDeviceV1("Mobile Device V1"); 
        mdv1.createButton(); // call createButton method
        mdv1.createFormPanel(); // call createForm method
        mdv1.addComponents(); // call addComponents method
        mdv1.setFrameFeatures(); // call setFrameFeatures method
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
