package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * SetUp class for initializing the WebDriver and browser configuration.
 * Provides static methods to set up the Chrome browser for Selenium tests.
 * Supports both headless and GUI modes based on environment configuration.
 */
public class SetUp {
    protected static WebDriver driver;

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
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        
        // Check if running in headless mode (for CI)
        String headless = System.getProperty("headless", System.getenv("HEADLESS"));
        if ("true".equalsIgnoreCase(headless)) {
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }
        
        driver = new ChromeDriver(options);
        driver.get("https://danewsletter.netlify.app/");
        System.out.println(driver.getTitle());
    }
}