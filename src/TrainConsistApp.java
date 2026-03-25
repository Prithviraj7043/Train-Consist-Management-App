import java.util.ArrayList;
import java.util.List;

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create ArrayList for Passenger Bogies
        List<String> passengerBogies = new ArrayList<>();

        // Adding Passenger Bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Display Bogies after Addition
        System.out.println("\nPassenger bogies after addition:");
        System.out.println(passengerBogies);

        // Remove a Bogie (AC Chair)
        passengerBogies.remove("AC Chair");

        // Display after Removal
        System.out.println("\nPassenger bogies after removal:");
        System.out.println(passengerBogies);

        // Check Existence of Sleeper
        boolean exists = passengerBogies.contains("Sleeper");
        System.out.println("\nIs 'Sleeper' present? " + exists);

        // Final State
        System.out.println("\nFinal passenger bogie list:");
        System.out.println(passengerBogies);

        System.out.println("\nSystem ready for further operations.");
    }
}