/*
 * Author : Pandaree Somnueknaitham
 * Section : 2
 * Student ID : 673040392-6
 * 
 * The TestMobileDevices program
 *  This program is driver class to compare the price of two mobile devices
 *  that user input by using comparePrice method.
 * 
 * Output should be:
 * 
 * IPadAir chip name is Apple M2
 * IPadAir [color=Silver, price=24900.0, storage=256.0, chip=Apple M2] is not a watch
 * IPadAir [color=Rose Gold, price=19900.0, storage=64.0, chip=Apple M2] is cheaper than IPadAir [color=Silver, price=24900.0, storage=256.0, chip=Apple M2]
 * AppleWatch [color=Silver, price=9400.0, modelName=Apple Watch Nike SE GPS] is cheaper than IPadAir [color=Rose Gold, price=19900.0, storage=64.0, chip=Apple M2]
 * 
 * Last update : 29 Jan 2025
 */
package somnueknaitham.pandaree.lab7;

public class TestMobileDevices {

    // Main method
    public static void main(String[] args) {
        
        IPadAir ipadAir1 = new IPadAir("Rose Gold", 19900.0, 64);
        IPadAir ipadAir2 = new IPadAir("Silver", 24900.0, 256);
        AppleWatch appleWatch1 = new AppleWatch("Silver", 9400, "Apple Watch Nike SE GPS");
        
        System.out.println("IPadAir chip name is " + IPadAir.getChipName());
        // Call isWatch method, return true if AppleWatch, false if not.
        if (ipadAir2.isWatch()){
            System.out.println(ipadAir2 + " is a watch"); // Display if true
        } else {
            System.out.println(ipadAir2 + " is not a watch"); // Display if not
        }
        // Call comparePrice method
        comparePrice(ipadAir1, ipadAir2);
        comparePrice(ipadAir1, appleWatch1);

    }

    // Static method comparePrice to compare price of devices in each case
    static void comparePrice(MobileDevice device1, MobileDevice device2){
        // If device1's price is cheaper than device2's price
        if (device1.getPrice() < device2.getPrice()){
            System.out.println(device1 + " is cheaper than " + device2 ); // Display message
        } 
        // If device2's price is cheaper that device1's price
        else if (device1.getPrice() > device2.getPrice()){
            System.out.println(device2 + " is cheaper than " + device1 ); // Display message
        } 
        // If device1's price equal to device2's price
        else {
            System.out.println(device1 + " is as cheap as " + device2); // Display message
        }
    }
}
