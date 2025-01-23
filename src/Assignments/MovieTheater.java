package Assignments;

/** Simulate a movie theater that helps users to book and reserve seats.
    1. reserve seats (if seat is taken, let them know it is taken and suggest an available seat)
    2. cancel seats
    3. retrieve initial seating charting
 */


public class MovieTheater {
    private char[][] seats;

    public MovieTheater(int rows, int cols) {
        seats = new char[rows][cols];
        initializeTheater();
    }

    // Initialize all seats to A
    private void initializeTheater() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = 'A';
            }
        }
    }

    // Reserve a Seat
}
