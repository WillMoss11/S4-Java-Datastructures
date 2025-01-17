package Assignments;

/**
 * Calculate the average temperature, and give how many temperatures are above the average temperature
  1. Take an input from the user (eg. 5)
  2. Prompt the user to enter all the 5 numbers (temperature values)
  3. Calculate the average temperature
  4. Given the average temperature, how many of the numbers in the line 2 are above the average temperature?
*/

import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Step 1: Input for the number of days
        System.out.print("Enter the number of temperature readings: ");
        int numTemperatures = scanner.nextInt();

        //Step 2: Create array to store temperature values
        double[] temperatures = new double[numTemperatures];

        //Prompt user to enter the temperatures
        System.out.print("Enter the temperature readings: ");
        for (int i = 0; i < numTemperatures; i++) {
            System.out.print("Temperature " + (i + 1) + ": ");
            temperatures[i] = scanner.nextDouble();
        }

        //Step 3: Calculate average temperature
        double total = 0;
        for (int i = 0; i < numTemperatures; i++) {
            total += temperatures[i];
        }
        double averagetemperature = total / numTemperatures;

        //Step 4: Count how many temperatures are above the average
        int countAboveAverage = 0;
        for (int i = 0; i < numTemperatures; i++) {
            if (temperatures[i] > averagetemperature) {
                countAboveAverage++;
            }
        }

        //Output results
        System.out.println("The average temperature is " + averagetemperature);
        System.out.println("Number of temperatures above the average is " + countAboveAverage);

        scanner.close();
    }
}
