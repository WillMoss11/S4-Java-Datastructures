package Assignments.LinkedList;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();

        // Insert at specific locations
        sll.insertInLinkedList(1, 0); // Insert 1 at index 0
        sll.insertInLinkedList(2, 1); // Insert 2 at index 1
        sll.insertInLinkedList(3, 2); // Insert 3 at index 2
        sll.insertInLinkedList(4, 3); // Insert 4 at index 3

        // Traverse and print the list
        System.out.println("Linked List after insertions:");
        sll.traverseLinkedList();

        // Search for a node (not found in this case)
        System.out.println("Searching for node 5:");
        sll.searchNode(5);

        // Perform undo operation and print list again
        System.out.println("\nAfter Undo:");
        sll.undo();
        sll.traverseLinkedList();

        // Perform redo operation and print list again
        System.out.println("\nAfter Redo:");
        sll.redo();
        sll.traverseLinkedList();
    }
}





