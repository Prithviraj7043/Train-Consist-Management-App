import java.util.*;

// Bogie class with name and capacity
class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " (Capacity: " + capacity + ")";
    }
}

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create List of Bogies
        List<Bogie> bogies = new ArrayList<>();

        // Add Passenger Bogies
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));

        // Display Before Sorting
        System.out.println("\nBefore Sorting:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        // Sort using Comparator (by capacity)
        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        // Display After Sorting
        System.out.println("\nAfter Sorting (by Capacity - Ascending):");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        System.out.println("\nSystem ready for planning and analysis.");
    }
}