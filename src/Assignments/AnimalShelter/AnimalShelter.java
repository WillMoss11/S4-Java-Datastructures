package Assignments.AnimalShelter;

import java.util.LinkedList;

public class AnimalShelter {

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

    // QueueArray class to manage the shelter queue of animals
    private static class QueueArray {
        private LinkedList<Animal> shelterQueue;  // LinkedList to maintain the queue

        // Constructor to initialize the shelter queue
        public QueueArray() {
            shelterQueue = new LinkedList<>();
        }

        // Add an animal to the queue
        public void enqueue(Animal animal) {
            shelterQueue.add(animal);
        }

        // Adopt any animal (the oldest one)
        public Animal dequeueAny() {
            return shelterQueue.poll();  // Removes and returns the first animal in the queue
        }

        // Adopt the oldest dog
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

        // Adopt the oldest cat
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

    // Instance of QueueArray to manage the shelter's animal queue
    private QueueArray shelter;

    // Initialize the shelter
    public AnimalShelter() {
        shelter = new QueueArray();
    }

    // Method to admit a new animal to the shelter (either a dog or cat)
    public void admitAnimal(String type, String name) {
        long arrivalTime = System.currentTimeMillis(); // Get the current time as the arrival time
        Animal animal = new Animal(type, name, arrivalTime);
        shelter.enqueue(animal);  // Add the animal to the shelter queue
    }

    // Method to adopt any animal (oldest one in the shelter)
    public Animal adoptAny() {
        return shelter.dequeueAny();  // Adopt the oldest animal
    }

    // Method to adopt a dog (oldest dog in the shelter)
    public Animal adoptDog() {
        return shelter.dequeueDog();  // Adopt the oldest dog
    }

    // Method to adopt a cat (oldest cat in the shelter)
    public Animal adoptCat() {
        return shelter.dequeueCat();  // Adopt the oldest cat
    }

    // Method to get the number of remaining animals in the shelter
    public int getNumberOfAnimals() {
        return shelter.size();  // Return the size of the shelter queue
    }

    // Main method to test the shelter
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();

        // Admit animals to the shelter
        shelter.admitAnimal("dog", "Rex");
        shelter.admitAnimal("cat", "Whiskers");
        shelter.admitAnimal("dog", "Buddy");
        shelter.admitAnimal("cat", "Fluffy");

        // Adopt animals
        System.out.println("Adopting any animal: " + shelter.adoptAny().getName());
        System.out.println("Adopting a dog: " + shelter.adoptDog().getName());
        System.out.println("Adopting a cat: " + shelter.adoptCat().getName());

        // Print the number of remaining animals in the shelter
        System.out.println("Animals left in shelter: " + shelter.getNumberOfAnimals());
    }
}

