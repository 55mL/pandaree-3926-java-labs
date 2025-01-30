/*
 * Author : Pandaree Somnueknaitham
 * Section : 2
 * Student ID : 673040392-6
 * 
 * The TestAppleWatchNike program
 *  This program is driver class to display property of Nike watch and
 *  display running stats, heart rates, and sleep hours by call the method from AppleWatchNike class
 * 
 * Output should be:
 * AppleWatchNike(color: Space Gray price:12900.0 model name:Nike SE GPS distance:42.5 km)
 * Total distance run: 42.50 km
 * Average heart rate: 75 bpm
 * Average sleep duration: 7.50 hours
 * Is this a watch? true
 * Through base reference: AppleWatchNike(color: Space Gray price:12900.0 model name:Nike SE GPS distance:42.5 km)
 * 
 * Last update : 29 Jan 2025
 */
package somnueknaitham.pandaree.lab7;

class TestAppleWatchNike {
    // Main method
    public static void main(String[] args) {
        AppleWatchNike nikeWatch = new AppleWatchNike("Space Gray", 12900.0, "Nike SE GPS", 42.5, 75, 7.5);
        System.out.println(nikeWatch);

        // Display health amd fitness metrics
        nikeWatch.displayRunningStats();
        nikeWatch.displayHeartRates();
        nikeWatch.displaySleepHours();

        // Test inheritance from AppleWatch
        System.out.println("Is this a watch? " + nikeWatch.isWatch());

        // Test polymorphism
        AppleWatch baseWatch = nikeWatch;
        System.out.println("Through base reference: " + baseWatch);
    }
}
