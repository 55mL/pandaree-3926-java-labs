/*
 * Author : Pandaree Somnueknaitham
 * Section : 2
 * Student ID : 673040392-6
 * 
 * The MobileDevice class
 *  This abstract class has setter and getter methods for color and price
 *  and an abstract method isWatch to return boolean type.
 * 
 * Last update : 29 Jan 2025
 */
package somnueknaitham.pandaree.lab7;

public abstract class MobileDevice {
    // Declare Variables
    protected String color;
    protected double price;

    // Method to return a current color
    public String  getColor(){
        return color;
    }

    // Method to set a new color
    public void setColor(String color){
        this.color = color;
    }

    // Method to return a current price
    public double getPrice(){
        return price;
    }

    // Method to set a new price
    public void setPrice(double price){
        this.price = price;
    }

    // Method to return a boolean true or false
    public abstract boolean isWatch();
}
