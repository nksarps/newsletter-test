package com.automation.base;

import com.automation.pages.NewsletterPage;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.TestWatcher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SetUp class for initializing the WebDriver and browser configuration.
 * Provides static methods to set up the Chrome browser for Selenium tests.
 * Supports both headless and GUI modes based on environment configuration.
 * Also includes logging and test result tracking functionality.
 */
@ExtendWith(SetUp.JulTestWatcher.class)
public class SetUp {
    protected static WebDriver driver;
    protected static NewsletterPage newsletterPage;

    static {
        /**
         * Configures Java Util Logging (JUL) to display only the log message without additional metadata.
         */
        System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s%n%6$s%n");
    }

    /**
     * Declaring logger instance for logging test results in SetUp.
     */
    private static final Logger LOGGER = Logger.getLogger(SetUp.class.getName());

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

    /**
     * Initializes the ChromeDriver with appropriate options based on the execution environment.
     * 
     * Runs in headless mode when the {@code headless} system property or {@code HEADLESS} 
     * environment variable is set to "true". This is useful for CI/CD environments.
     * 
     * In headless mode, the following options are applied:
     * <ul>
     *   <li>{@code --headless} - Runs without GUI</li>
     *   <li>{@code --no-sandbox} - Disables sandbox mode for CI compatibility</li>
     *   <li>{@code --disable-dev-shm-usage} - Prevents memory issues in containers</li>
     * </ul>
     * 
     * After driver initialization, navigates to the configured URL and prints the page title.
     */
    @BeforeAll
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        
        // Check if running in headless mode (for CI)
        String headless = System.getProperty("headless");
        if ("true".equalsIgnoreCase(headless)) {
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }
        
        driver = new ChromeDriver(options);
        driver.get("https://danewsletter.netlify.app/");

        newsletterPage = new NewsletterPage(driver);
    }

    /**
     * Opens the newsletter page before each test.
     */
    @BeforeEach
    public void beforeEach() {
        newsletterPage.open();
    }

    /**
     * Closes the browser and cleans up the WebDriver instance after test execution.
     *
     * <p>This method checks whether the WebDriver has been initialized.
     * If it is not null, it calls {@code driver.quit()} to close all browser
     * windows and safely terminate the WebDriver session.</p>
     *
     * <p>This helps prevent memory leaks and ensures that no browser
     * processes remain running after the tests complete.</p>
     */
    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}