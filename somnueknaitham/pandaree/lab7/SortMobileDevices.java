/*
 * Author : Pandaree Somnueknaitham
 * Section : 2
 * Student ID : 673040392-6
 * 
 * The SortMobileDevices program
 * 
 * Output should be:
 * 
 * Mobile devices sorted by multiple criteria
 * AppleWatch [color=Silver, price=9400.0, modelName=Apple Watch Nike SE GPS]
 * AppleWatch [color=Gold, price=12900.0, modelName=Apple Watch Series 7]
 * AppleWatch [color=Space Gray, price=12900.0, modelName=Apple Watch Ultra]
 * IPadAir [color=Rose Gold, price=19900.0, storage=64, chip=Apple M2]
 * IPadAir [color=Silver, price=19900.0, storage=64, chip=Apple M2]
 * IPadAir [color=Space Gray, price=19900.0, storage=128, chip=Apple M2]
 * IPadAir [color=Silver, price=24900.0, storage=256, chip=Apple M2]
 * 
 * Last update : 30 Jan 2025
 */
package somnueknaitham.pandaree.lab7;

import java.util.Arrays;
import java.util.Comparator;

// Comparator implementation for sorting MobileDevices 
public class SortMobileDevices implements Comparator<MobileDevice> {

    // Sorting method to sort device by multiple attributes
    public int compare(MobileDevice device1, MobileDevice device2) {
        // Compare price first
        int comparePrice = Double.compare(device1.getPrice(), device2.getPrice());
        if (comparePrice != 0) {
            return comparePrice;
        }
        // If both devices are IPad Air, comparing storage and then color
        if (device1 instanceof IPadAir && device2 instanceof IPadAir){
            return new SortStorage().compare((IPadAir) device1, (IPadAir) device2);
        }
        // If both devices are Apple Watch, comparing model name and then color
        if (device1 instanceof AppleWatch && device2 instanceof AppleWatch){
            return new SortModelName().compare((AppleWatch) device1, (AppleWatch) device2);
        }
        // If mobile devices are in different types, comparing color
        else {
            return device1.getColor().compareTo(device2.getColor());
        }
            
    }
    // Main method
    public static void main(String[] args) {
        MobileDevice[] devices = new MobileDevice[7];
        devices[0] = new IPadAir("Rose Gold", 19900.0, 64);
        devices[1] = new IPadAir("Silver", 24900.0, 256);
        // Same price, different storage
        devices[2] = new IPadAir("Space Gray", 19900.0, 128);
        devices[3] = new IPadAir("Silver", 19900.0, 64);
        // AppleWatches with different prices
        devices[4] = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");
        // Same price, different models
        devices[5] = new AppleWatch("Space Gray", 12900.0, "Apple Watch Ultra");
        devices[6] = new AppleWatch("Gold", 12900.0, "Apple Watch Series 7");

        // Sort the devices by price using comparator
        Arrays.sort(devices, new SortMobileDevices());
        // Display sorted devices
        System.out.println("Mobile devices sorted by multiple criteria");
        for (MobileDevice device : devices) {
            if (device instanceof IPadAir) {
                IPadAir ipad = (IPadAir) device;
                System.out.printf("IPadAir [color=%s, price=%.1f, storage=%d, chip=Apple M2]\n", ipad.getColor(), ipad.getPrice(), (int) ipad.getStorage());
            } else { 
                System.out.println(device);
            }
        }
    }
}
// Sorting Class to compare devices between IPad and IPad
class SortStorage implements Comparator<IPadAir>{
    public int compare(IPadAir ipad1, IPadAir ipad2){
        int compareStorage = Double.compare(ipad1.getStorage(), ipad2.getStorage());
        return (compareStorage != 0) ? compareStorage : ipad1.getColor().compareTo(ipad2.getColor());
    }
}
// Sorting  CLass to compare devices between Apple watch and Apple Watch.
class SortModelName implements Comparator<AppleWatch>{
    public int compare(AppleWatch appleWatch1, AppleWatch appleWatch2){
        int compareModelName = appleWatch1.getModelName().compareTo(appleWatch2.getModelName());
        return (compareModelName != 0) ? compareModelName : appleWatch1.getColor().compareTo(appleWatch2.getColor());
    }
}
