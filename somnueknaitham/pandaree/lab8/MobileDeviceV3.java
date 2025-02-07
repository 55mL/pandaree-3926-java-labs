/*
 * Author : Pandaree Somnuekanitham
 * Section : 2
 * Student ID : 673040392-6
 * 
 * The MobileDevice3 program
 *  This class implements MobileDeviceV2 to add menu bar with file and config menu.
 *  By using addMenus method
 * 
 * Last update : 7 Feb 2025
 */
package somnueknaitham.pandaree.lab8;
import javax.swing.*;

public class MobileDeviceV3 extends MobileDeviceV2 {
    // Declare variables
    protected JMenuBar menuBar;
    protected JMenu menuFile, menuConfig;
    protected JMenu sizeMenu, colorMenu, fontMenu;
    protected JMenuItem newItem, openItem, saveItem, exitItem;
    protected JMenuItem smallItem, mediumItem, largeItem, extraItem, blackItem, redItem, greenItem, blueItem, font1Item, font2Item, font3Item;
    // Constructor that call parents method
    public MobileDeviceV3(String title){
        super(title);
    }
    // Method to add menu items to menus and menu bar
    protected void addMenus(){
        // Create menu bar
        menuBar = new JMenuBar();
        // Create menu
        menuFile = new JMenu("File");
        menuConfig = new JMenu("Config");
        // Add menus to menu bar
        menuBar.add(menuFile);
        menuBar.add(menuConfig);
        // Create menu items
        newItem = new JMenuItem("New");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        smallItem = new JMenuItem("Small");
        mediumItem = new JMenuItem("Medium");
        largeItem = new JMenuItem("Large");
        extraItem = new JMenuItem("Extra Large");

        blackItem = new JMenuItem("Black");
        redItem = new JMenuItem("Red");
        greenItem = new JMenuItem("Green");
        blueItem = new JMenuItem("Blue");

        font1Item = new JMenuItem("Font 1");
        font2Item = new JMenuItem("Font 2");
        font3Item = new JMenuItem("Font 3");
        // Add menu items to file menu
        menuFile.add(newItem);
        menuFile.add(openItem);
        menuFile.add(saveItem);
        menuFile.add(exitItem);
        // Create sub menu
        sizeMenu = new JMenu("Size");
        colorMenu = new JMenu("Color");
        fontMenu = new JMenu("Font");
        // Add sub menu to config menu
        menuConfig.add(sizeMenu);
        menuConfig.add(colorMenu);
        menuConfig.add(fontMenu);
        // Abb menu items to menu
        sizeMenu.add(smallItem); // Abb menu items to size menu
        sizeMenu.add(mediumItem);
        sizeMenu.add(largeItem);
        sizeMenu.add(extraItem);

        colorMenu.add(blackItem); //Add  menu items to color menu
        colorMenu.add(redItem);
        colorMenu.add(greenItem);
        colorMenu.add(blueItem);

        fontMenu.add(font1Item); //Add  menu items to font menu
        fontMenu.add(font2Item);
        fontMenu.add(font3Item);
    }
    // Override addComponents method
    protected void addComponents(){
        super.addComponents();
        setContentPane(mainPanel);
    }
    // Override setFrameFeatures
    protected void setFrameFeatures(){
        super.setFrameFeatures();
        this.setJMenuBar(menuBar); // Add menu bar
    }
    // Method to show GUI
    public static void createAndShowGUI(){
        MobileDeviceV3 mdv3 = new MobileDeviceV3("Mobile Device V3");
        mdv3.createButton(); // call createButton method
        mdv3.createFormPanel(); // call createFormPanel method
        mdv3.addMenus(); // call addMenus method
        mdv3.addComponents(); // call addComponents method
        mdv3.setFrameFeatures(); // call setFrameFeatures method
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
