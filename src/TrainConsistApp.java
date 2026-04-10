import java.util.Arrays;

public class TrainConsistApp {

    // 🔹 Bubble Sort implementation (manual sorting)
    public static int[] sortPassengerBogies(int[] capacities) {

        int n = capacities.length;

        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (capacities[j] > capacities[j + 1]) {

                    // swap
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no swaps → already sorted
            if (!swapped) {
                break;
            }
        }

        return capacities;
    }

    public static void main(String[] args) {

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Original Capacities: " + Arrays.toString(capacities));

        int[] sorted = sortPassengerBogies(capacities);

        System.out.println("Sorted Capacities: " + Arrays.toString(sorted));
    }
}