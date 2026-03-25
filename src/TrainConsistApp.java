import java.util.*;

// Represents a bogie request
class BogieRequest {
    private final String bogieId;
    private final String bogieType;

    public BogieRequest(String bogieId, String bogieType) {
        this.bogieId = bogieId;
        this.bogieType = bogieType;
    }

    public String getBogieId() {
        return bogieId;
    }

    public String getBogieType() {
        return bogieType;
    }
}

// Main Application
public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // UC5: Queue (incoming requests)
        Queue<BogieRequest> requestQueue = new LinkedList<>();
        requestQueue.add(new BogieRequest("BG101", "Sleeper"));
        requestQueue.add(new BogieRequest("BG102", "AC"));
        requestQueue.add(new BogieRequest("BG103", "Cargo"));
        requestQueue.add(new BogieRequest("BG101", "Sleeper")); // Duplicate ID

        // UC6: Track allocated bogie IDs (Uniqueness)
        Set<String> allocatedBogieIds = new HashSet<>();

        // UC6: Map bogie type → allocated IDs
        Map<String, Set<String>> bogieAllocationMap = new HashMap<>();

        // UC4 reused: Maintain ordered consist
        LinkedList<String> trainConsist = new LinkedList<>();

        // Process Queue (FIFO)
        System.out.println("\nProcessing bogie requests...\n");

        while (!requestQueue.isEmpty()) {

            BogieRequest request = requestQueue.poll();
            String id = request.getBogieId();
            String type = request.getBogieType();

            // Check for duplicate bogie ID
            if (allocatedBogieIds.contains(id)) {
                System.out.println("Duplicate Bogie ID detected: " + id + " → Skipping");
                continue;
            }

            // Allocate bogie
            allocatedBogieIds.add(id);

            // Update Map (type → IDs)
            bogieAllocationMap.putIfAbsent(type, new HashSet<>());
            bogieAllocationMap.get(type).add(id);

            // Update Train Consist (order maintained)
            trainConsist.add(type + "-" + id);

            System.out.println("Allocated Bogie: " + type + " (" + id + ")");
        }

        // Final Outputs
        System.out.println("\nFinal Train Consist:");
        System.out.println(trainConsist);

        System.out.println("\nAllocated Bogie IDs:");
        System.out.println(allocatedBogieIds);

        System.out.println("\nBogie Type Mapping:");
        System.out.println(bogieAllocationMap);

        System.out.println("\nSystem allocation complete.");
    }
}