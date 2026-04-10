import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class test {

    // ✅ Basic sorting test
    @Test
    public void testSort_BasicSorting() {
        int[] input = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};

        assertArrayEquals(expected, TrainConsistApp.sortPassengerBogies(input));
    }

    // ✅ Already sorted array
    @Test
    public void testSort_AlreadySortedArray() {
        int[] input = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};

        assertArrayEquals(expected, TrainConsistApp.sortPassengerBogies(input));
    }

    // ✅ Duplicate values
    @Test
    public void testSort_DuplicateValues() {
        int[] input = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};

        assertArrayEquals(expected, TrainConsistApp.sortPassengerBogies(input));
    }

    // ✅ Single element array
    @Test
    public void testSort_SingleElementArray() {
        int[] input = {50};
        int[] expected = {50};

        assertArrayEquals(expected, TrainConsistApp.sortPassengerBogies(input));
    }

    // ✅ All equal values
    @Test
    public void testSort_AllEqualValues() {
        int[] input = {40, 40, 40};
        int[] expected = {40, 40, 40};

        assertArrayEquals(expected, TrainConsistApp.sortPassengerBogies(input));
    }
}