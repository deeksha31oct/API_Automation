package api.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtils {
    // Create a logger instance
    private static final Logger logger = LogManager.getLogger(LoggerUtils.class);

    // Log info messages
    public static void info(String message) {
        logger.info(message);
    }

    // Log debug messages
    public static void debug(String message) {
        logger.debug(message);
    }

    // Log error messages
    public static void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }

    // Log warning messages
    public static void warn(String message) {
        logger.warn(message);
    }
}
