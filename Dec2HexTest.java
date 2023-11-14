import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Dec2HexTest {
    private String capturedOutput;
    //Variable to capture the exit codes 0 & 1 
    private int capturedExitCode;

    @Before
    public void setUp() {
        // Redirect System.out.println() to capture the output
        System.setOut(new java.io.PrintStream(System.out) {
            public void println(String s) {
                capturedOutput = s;
            }
        });
    }

    @Test
    public void testConversionWithValidInput() {
        String[] args = {"15"};
        Dec2Hex.main(args);
        assertEquals("Hexadecimal representation is: F", capturedOutput.trim());

        String actualOutput = capturedOutput.trim();
        String expectedOutput = "Hexadecimal representation is: F";

        assertTrue(actualOutput.startsWith("Hexadecimal representation is:"));
        assertTrue(actualOutput.contains("F"));
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testConversionWithNoInputArgument() {
        String[] args = {};
        try {
            Dec2Hex.main(args);
            fail("Expected System.exit(1) for missing input argument");
        } catch (SecurityException e) { 
            assertEquals("System.exit() is not allowed", e.getMessage());
            assertEquals(1, capturedExitCode);                
        }
    }

    @Test
    public void testConversionWithNonIntegerInput() {
        String[] args = {"abc"};
        try {
            Dec2Hex.main(args);
            fail("Expected System.exit(0) for non-integer input");
        } catch (SecurityException e) {
            assertEquals("System.exit() is not allowed", e.getMessage());
            assertEquals(0, capturedExitCode);
        }
    }
}
