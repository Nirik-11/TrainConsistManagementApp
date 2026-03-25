import java.util.LinkedHashSet;

public class TrainConsistManagementApp {

    public static void main(String[] args) {


        LinkedHashSet<String> trainFormation = new LinkedHashSet<>();

        // Add bogies
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");


        trainFormation.add("Sleeper"); // duplicate, will be ignored


        System.out.println("Final Train Formation (Ordered & Unique):");
        System.out.println(trainFormation);
    }
}