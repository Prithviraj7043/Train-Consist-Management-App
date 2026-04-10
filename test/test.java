import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class test {

    // ✅ Safe assignment
    @Test
    public void testCargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("Cylindrical");
        bogie.assignCargo("Petroleum");

        assertEquals("Petroleum", bogie.getCargo());
    }

    // ❌ Unsafe assignment handled
    @Test
    public void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        assertDoesNotThrow(() -> {
            bogie.assignCargo("Petroleum");
        });
    }

    // ❌ Cargo should NOT be assigned after failure
    @Test
    public void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");

        assertNull(bogie.getCargo());
    }

    // ✅ Program continues after exception
    @Test
    public void testCargo_ProgramContinuesAfterException() {
        GoodsBogie b1 = new GoodsBogie("Rectangular");
        GoodsBogie b2 = new GoodsBogie("Cylindrical");

        assertDoesNotThrow(() -> {
            b1.assignCargo("Petroleum"); // fails
            b2.assignCargo("Petroleum"); // succeeds
        });

        assertEquals("Petroleum", b2.getCargo());
    }

    // ✅ Finally block execution (indirect validation)
    @Test
    public void testCargo_FinallyBlockExecution() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        assertDoesNotThrow(() -> {
            bogie.assignCargo("Petroleum");
        });
    }
}