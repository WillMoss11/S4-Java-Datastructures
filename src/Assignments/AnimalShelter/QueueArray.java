package Assignments.AnimalShelter;

import java.util.LinkedList;

public class QueueArray {

    // Inner Animal class representing each animal in the shelter
    private static class Animal {
        private String type;  // Type of animal: "dog" or "cat"
        private String name;  // Name of the animal
        private long arrivalTime;  // Arrival time of the animal to determine adoption order

        // Constructor to initialize the animal
        public Animal(String type, String name, long arrivalTime) {
            this.type = type;
            this.name = name;
            this.arrivalTime = arrivalTime;
        }

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public long getArrivalTime() {
            return arrivalTime;
        }
    }

    private LinkedList<Animal> shelterQueue;  // LinkedList to maintain the queue

    // Constructor to initialize the shelter queue
    public QueueArray() {
        shelterQueue = new LinkedList<>();
    }

    // Enqueue operation: Add an animal to the queue
    public void enqueue(Animal animal) {
        shelterQueue.add(animal);
    }

    // Dequeue operation: Adopt any animal (the oldest one)
    public Animal dequeueAny() {
        return shelterQueue.poll();  // Removes and returns the first animal in the queue
    }

    // Dequeue operation: Adopt the oldest dog
    public Animal dequeueDog() {
        // Loop through the queue to find the first dog and remove it
        for (Animal animal : shelterQueue) {
            if (animal.getType().equals("dog")) {
                shelterQueue.remove(animal);
                return animal;
            }
        }
        return null;  // Return null if no dog is available
    }

    // Dequeue operation: Adopt the oldest cat
    public Animal dequeueCat() {
        // Loop through the queue to find the first cat and remove it
        for (Animal animal : shelterQueue) {
            if (animal.getType().equals("cat")) {
                shelterQueue.remove(animal);
                return animal;
            }
        }
        return null;  // Return null if no cat is available
    }

    // Method to get the current size of the shelter (number of animals)
    public int size() {
        return shelterQueue.size();
    }
}
