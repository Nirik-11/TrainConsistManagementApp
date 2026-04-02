import java.util.*;
import java.util.stream.Collectors;

class PassengerBogie {
    private String type;   // e.g., Sleeper, AC Chair, First Class
    private int capacity;  // seat capacity

    public PassengerBogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "PassengerBogie{" + "type='" + type + '\'' + ", capacity=" + capacity + '}';
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // Prepare dataset
        List<PassengerBogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            bogies.add(new PassengerBogie("Sleeper", 50 + (i % 30))); // capacities between 50–79
        }

        // Loop-based filtering
        long startLoop = System.nanoTime();
        List<PassengerBogie> loopFiltered = new ArrayList<>();
        for (PassengerBogie b : bogies) {
            if (b.getCapacity() > 60) {
                loopFiltered.add(b);
            }
        }
        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // Stream-based filtering
        long startStream = System.nanoTime();
        List<PassengerBogie> streamFiltered = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // Results
        System.out.println("Loop-based result size: " + loopFiltered.size());
        System.out.println("Stream-based result size: " + streamFiltered.size());
        System.out.println("Loop execution time (ns): " + loopTime);
        System.out.println("Stream execution time (ns): " + streamTime);
    }
}