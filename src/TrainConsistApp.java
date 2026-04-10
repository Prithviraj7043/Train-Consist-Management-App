import java.util.*;
import java.util.stream.Collectors;
class Bogie {
    private String type;
    private String id;

    public Bogie(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Bogie{id='" + id + "', type='" + type + "'}";
    }
}

public class TrainConsistApp {

    public static void main(String[] args) {

        // Step 1: Create list of bogies
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("B1", "Sleeper"));
        bogies.add(new Bogie("B2", "AC Chair"));
        bogies.add(new Bogie("B3", "Sleeper"));
        bogies.add(new Bogie("B4", "First Class"));
        bogies.add(new Bogie("B5", "AC Chair"));

        // Step 2: Convert to stream & group by type
        Map<String, List<Bogie>> groupedBogies =
                bogies.stream()
                        .collect(Collectors.groupingBy(Bogie::getType));

        // Step 3: Display grouped result
        System.out.println("Grouped Bogies by Type:");
        groupedBogies.forEach((type, list) -> {
            System.out.println("\nType: " + type);
            list.forEach(System.out::println);
        });

        // Step 4: Verify original list unchanged
        System.out.println("\nOriginal List Size: " + bogies.size());
    }
}