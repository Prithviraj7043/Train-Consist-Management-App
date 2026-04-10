import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class test {

    // Helper method to create sample data
    private List<Bogie> createBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 50),
                new Bogie("AC", 70),
                new Bogie("General", 80),
                new Bogie("Chair", 40)
        );
    }

    // ✅ Loop filtering test
    @Test
    public void testLoopFilteringLogic() {
        List<Bogie> result = TrainConsistApp.filterUsingLoop(createBogies());
        assertEquals(2, result.size()); // 70, 80
    }

    // ✅ Stream filtering test
    @Test
    public void testStreamFilteringLogic() {
        List<Bogie> result = TrainConsistApp.filterUsingStream(createBogies());
        assertEquals(2, result.size());
    }

    // ✅ Results should match
    @Test
    public void testLoopAndStreamResultsMatch() {
        List<Bogie> loopResult = TrainConsistApp.filterUsingLoop(createBogies());
        List<Bogie> streamResult = TrainConsistApp.filterUsingStream(createBogies());

        assertEquals(loopResult.size(), streamResult.size());
    }

    // ✅ Execution time measurement
    @Test
    public void testExecutionTimeMeasurement() {
        List<Bogie> bogies = createBogies();

        long start = System.nanoTime();
        TrainConsistApp.filterUsingLoop(bogies);
        long end = System.nanoTime();

        long elapsed = end - start;

        assertTrue(elapsed > 0);
    }

    // ✅ Large dataset test
    @Test
    public void testLargeDatasetProcessing() {
        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Passenger", (i % 100) + 1));
        }

        List<Bogie> result = TrainConsistApp.filterUsingStream(bogies);

        assertTrue(result.size() > 0);
    }
}