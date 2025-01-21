package Assignments;

/**
 * Calculate the average temperature, and give how many days are above the average temperature
  1. Take an input from the user (eg. 5)
  2. Prompt the user to enter all the 5 numbers (temperature values)
  3. Calculate the average temperature
  4. Given the average temperature, how many of the numbers in the line 2 are above the average temperature?
*/

import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of days
        System.out.print("Enter the number of days: ");
        int numDays = scanner.nextInt();

        // Collect the temperatures
        double[] temperatures = new double[numDays];
        double sum = 0;
        for (int i = 0; i < numDays; i++) {
            System.out.print("Enter temperature for day " + (i + 1) + ": ");
            temperatures[i] = scanner.nextDouble();
            sum += temperatures[i];
        }

        // Calculate the average temperature
        double average = sum / numDays;
        System.out.println("Average temperature: " + average);

        // Count the days above average
        int countAboveAverage = 0;
        for (double temp : temperatures) {
            if (temp > average) {
                countAboveAverage++;
            }
        }

        System.out.println("Number of days above average temperature: " + countAboveAverage);
    }
}

