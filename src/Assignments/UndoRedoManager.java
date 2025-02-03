
/**
 * Implement an application that supports undo/redo functionality.
 * Use a linked list to maintain a sequence of states.
 * Each state change is stored as a node in the list, allowing for easy navigation.
 * 1<>2<>3<>4<>5
 */


package Assignments;

public class UndoRedoManager<T> {
    // Node class to hold the state and references to previous/next nodes
    private class Node {
        private T state;
        private Node prev;
        private Node next;

        private Node(T state) {
            this.state = state;
        }
    }

    // Current state pointer
    private Node currentState;

    // Undo operation
    public T undo() {
        // Check if we can undo (i.e., if we're not already at the first state)
        if (currentState == null || currentState.prev == null) {
            System.out.println("No more states to undo.");
            return null;
        }

        // Move current state pointer to the previous node (undo operation)
        currentState = currentState.prev;
        System.out.println("Undo: " + currentState.state);
        return currentState.state;
    }

    // Redo operation
    public T redo() {
        // Check if we can redo (i.e., if there's a next state to go to)
        if (currentState == null || currentState.next == null) {
            System.out.println("No more states to redo.");
            return null;
        }

        // Move current state pointer to the next node (redo operation)
        currentState = currentState.next;
        System.out.println("Redo: " + currentState.state);
        return currentState.state;
    }

    // Add a new state to the sequence (linked list)
    public void addState(T newState) {
        Node newNode = new Node(newState);

        if (currentState == null) {
            // If no states yet, set the current state to the new state
            currentState = newNode;
        } else {
            // Link the current state to the new state and set the new state as current
            currentState.next = newNode;
            newNode.prev = currentState;
            currentState = newNode;
        }
        System.out.println("Added state: " + newState);
    }

    // Helper function to display the sequence of states
    public void display() {
        Node temp = currentState;
        System.out.print("States: ");
        while (temp != null) {
            System.out.print(temp.state + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        UndoRedoManager<Integer> manager = new UndoRedoManager<>();

        // Adding states
        System.out.println("Adding states:");
        manager.addState(1);
        manager.addState(2);
        manager.addState(3);

        manager.display();

        // Undo operations
        System.out.println("Undo operations:");
        manager.undo();
        manager.display();
        manager.undo();
        manager.display();

        // Redo operations
        System.out.println("Redo operations:");
        manager.redo();
        manager.display();
        manager.redo();
        manager.display();
    }
}



















