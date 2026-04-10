import java.util.LinkedHashSet;

public class trainconsist {

    public static void main(String[] args) {

        // Step 1: Create LinkedHashSet for train formation
        LinkedHashSet<String> train = new LinkedHashSet<>();

        // Step 2: Add bogies
        train.add("Engine");
        train.add("Sleeper");
        train.add("Cargo");
        train.add("Guard");

        // Step 3: Add duplicate bogie
        train.add("Sleeper"); // duplicate (will be ignored)

        // Step 4: Display final train formation
        System.out.println("Train Formation (Ordered & Unique):");
        System.out.println(train);
    }
}