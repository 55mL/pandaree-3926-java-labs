/*
 * Author : Pandaree Somnueknaitham
 * Section : 2
 * Student ID : 673040392-6
 * 
 * The SortMobileDevicesByPrice program
 *  This is comparator class which implements interface Comparator and
 *  has compare method to compare price of device.
 * 
 * Output should be:
 * 
 * Mobile devices sorted by price:
 * AppleWatch [color=Silver, price=9400.0, modelName=Apple Watch Nike SE GPS]
 * AppleWatch [color=Space Gray, price=12900.0, modelName=Apple Watch Ultra] 
 * IPadAir [color=Rose Gold, price=19900.0, storage=64, chip=Apple M2]
 * IPadAir [color=Silver, price=24900.0, storage=256, chip=Apple M2]  
 * 
 * Last update : 30 Jan 2025
 */
package somnueknaitham.pandaree.lab7;

import java.util.Comparator;
import java.util.Arrays;

public class SortMobileDevicesByPrice implements Comparator<MobileDevice> {
    // Compare method to compare devices' price
    public int compare(MobileDevice device, MobileDevice devices ){
        return  Double.compare(device.getPrice(), devices.getPrice());
    }
    // Main method
    public static void main(String[] args) {
        // Create array of mobile devices
        MobileDevice[] devices = new MobileDevice[4] ;
        devices[0] = new IPadAir("Rose Gold", 19900.0, 64);
        devices[1] = new IPadAir("Silver", 24900.0, 256);
        devices[2] = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");
        devices[3] = new AppleWatch("Space Gray", 12900.0, "Apple Watch Ultra"); 

        // Sort the devices by price using comparator
        Arrays.sort(devices, new SortMobileDevicesByPrice());

        // Display sorted devices
        System.out.println("Mobile devices sorted by price:");
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
