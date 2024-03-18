package logger;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;

public class TestLogger {

    private final Logger LOGGER;

    public TestLogger(Class<?> clazz) {
        this.LOGGER = LogManager.getLogger(clazz);
    }

    public static TestLogger get() {
        Class<?> clazz;
        try {
            clazz = Reporter.getCurrentTestResult().getMethod().getRealClass();
        } catch (NullPointerException ex) {
            clazz = TestLogger.class;
        }
        return new TestLogger(clazz);
    }

    public void log(Level level, String message) {
        this.LOGGER.log(level, message);
    }
}