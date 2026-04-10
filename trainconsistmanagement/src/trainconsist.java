import java.util.HashMap;
import java.util.Map;

public class trainconsist {

    public static void main(String[] args) {

        // Step 1: Create HashMap for bogie-capacity mapping
        HashMap<String, Integer> bogieMap = new HashMap<>();

        // Step 2: Insert bogie-capacity pairs
        bogieMap.put("Sleeper", 72);
        bogieMap.put("AC Chair", 78);
        bogieMap.put("First Class", 24);

        // Step 3: Display all bogie capacity details
        System.out.println("Train Bogie Capacity Details:");

        for (Map.Entry<String, Integer> entry : bogieMap.entrySet()) {
            System.out.println("Bogie: " + entry.getKey() +
                    " | Capacity: " + entry.getValue());
        }
    }
}