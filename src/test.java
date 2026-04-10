import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class test {

    // ✅ Basic alphabetical sorting
    @Test
    public void testSort_BasicAlphabeticalSorting() {
        String[] input = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        String[] expected = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};

        assertArrayEquals(expected, TrainConsistApp.sortBogieNames(input));
    }

    // ✅ Unsorted input handling
    @Test
    public void testSort_UnsortedInput() {
        String[] input = {"Luxury", "General", "Sleeper", "AC Chair"};
        String[] expected = {"AC Chair", "General", "Luxury", "Sleeper"};

        assertArrayEquals(expected, TrainConsistApp.sortBogieNames(input));
    }

    // ✅ Already sorted array
    @Test
    public void testSort_AlreadySortedArray() {
        String[] input = {"AC Chair", "First Class", "General"};
        String[] expected = {"AC Chair", "First Class", "General"};

        assertArrayEquals(expected, TrainConsistApp.sortBogieNames(input));
    }

    // ✅ Duplicate bogie names
    @Test
    public void testSort_DuplicateBogieNames() {
        String[] input = {"Sleeper", "AC Chair", "Sleeper", "General"};
        String[] expected = {"AC Chair", "General", "Sleeper", "Sleeper"};

        assertArrayEquals(expected, TrainConsistApp.sortBogieNames(input));
    }

    // ✅ Single element array
    @Test
    public void testSort_SingleElementArray() {
        String[] input = {"Sleeper"};
        String[] expected = {"Sleeper"};

        assertArrayEquals(expected, TrainConsistApp.sortBogieNames(input));
    }
}