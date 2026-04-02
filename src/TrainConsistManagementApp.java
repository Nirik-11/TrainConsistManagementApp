import java.util.*;
import java.util.stream.*;

class GoodsBogie {
    private String type;   // e.g., Cylindrical, Box, Open
    private String cargo;  // e.g., Petroleum, Coal, Grain

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

    @Override
    public String toString() {
        return "GoodsBogie{" + "type='" + type + '\'' + ", cargo='" + cargo + '\'' + '}';
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // Sample bogie list
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Box", "Coal"),
                new GoodsBogie("Open", "Grain"),
                new GoodsBogie("Cylindrical", "Petroleum")
        );

        // Safety compliance check
        boolean isSafe = bogies.stream()
                .allMatch(b -> {
                    if (b.getType().equalsIgnoreCase("Cylindrical")) {
                        return b.getCargo().equalsIgnoreCase("Petroleum");
                    }
                    return true; // Non-cylindrical bogies can carry any cargo
                });

        // Display result
        if (isSafe) {
            System.out.println("✅ Train formation is SAFE.");
        } else {
            System.out.println("❌ Train formation is UNSAFE due to cargo violation.");
        }
    }
}