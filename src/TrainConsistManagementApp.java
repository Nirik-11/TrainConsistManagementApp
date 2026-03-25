import java.util.*;


class Bogie {
    String name;
    int capacity;


    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }


    @Override
    public String toString() {
        return name + " - Capacity: " + capacity;
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {


        List<Bogie> bogies = new ArrayList<>();

        // Add bogies
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 54));
        bogies.add(new Bogie("First Class", 24));

        System.out.println("Before Sorting:\n");
        for (Bogie b : bogies) {
            System.out.println(b);
        }


        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting by Capacity (Ascending):\n");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
    }
}