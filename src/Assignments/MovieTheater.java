package Assignments;

/** Simulate a movie theater that helps users to book and reserve seats.
    1. reserve seats (if seat is taken, let them know it is taken and suggest an available seat)
    2. cancel seats
    3. retrieve initial seating charting
 */


import java.util.Scanner;

public class MovieTheater {
    private char[][] seats;

    public MovieTheater(int rows, int cols) {
        seats = new char[rows][cols];
        initializeTheater();
    }

    // Initialize all seats to 'A'
    private void initializeTheater() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = 'A';
            }
        }
    }

    // Reserve a seat
    public void reserveSeat(int row, int col) {
        if (seats[row][col] == 'R') {
            System.out.println("Seat is already taken. Suggesting a new seat...");
            suggestAvailableSeat();
        } else {
            seats[row][col] = 'R';
            System.out.println("Seat reserved successfully.");
        }
    }

    // Cancel a reservation
    public void cancelReservation(int row, int col) {
        if (seats[row][col] == 'R') {
            seats[row][col] = 'A';
            System.out.println("Reservation cancelled.");
        } else {
            System.out.println("Seat is already available.");
        }
    }

    // Suggest nearest available seat
    private void suggestAvailableSeat() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 'A') {
                    System.out.println("Suggested seat: Row " + i + ", Col " + j);
                    return;
                }
            }
        }
        System.out.println("No available seats.");
    }

    // Display the seating chart
    public void displaySeatingChart() {
        System.out.println("Seating Chart:");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Menu for user interaction
    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Movie Theater Menu ---");
            System.out.println("1. View Seating Chart");
            System.out.println("2. Reserve a Seat");
            System.out.println("3. Cancel a Reservation");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displaySeatingChart();
                    break;
                case 2:
                    System.out.print("Enter row number: ");
                    int reserveRow = scanner.nextInt();
                    System.out.print("Enter column number: ");
                    int reserveCol = scanner.nextInt();
                    if (isValidSeat(reserveRow, reserveCol)) {
                        reserveSeat(reserveRow, reserveCol);
                    } else {
                        System.out.println("Invalid seat! Try again.");
                    }
                    break;
                case 3:
                    System.out.print("Enter row number: ");
                    int cancelRow = scanner.nextInt();
                    System.out.print("Enter column number: ");
                    int cancelCol = scanner.nextInt();
                    if (isValidSeat(cancelRow, cancelCol)) {
                        cancelReservation(cancelRow, cancelCol);
                    } else {
                        System.out.println("Invalid seat! Try again.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the Movie Theater system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        }
    }

    // Check if the seat coordinates are valid
    private boolean isValidSeat(int row, int col) {
        return row >= 0 && row < seats.length && col >= 0 && col < seats[0].length;
    }

    // Main method to run the program
    public static void main(String[] args) {
        MovieTheater theater = new MovieTheater(5, 5); // 5x5 theater
        theater.startMenu();
    }
}


