/*
 * Author : Pandaree Somnueknaitham
 * Section : 2
 * Student ID : 673040392-6
 * 
 * AppleWatch class
 *  This is a subclass of MobileDevice that has constructor which store color, 
 *  price, and ,model name and implement isWatch method to return true.
 * 
 * Last update : 29 Jan 2025
 */
package somnueknaitham.pandaree.lab7;

public class AppleWatch extends MobileDevice {
    // Declare variables
    private String modelName;
    
    // Constructor that store color, price, model name
    public AppleWatch(String color, double price, String modelName){
        setColor(color);
        setPrice(price);
        this.modelName = modelName;
    }

    // Method to give output
    public String toString(){
        return "AppleWatch [" + "color=" + getColor() + ", price=" + getPrice() + ", modelName=" + getModelName() + "]";
    }

    // Method to return a current model name
    public String getModelName(){
        return modelName;
    }

    // Method to set a new model name
    public void setModelName(String modelName){
        this.modelName = modelName;
    }

    @Override
    public boolean isWatch() {
        return true; // Because AppleWatch is a watch
    }
}
