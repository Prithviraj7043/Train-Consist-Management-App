import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

import org.junit.jupiter.api.Test;

public class test {
    TrainConsistApp TrainValidationApp;
    // ✅ Valid Train ID
    @Test
    public void testRegex_ValidTrainID() {
        assertTrue(TrainValidationApp.validateTrainID("TRN-1234"));
    }

    // ❌ Invalid Train ID formats
    @Test
    public void testRegex_InvalidTrainIDFormat() {
        
        assertFalse(TrainValidationApp.validateTrainID("TRAIN12"));
        assertFalse(TrainValidationApp.validateTrainID("TRN12A"));
        assertFalse(TrainValidationApp.validateTrainID("1234-TRN"));
    }

    // ✅ Valid Cargo Code
    @Test
    public void testRegex_ValidCargoCode() {
        assertTrue(TrainValidationApp.validateCargoCode("PET-AB"));
    }

    // ❌ Invalid Cargo Code formats
    @Test
    public void testRegex_InvalidCargoCodeFormat() {
        assertFalse(TrainValidationApp.validateCargoCode("PET-ab"));
        assertFalse(TrainValidationApp.validateCargoCode("PET123"));
        assertFalse(TrainValidationApp.validateCargoCode("AB-PET"));
    }

    // ❌ Train ID digit length validation
    @Test
    public void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(TrainValidationApp.validateTrainID("TRN-123"));
        assertFalse(TrainValidationApp.validateTrainID("TRN-12345"));
    }

    // ❌ Cargo Code uppercase validation
    @Test
    public void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(TrainValidationApp.validateCargoCode("PET-Ab"));
        assertFalse(TrainValidationApp.validateCargoCode("PET-aB"));
    }

    // ❌ Empty input handling
    @Test
    public void testRegex_EmptyInputHandling() {
        assertFalse(TrainValidationApp.validateTrainID(""));
        assertFalse(TrainValidationApp.validateCargoCode(""));
    }

    // ❌ Exact pattern match (no extra characters)
    @Test
    public void testRegex_ExactPatternMatch() {
        assertFalse(TrainValidationApp.validateTrainID("TRN-1234XYZ"));
        assertFalse(TrainValidationApp.validateCargoCode("PET-AB123"));
    }
}