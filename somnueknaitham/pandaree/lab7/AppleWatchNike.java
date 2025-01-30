/*
 * Author : Pandaree Somnueknaitham
 * Section : 2
 * Student ID : 673040392-6
 * 
 * AppleWatch class
 *  This is a subclass of AppleWatch that implement two interfaces, RunnerStatsCollector and HealthMonitorer,
 *  overriding toString method to return new message, and three methods to display running stats, heart rates, and sleep hours.
 * 
 * Last update : 29 Jan 2025
 */
package somnueknaitham.pandaree.lab7;

public class AppleWatchNike extends AppleWatch implements RunnerStatsCollector, HealthMonitorer {
    // Declare variables
    private double pace, totalDistance, time, avgHeartRate, maxHeartRate, avgSleepHours;
    

    // Constructor that implement from parent class
    public AppleWatchNike(String color, double price, String modelName){
        super(color, price, modelName);
    }

    // Constructor that add more total distances, average heart, and average sleep hours
    public AppleWatchNike(String color, double price, String modelName, double totalDistance, double avgHeartRate, double avgSleepHours){
        super(color, price, modelName);
        this.totalDistance = totalDistance;
        this.avgHeartRate = avgHeartRate;
        this.avgSleepHours = avgSleepHours;
    }

    // Method to return output
    public String toString(){
        return "AppleWatchNike(" + "color: " + getColor() + " price:" + getPrice() + " model name:" + getModelName() + " distance:" + this.totalDistance + " km)";
    }

    // Method to display running stats
    public void displayRunningStats(){
        System.out.printf("Total distance run: %.2f km\n", totalDistance);
    }

    // Method to display heart rates
    public void displayHeartRates(){
        System.out.printf("Average heart rate: %.0f bpm\n", avgHeartRate);
    }

    // Method to display sleep hours
    public void displaySleepHours(){
        if (avgSleepHours == 1) {
            System.out.printf("Average sleep duration: %.2f hour\n", avgSleepHours);
        } else {
            System.out.printf("Average sleep duration: %.2f hours\n", avgSleepHours);
        }
    }
}
