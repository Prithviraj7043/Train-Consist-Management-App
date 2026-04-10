import java.util.*;
import java.util.stream.Collectors;

class CargoSafetyException extends RuntimeException {

    public CargoSafetyException(String message) {
        super(message);
    }
}

class GoodsBogie {

    private String type;   // Cylindrical, Rectangular
    private String cargo;  // Petroleum, Coal, etc.

    public GoodsBogie(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    // 🔹 Safe cargo assignment method
    public void assignCargo(String cargo) {
        try {
            // Validation rule
            if (type.equalsIgnoreCase("Rectangular") &&
                    cargo.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                        "Unsafe: Cannot assign Petroleum to Rectangular bogie");
            }

            // If safe → assign
            this.cargo = cargo;
            System.out.println("Cargo assigned: " + cargo);

        } catch (CargoSafetyException e) {
            // Handle exception gracefully
            System.out.println("Error: " + e.getMessage());

        } finally {
            // Always executes
            System.out.println("Cargo assignment attempt completed.\n");
        }
    }
}
public class TrainConsistApp {

    public static void main(String[] args) {

        // ✅ Safe assignment
        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        b1.assignCargo("Petroleum");

        // ❌ Unsafe assignment (handled)
        GoodsBogie b2 = new GoodsBogie("Rectangular");
        b2.assignCargo("Petroleum");

        // ✅ Program continues
        GoodsBogie b3 = new GoodsBogie("Rectangular");
        b3.assignCargo("Coal");

        System.out.println("Program continues safely...");
    }
}