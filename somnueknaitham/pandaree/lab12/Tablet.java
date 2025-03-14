/*
 * Author : Pandaree Somnueknaitham
 * Section : 2
 * Student ID : 673040392-6
 * 
 * The Tablet class
 *  This is a subclass of an abstract class which extends MobileDevice and has two constructors.
 * 
 * Last update : 14 Mar 2025
 */
package somnueknaitham.pandaree.lab12;

import java.io.Serializable;

import somnueknaitham.pandaree.lab7.MobileDevice;

public class Tablet extends MobileDevice implements Serializable{
    // Declare variable
    public static String type = "Tablet";
    public String name, brand;

    // Constructor with name, brand, and price
    public Tablet(String name, String brand, double price) {
        setName(name);
        setBrand(brand);
        setPrice(price);
    }

    // Constructor with name, brand, price, and color
    public Tablet(String name, String brand, double price, String color) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        setColor(color);
    }

    // Getter method to return the name
    public String getName(){
        return name;
    }

    // Setter method to set the name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method to return the brand
    public String getBrand(){
        return brand;
    }

    // Setter method to set the brand
    public void setBrand(String brand) {
        this.brand = brand;
    }


    @Override
    public boolean isWatch() {
        return false; // iPad is not a watch
    }
    
    // Return string of the object
    @Override
    public String toString() {
        return type + ": " + name + " (" + brand + ") " + price + " Baht" ;
    }
}
