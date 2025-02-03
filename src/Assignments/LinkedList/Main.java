package Assignments.LinkedList;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

        // Adding nodes to the list
        list.add(1, 0); // List: 1
        list.add(2, 1); // List: 1 -> 2
        list.add(3, 2); // List: 1 -> 2 -> 3
        list.add(4, 3); // List: 1 -> 2 -> 3 -> 4
        list.display(); // Expected output: 1 -> 2 -> 3 -> 4 -> null

        // Deleting from different positions
        System.out.println("Deleting at position 0:");
        list.delete(0); // Delete the first node (1)
        list.display(); // Expected output: 2 -> 3 -> 4 -> null

        System.out.println("Deleting at position 3:");
        list.delete(3); // Try to delete at position 3 (invalid)
        list.display(); // Expected output: 2 -> 3 -> 4 -> null (invalid position)

        System.out.println("Deleting at position 2:");
        list.delete(2); // Delete the last node (4)
        list.display(); // Expected output: 2 -> 3 -> null

        System.out.println("Deleting at position 1:");
        list.delete(1); // Delete the second node (3)
        list.display(); // Expected output: 2 -> null

        System.out.println("Deleting at position 0:");
        list.delete(0); // Delete the last remaining node (2)
        list.display(); // Expected output: null (empty list)

        // Trying to delete from an empty list
        System.out.println("Trying to delete from an empty list:");
        list.delete(0); // Expected output: List is empty.
    }
}






