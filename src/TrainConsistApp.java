import java.util.*;
import java.util.stream.Collectors;

// Bogie Class (UC7, UC8)
class Bogie {
    private String id;
    private String type;
    private int capacity;

    public Bogie(String id, String type, int capacity) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
    }

    public String getId() { return id; }
    public String getType() { return type; }
    public int getCapacity() { return capacity; }

    @Override
    public String toString() {
        return type + " (" + id + ", Capacity: " + capacity + ")";
    }
}

// Request Class (UC5)
class BogieRequest {
    private String id;
    private String type;
    private int capacity;

    public BogieRequest(String id, String type, int capacity) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
    }

    public String getId() { return id; }
    public String getType() { return type; }
    public int getCapacity() { return capacity; }
}

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // =========================
        // UC1: Initialize Train
        // =========================
        List<String> initialConsist = new ArrayList<>();
        System.out.println("\nUC1: Initial bogie count: " + initialConsist.size());

        // =========================
        // UC2: ArrayList Operations
        // =========================
        List<String> passengerBogies = new ArrayList<>();
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        passengerBogies.remove("AC Chair");
        System.out.println("\nUC2: Passenger Bogies: " + passengerBogies);
        System.out.println("Sleeper exists? " + passengerBogies.contains("Sleeper"));

        // =========================
        // UC3: HashSet (Unique IDs)
        // =========================
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG101"); // duplicate

        System.out.println("\nUC3: Unique Bogie IDs: " + bogieIds);

        // =========================
        // UC4: LinkedList (Ordered Train)
        // =========================
        LinkedList<String> trainConsist = new LinkedList<>();
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        trainConsist.add(2, "Pantry");
        trainConsist.removeFirst();
        trainConsist.removeLast();

        System.out.println("\nUC4: Ordered Train Consist: " + trainConsist);

        // =========================
        // UC5: Queue (Request Intake)
        // =========================
        Queue<BogieRequest> requestQueue = new LinkedList<>();
        requestQueue.add(new BogieRequest("BG201", "Sleeper", 72));
        requestQueue.add(new BogieRequest("BG202", "AC Chair", 56));
        requestQueue.add(new BogieRequest("BG203", "First Class", 24));

        System.out.println("\nUC5: Requests in Queue:");
        for (BogieRequest r : requestQueue) {
            System.out.println(r.getType() + " (" + r.getId() + ")");
        }

        // =========================
        // UC6: Allocation Engine
        // =========================
        Set<String> allocatedIds = new HashSet<>();
        Map<String, Set<String>> allocationMap = new HashMap<>();
        List<Bogie> allocatedBogies = new ArrayList<>();

        System.out.println("\nUC6: Processing Requests...");

        while (!requestQueue.isEmpty()) {
            BogieRequest req = requestQueue.poll();

            if (allocatedIds.contains(req.getId())) {
                System.out.println("Duplicate ID: " + req.getId());
                continue;
            }

            allocatedIds.add(req.getId());

            allocationMap.putIfAbsent(req.getType(), new HashSet<>());
            allocationMap.get(req.getType()).add(req.getId());

            Bogie bogie = new Bogie(req.getId(), req.getType(), req.getCapacity());
            allocatedBogies.add(bogie);

            System.out.println("Allocated: " + bogie);
        }

        // =========================
        // UC7: Sorting (Comparator)
        // =========================
        allocatedBogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("\nUC7: Sorted Bogies (by Capacity):");
        allocatedBogies.forEach(System.out::println);

        // =========================
        // UC8: Stream Filtering
        // =========================
        List<Bogie> filteredBogies = allocatedBogies.stream()
                .filter(b -> b.getCapacity() > 50)
                .collect(Collectors.toList());

        System.out.println("\nUC8: Filtered Bogies (Capacity > 50):");
        filteredBogies.forEach(System.out::println);

        // Final State
        System.out.println("\nFinal Allocation Map:");
        System.out.println(allocationMap);

        System.out.println("\n=== System Execution Complete ===");
    }
}
