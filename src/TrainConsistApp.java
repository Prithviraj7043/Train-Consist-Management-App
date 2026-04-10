public class TrainConsistApp {

    // 🔹 Linear Search method
    public static boolean searchBogie(String[] bogieIds, String key) {

        for (int i = 0; i < bogieIds.length; i++) {

            if (bogieIds[i].equals(key)) {
                return true; // 🔹 Early termination when found
            }
        }

        return false; // Not found after full traversal
    }

    public static void main(String[] args) {

        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        String searchKey = "BG309";

        boolean found = searchBogie(bogies, searchKey);

        if (found) {
            System.out.println("Bogie ID " + searchKey + " FOUND in system.");
        } else {
            System.out.println("Bogie ID " + searchKey + " NOT FOUND.");
        }
    }
}