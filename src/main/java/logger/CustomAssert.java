package logger;

import org.apache.logging.log4j.Level;
import org.testng.Assert;

public class CustomAssert {

    public static final Level PASS = Level.forName("PASS", 90);
    private static final Level FAIL = Level.forName("FAIL", 50);
    public static final String FAILED_MESSAGE = "Test Case Failed";
    private static final String SEPARATOR = "\n--------------------------------------------\n";
    private static final String MESSAGEFORMAT = "\n%s" + SEPARATOR + "Actual Result:  %s\nExpected Reslt: %s\n";

    public static void assertEquals(String actual, String expected, String description) {
        try {
            Assert.assertEquals(actual, expected, description);
            TestLogger.get().log(PASS, String.format(MESSAGEFORMAT, description, actual, expected));
        } catch (AssertionError ex) {
            TestLogger.get().log(FAIL, String.format(MESSAGEFORMAT, description, actual, expected));
            throw new AssertionError(FAILED_MESSAGE);
        }
    }

    public static void assertTrue(Boolean actual, String description) {
        try {
            Assert.assertEquals(actual, true, description);
            TestLogger.get().log(PASS, String.format(MESSAGEFORMAT, description, actual, true));
        } catch (AssertionError ex) {
            TestLogger.get().log(FAIL, String.format(MESSAGEFORMAT, description, actual, true));
            throw new AssertionError(FAILED_MESSAGE);
        }
    }
}