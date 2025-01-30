/*
 * Author : Pandaree Somnueknaitham
 * Section : 2
 * Student ID : 673040392-6
 * 
 * IPadAir class
 *  This is a subclass of MobileDevice that has constructor which store color, price, and storage,
 *  getter method for storage and chip name, setter method for storage and implement isWatch method to return false.
 * 
 * Last update : 29 Jan 2025
 */
package somnueknaitham.pandaree.lab7;

public class IPadAir extends MobileDevice {
    // Declare variables
    private double storage;
    private static String CHIP_NAME = "Apple M2";

    // Public Constructor to store values
    public IPadAir(String color, double price, double storage) {
        setColor(color);
        setPrice(price);
        setStorage(storage);
    }

    // Method to return a current storage
    public double getStorage() {
        return storage;
    }

    // Method to set a new storage
    public void setStorage(double storage) {
        this.storage = storage;
    }

    // Method to give output
    public String toString() {
        return "IPadAir [" + "color=" + getColor() + ", price=" + getPrice() + ", storage=" + getStorage() + ", chip=" + getChipName()
                + "]";
    }

    // Method to return chip name
    public static String getChipName() {
        return CHIP_NAME;
    }

    @Override
    public boolean isWatch() {
        return false; // Because IPad is not a watch
    }

}
