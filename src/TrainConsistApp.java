import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    private String type;
    private int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }
}

public class TrainConsistApp {

    // 🔹 Loop-based filtering
    public static List<Bogie> filterUsingLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // 🔹 Stream-based filtering
    public static List<Bogie> filterUsingStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        // Create dataset
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Passenger", (i % 100) + 1));
        }

        // 🔹 Loop Benchmark
        long startLoop = System.nanoTime();
        List<Bogie> loopResult = filterUsingLoop(bogies);
        long endLoop = System.nanoTime();

        // 🔹 Stream Benchmark
        long startStream = System.nanoTime();
        List<Bogie> streamResult = filterUsingStream(bogies);
        long endStream = System.nanoTime();

        // Calculate time
        long loopTime = endLoop - startLoop;
        long streamTime = endStream - startStream;

        // Output
        System.out.println("Loop Result Size: " + loopResult.size());
        System.out.println("Stream Result Size: " + streamResult.size());

        System.out.println("Loop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);
    }
}