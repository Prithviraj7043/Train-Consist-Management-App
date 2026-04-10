import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class test {
    TrainConsistApp TrainSafetyApp;
    // ✅ All valid cylindrical bogies
    @Test
    public void testSafety_AllBogiesValid() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal")
        );


        assertTrue(TrainSafetyApp.isTrainSafe(bogies));
    }

    // ❌ Cylindrical with invalid cargo
    @Test
    public void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Coal")
        );

        assertFalse(TrainSafetyApp.isTrainSafe(bogies));
    }

    // ✅ Non-cylindrical allowed any cargo
    @Test
    public void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Grain")
        );

        assertTrue(TrainSafetyApp.isTrainSafe(bogies));
    }

    // ❌ Mixed bogies with one violation
    @Test
    public void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Cylindrical", "Coal") // violation
        );

        assertFalse(TrainSafetyApp.isTrainSafe(bogies));
    }

    // ✅ Empty list handling
    @Test
    public void testSafety_EmptyBogieList() {
        List<GoodsBogie> bogies = new ArrayList<>();

        assertTrue(TrainSafetyApp.isTrainSafe(bogies));
    }
}