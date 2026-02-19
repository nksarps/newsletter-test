package com.automation.pages;

import com.automation.helpers.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page object for the newsletter sign-up page.
 */
public class NewsletterPage {
    /**
     * PageHelper instance for delegation.
     */
    private final PageHelper pageHelper;

    /**
     * Page URL for the newsletter sign-up form.
     */
    public static final String PAGE_URL = "https://danewsletter.netlify.app/";

    /**
     * Email input field in the sign-up form.
     */
    @FindBy(id = "email")
    private WebElement emailInput;

    /**
     * Submit button for the sign-up form.
     */
    @FindBy(id = "submit-btn")
    private WebElement submitButton;

    /**
     * Error message shown for invalid email.
     */
    @FindBy(id = "error-message")
    private WebElement errorMessage;

    /**
     * Success header text.
     */
    @FindBy(id = "success-title")
    private WebElement successTitle;

    /**
     * Element containing the subscribed email in the success message.
     */
    @FindBy(id = "user-email")
    private WebElement successEmail;

    /**
     * Creates the page object and initializes its elements.
     *
     * @param driver WebDriver instance for browser interactions.
     */
    public NewsletterPage(WebDriver driver) {
        this.pageHelper = new PageHelper(driver);
        
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens the newsletter sign-up page.
     *
     * @return Current page object for chaining.
     */
    public NewsletterPage open() {
        pageHelper.openUrl(PAGE_URL);
        return this;
    }

    /**
     * Enters the email address in the sign-up form.
     *
     * @param email Email address to use.
     * @return Current page object for chaining.
     */
    public NewsletterPage enterEmail(String email) {
        pageHelper.type(emailInput, email);
        return this;
    }

    /**
     * Submits the sign-up form.
     *
     * @return Current page object for chaining.
     */
    public NewsletterPage submit() {
        pageHelper.click(submitButton);
        return this;
    }

    /**
     * Enters the email address and submits the form.
     *
     * @param email Email address to use.
     * @return Current page object for chaining.
     */
    public NewsletterPage submitWithEmail(String email) {
        return enterEmail(email).submit();
    }

    /**
     * Reads the error message text.
     *
     * @return Error message content.
     */
    public String getErrorMessage() {
        return pageHelper.getText(errorMessage);
    }

    /**
     * Checks whether the error message is displayed.
     *
     * @return True when the error message is visible.
     */
    public boolean isErrorVisible() {
        return pageHelper.isDisplayed(errorMessage);
    }

    /**
     * Reads the success title text.
     *
     * @return Success title content.
     */
    public String getSuccessTitle() {
        return pageHelper.getText(successTitle);
    }

    /**
     * Reads the email displayed in the success message.
     *
     * @return Email value shown after subscription.
     */
    public String getSuccessEmail() {
        return pageHelper.getText(successEmail);
    }
}
