import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class test {

    @Test
    public void testSearch_BogieFound() {
        String[] data = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(TrainConsistApp.searchBogie(data, "BG309"));
    }

    @Test
    public void testSearch_BogieNotFound() {
        String[] data = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(TrainConsistApp.searchBogie(data, "BG999"));
    }

    // ✅ First element match
    @Test
    public void testSearch_FirstElementMatch() {
        String[] data = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(TrainConsistApp.searchBogie(data, "BG101"));
    }

    // ✅ Last element match
    @Test
    public void testSearch_LastElementMatch() {
        String[] data = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(TrainConsistApp.searchBogie(data, "BG550"));
    }

    // ✅ Single element array
    @Test
    public void testSearch_SingleElementArray() {
        String[] data = {"BG101"};
        assertTrue(TrainConsistApp.searchBogie(data, "BG101"));
    }
}