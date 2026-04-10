import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
class trainconsistTest {
    import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.stream.Collectors;

    class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public class TrainConsistGroupingTest {

        // Utility method for grouping
        private Map<String, List<Bogie>> groupBogies(List<Bogie> bogies) {
            return bogies.stream()
                    .collect(Collectors.groupingBy(b -> b.name));
        }

        // 1️⃣ Basic grouping test
        @Test
        void testGrouping_BogiesGroupedByType() {
            List<Bogie> bogies = Arrays.asList(
                    new Bogie("Sleeper", 72),
                    new Bogie("Sleeper", 70),
                    new Bogie("AC Chair", 56)
            );

            Map<String, List<Bogie>> result = groupBogies(bogies);

            assertTrue(result.containsKey("Sleeper"));
            assertEquals(2, result.get("Sleeper").size());
        }

        // 2️⃣ Multiple bogies in same group
        @Test
        void testGrouping_MultipleBogiesInSameGroup() {
            List<Bogie> bogies = Arrays.asList(
                    new Bogie("Sleeper", 72),
                    new Bogie("Sleeper", 68)
            );

            Map<String, List<Bogie>> result = groupBogies(bogies);

            assertEquals(2, result.get("Sleeper").size());
        }

        // 3️⃣ Different bogie types
        @Test
        void testGrouping_DifferentBogieTypes() {
            List<Bogie> bogies = Arrays.asList(
                    new Bogie("Sleeper", 72),
                    new Bogie("AC Chair", 56),
                    new Bogie("First Class", 24)
            );

            Map<String, List<Bogie>> result = groupBogies(bogies);

            assertEquals(3, result.size());
        }

        // 4️⃣ Empty list
        @Test
        void testGrouping_EmptyBogieList() {
            List<Bogie> bogies = new ArrayList<>();

            Map<String, List<Bogie>> result = groupBogies(bogies);

            assertTrue(result.isEmpty());
        }

        // 5️⃣ Single category
        @Test
        void testGrouping_SingleBogieCategory() {
            List<Bogie> bogies = Arrays.asList(
                    new Bogie("Sleeper", 72),
                    new Bogie("Sleeper", 65)
            );

            Map<String, List<Bogie>> result = groupBogies(bogies);

            assertEquals(1, result.size());
            assertTrue(result.containsKey("Sleeper"));
        }

        // 6️⃣ Map contains correct keys
        @Test
        void testGrouping_MapContainsCorrectKeys() {
            List<Bogie> bogies = Arrays.asList(
                    new Bogie("Sleeper", 72),
                    new Bogie("AC Chair", 56),
                    new Bogie("First Class", 24)
            );

            Map<String, List<Bogie>> result = groupBogies(bogies);

            assertTrue(result.containsKey("Sleeper"));
            assertTrue(result.containsKey("AC Chair"));
            assertTrue(result.containsKey("First Class"));
        }

        // 7️⃣ Group size validation
        @Test
        void testGrouping_GroupSizeValidation() {
            List<Bogie> bogies = Arrays.asList(
                    new Bogie("Sleeper", 72),
                    new Bogie("Sleeper", 70),
                    new Bogie("AC Chair", 56)
            );

            Map<String, List<Bogie>> result = groupBogies(bogies);

            assertEquals(2, result.get("Sleeper").size());
            assertEquals(1, result.get("AC Chair").size());
        }

        // 8️⃣ Original list unchanged
        @Test
        void testGrouping_OriginalListUnchanged() {
            List<Bogie> bogies = new ArrayList<>();
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 56));

            groupBogies(bogies);

            assertEquals(2, bogies.size()); // unchanged
        }
    }
  
}