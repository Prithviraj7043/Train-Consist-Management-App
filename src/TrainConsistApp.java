import java.util.ArrayList;
import java.util.List;

class GoodsBogie {
    private String type;   // Cylindrical, Open, Box
    private String cargo;  // Petroleum, Coal, Grain

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }
}

public class TrainConsistApp {

    // Safety validation method using Streams
    public static boolean isTrainSafe(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(bogie ->
                        !bogie.getType().equalsIgnoreCase("Cylindrical")
                                || bogie.getCargo().equalsIgnoreCase("Petroleum")
                );
    }

    public static void main(String[] args) {

        List<GoodsBogie> bogies = new ArrayList<>();

        // Sample Data
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));

        boolean isSafe = isTrainSafe(bogies);

        if (isSafe) {
            System.out.println("Train is SAFETY COMPLIANT");
        } else {
            System.out.println("Train is NOT SAFE");
        }
    }
}