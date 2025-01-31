package Assignments;

/**
 * Implement an application that supports undo/redo functionality.
 * Use a linked list to maintain a sequence of states.
 * Each state change is stored as a node in the list, allowing for easy navigation
 * 1<>2<>3<>4<>5
 */


public class UndoRedoManager<T> {
    private class Node {
        private T state;
        private Node prev;
        private Node next;

        private Node(T state) {
            this.state = state;
        }
    }

    private Node currentState;

    // Undo operation
    public T undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            return currentState.state;
        }
        System.out.println("No undo available.");
        return null;
    }

    // Add a new state to the history
    public void addState(T newState) {
        Node newNode = new Node(newState);
        if (currentState != null) {
            currentState.next = newNode;
            newNode.prev = currentState;
        }
        currentState = newNode;
    }

    // Redo operation
    public T redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            return currentState.state;
        }
        System.out.println("No redo available.");
        return null;
    }

    public static void main(String[] args) {
        UndoRedoManager<String> undoRedoManager = new UndoRedoManager<>();

        // Testing undo/redo functionality
        undoRedoManager.addState("State 1");
        undoRedoManager.addState("State 2");
        undoRedoManager.addState("State 3");

        System.out.println("Undo last change: " + undoRedoManager.undo());
        System.out.println("Redo last undone change: " + undoRedoManager.redo());
    }
}






