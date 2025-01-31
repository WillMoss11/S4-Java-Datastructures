package Assignments.LinkedList;

import Assignments.UndoRedoManager;

public class SingleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    private UndoRedoManager<SingleLinkedList> undoRedoManager = new UndoRedoManager<>();

    public SingleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Create a new linked list with an initial node value
    public void createLinkedList(int nodeValue) {
        Node node = new Node();
        node.value = nodeValue;
        node.next = null;
        head = node;
        tail = node;
        size = 1;

        undoRedoManager.addState(new SingleLinkedList(this)); // Capture the state
    }

    // Insert a new node into the linked list
    public void insertInLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;

        if (head == null) {
            createLinkedList(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
        } else if (location >= size) {
            tail.next = node;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            node.next = tempNode.next;
            tempNode.next = node;
        }

        size++;
        undoRedoManager.addState(new SingleLinkedList(this)); // Capture the state after insertion
    }

    // Traverse the linked list and print it
    public void traverseLinkedList() {
        if (head == null) {
            System.out.println("SLL does not exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
            System.out.println();
        }
    }

    // Undo the last change (insertion or deletion)
    public void undo() {
        SingleLinkedList previousState = (SingleLinkedList) undoRedoManager.undo();
        if (previousState != null) {
            this.head = previousState.head;
            this.tail = previousState.tail;
            this.size = previousState.size;
        } else {
            System.out.println("No undo available.");
        }
    }

    // Redo the last undone change
    public void redo() {
        SingleLinkedList nextState = (SingleLinkedList) undoRedoManager.redo();
        if (nextState != null) {
            this.head = nextState.head;
            this.tail = nextState.tail;
            this.size = nextState.size;
        } else {
            System.out.println("No redo available.");
        }
    }

    // Search for a node in the linked list
    public boolean searchNode(int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Found the node: " + tempNode.value + " at location: " + i);
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found");
        return false;
    }

    // Copy constructor for saving states
    public SingleLinkedList(SingleLinkedList other) {
        this.head = other.head;
        this.tail = other.tail;
        this.size = other.size;
    }
}










