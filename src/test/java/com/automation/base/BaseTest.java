package com.automation.base;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Base test class for all test cases in the project.
 * <p>
 * This class extends {@link SetUp} to inherit setup logic.
 * It also uses a custom JUnit 5 {@link TestWatcher} extension to log test results.
 */
@ExtendWith(BaseTest.JulTestWatcher.class)
public class BaseTest extends SetUp {

    static {
        /**
         * Configures Java Util Logging (JUL) to display only the log message without additional metadata.
         */
        System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s%n%6$s%n");
    }

    /**
     * Declaring logger instance for logging test results in BaseTest.
     */
    private static final Logger LOGGER = Logger.getLogger(BaseTest.class.getName());

    /**
     * Custom JUnit 5 {@link TestWatcher} implementation to log test results.
     */
    static class JulTestWatcher implements TestWatcher {

        /**
         * Logs a message when a test is successful.
         *
         * @param context the context of the test that was successful
         */
        @Override
        public void testSuccessful(org.junit.jupiter.api.extension.ExtensionContext context) {
            LOGGER.info("PASSED: " + context.getDisplayName());
        }

        /**
         * Logs a message and the exception when a test fails.
         *
         * @param context the context of the test that failed
         * @param cause   the exception that caused the test to fail
         */
        @Override
        public void testFailed(org.junit.jupiter.api.extension.ExtensionContext context, Throwable cause) {
            LOGGER.log(Level.SEVERE, "FAILED: " + context.getDisplayName(), cause);
        }
    }
}
