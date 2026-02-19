package com.automation.helpers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base page object providing shared WebDriver utilities.
 */
public class PageHelper {
    /**
     * WebDriver instance used by page objects.
     */
    protected final WebDriver driver;

    /**
     * Explicit wait helper for element conditions.
     */
    protected final WebDriverWait wait;

    /**
     * Creates a base page with a default explicit wait.
     *
     * @param driver WebDriver instance for browser interactions.
     */
    public PageHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Navigates the browser to the supplied URL.
     *
     * @param url Absolute URL to open.
     */
    public void openUrl(String url) {
        driver.get(url);
    }

    /**
     * Waits for the element to be visible.
     *
     * @param element WebElement to wait for.
     */
    protected void waitForVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for the element to be clickable.
     *
     * @param element WebElement to wait for.
     */
    protected void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Types text into the provided element after it becomes visible.
     *
     * @param element WebElement to receive the text.
     * @param text Text value to type.
     */
    public void type(WebElement element, String text) {
        waitForVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Clicks the provided element after it becomes clickable.
     *
     * @param element WebElement to click.
     */
    public void click(WebElement element) {
        waitForClickable(element);
        element.click();
    }

    /**
     * Reads visible text from the provided element.
     *
     * @param element WebElement to read.
     * @return Visible text content.
     */
    public String getText(WebElement element) {
        waitForVisible(element);
        return element.getText();
    }

    /**
     * Safely checks whether the element is displayed.
     *
     * @param element WebElement to check.
     * @return True when displayed, false when not displayed or detached.
     */
    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (RuntimeException ex) {
            return false;
        }
    }
}
