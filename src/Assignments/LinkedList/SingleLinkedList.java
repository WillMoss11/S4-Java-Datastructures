package Assignments.LinkedList;

public class SingleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public SingleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(int value, int position) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        } else if (position == 0) {
            newNode.next = head;
            head = newNode;
        } else if (position >= size) {
            tail.next = newNode;
            tail = newNode;
        } else {
            Node temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        size++;
    }

    public void delete(int position) {
        if (head == null) { // Case 0: List is empty
            System.out.println("List is empty.");
            return;
        }

        // Case 1: Delete at the beginning (position 0)
        if (position == 0) {
            head = head.next;
            if (head == null) { // If list becomes empty after deletion
                tail = null;
            }
        }
        // Case 2: Delete at the end (position size - 1)
        else if (position == size - 1) {
            Node temp = head;
            while (temp.next != tail) { // Traverse to the second-last node
                temp = temp.next;
            }
            temp.next = null; // Remove the last node
            tail = temp; // Update tail to the second-last node
        }
        // Case 3: Delete at any other position
        else {
            Node prev = head;
            for (int i = 0; i < position - 1 && prev.next != null; i++) {
                prev = prev.next; // Traverse to the node just before the one to delete
            }
            if (prev.next == null) { // If the position is invalid
                System.out.println("Invalid position.");
                return;
            }
            prev.next = prev.next.next; // Skip over the node to delete
            if (prev.next == null) { // If we deleted the last node
                tail = prev; // Update the tail
            }
        }
        size--; // Decrement size of the list
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public boolean search(int value) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data == value) {
                System.out.println("Found " + value + " at position " + index);
                return true;
            }
            current = current.next;
            index++;
        }
        System.out.println("Value " + value + " not found.");
        return false;
    }
}










