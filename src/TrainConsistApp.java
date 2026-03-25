import java.util.LinkedList;
import java.util.Queue;

// Represents a request to add a bogie
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

    @Override
    public String toString() {
        return "BogieRequest [ID=" + bogieId + ", Type=" + bogieType + "]";
    }
}

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Queue to handle incoming bogie attachment requests
        Queue<BogieRequest> requestQueue = new LinkedList<>();

        // Step 1: Add requests (simulating user/system input)
        requestQueue.add(new BogieRequest("BG101", "Sleeper"));
        requestQueue.add(new BogieRequest("BG102", "AC Chair"));
        requestQueue.add(new BogieRequest("BG103", "Cargo"));
        requestQueue.add(new BogieRequest("BG104", "First Class"));

        // Step 2: Display all requests in order
        System.out.println("\nBogie attachment requests (FIFO order):");
        for (BogieRequest req : requestQueue) {
            System.out.println(req);
        }

        // Step 3: Show next request (without removing)
        System.out.println("\nNext request to process:");
        System.out.println(requestQueue.peek());

        // No actual attachment to train yet
        System.out.println("\nRequests are queued and waiting for processing...");

        System.out.println("\nSystem ready for allocation phase.");
    }
}