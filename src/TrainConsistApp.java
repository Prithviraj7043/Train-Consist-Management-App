import java.util.*;
import java.util.stream.Collectors;

class InvalidCapacityException extends Exception {

    public InvalidCapacityException(String message) {
        super(message);
    }
}

class PassengerBogie {

    private String type;
    private int capacity;


    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {

        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }

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

    public static void main(String[] args) {

        try {

            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Bogie Created: " + b1.getType() + " - " + b1.getCapacity());


            PassengerBogie b2 = new PassengerBogie("AC", -10);
            System.out.println("Bogie Created: " + b2.getType());

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Program continues safely...");
    }
}