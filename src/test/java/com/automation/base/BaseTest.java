package com.automation.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.logging.Level;
import java.util.logging.Logger;

@ExtendWith(BaseTest.JulTestWatcher.class)
public class BaseTest extends SetUp {
    static {
        // Keep only the log message in JUL output.
        System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s%n");
    }

    private static final Logger LOGGER = Logger.getLogger(BaseTest.class.getName());

    @BeforeEach
    void logStart(TestInfo testInfo) {
        LOGGER.info("START: " + testInfo.getDisplayName());
    }

    @AfterEach
    void logEnd(TestInfo testInfo) {
        LOGGER.info("END: " + testInfo.getDisplayName());
    }

    static class JulTestWatcher implements TestWatcher {
        @Override
        public void testSuccessful(org.junit.jupiter.api.extension.ExtensionContext context) {
            LOGGER.info("PASSED: " + context.getDisplayName());
        }

        @Override
        public void testFailed(org.junit.jupiter.api.extension.ExtensionContext context, Throwable cause) {
            LOGGER.log(Level.SEVERE, "FAILED: " + context.getDisplayName(), cause);
        }

        @Override
        public void testAborted(org.junit.jupiter.api.extension.ExtensionContext context, Throwable cause) {
            LOGGER.log(Level.WARNING, "ABORTED: " + context.getDisplayName(), cause);
        }
    }
}
