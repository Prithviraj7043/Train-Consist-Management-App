import java.util.Arrays;

public class TrainConsistApp {

    // 🔹 Sort bogie names using built-in Arrays.sort()
    public static String[] sortBogieNames(String[] bogieNames) {

        Arrays.sort(bogieNames); // Natural alphabetical ordering

        return bogieNames;
    }

    public static void main(String[] args) {

        String[] bogies = {
                "Luxury",
                "General",
                "Sleeper",
                "AC Chair",
                "First Class"
        };

        System.out.println("Original Bogies: " + Arrays.toString(bogies));

        String[] sorted = sortBogieNames(bogies);

        System.out.println("Sorted Bogies: " + Arrays.toString(sorted));
    }
}