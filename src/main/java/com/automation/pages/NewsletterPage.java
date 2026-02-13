package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page object for the newsletter sign-up page.
 */
public class NewsletterPage extends BasePage {
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
     * Main sign-up container element.
     */
    @FindBy(id = "signup-container")
    private WebElement signupContainer;

    /**
     * Newsletter form container.
     */
    @FindBy(id = "newsletter-form")
    private WebElement newsletterForm;

    /**
     * Submit button for the sign-up form.
     */
    @FindBy(css = "button.submit-btn")
    private WebElement submitButton;

    /**
     * Error message shown for invalid email.
     */
    @FindBy(id = "error-message")
    private WebElement errorMessage;

    /**
     * Container displayed after a successful subscription.
     */
    @FindBy(id = "success-container")
    private WebElement successContainer;

    /**
     * Success header text.
     */
    @FindBy(css = "h1.success-title")
    private WebElement successTitle;

    /**
     * Success body message text.
     */
    @FindBy(css = "p.success-message")
    private WebElement successMessage;

    /**
     * Element containing the subscribed email in the success message.
     */
    @FindBy(id = "user-email")
    private WebElement successEmail;

    /**
     * Dismiss button on the success message.
     */
    @FindBy(id = "dismiss-btn")
    private WebElement dismissButton;

    /**
     * Creates the page object and initializes its elements.
     *
     * @param driver WebDriver instance for browser interactions.
     */
    public NewsletterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens the newsletter sign-up page.
     *
     * @return Current page object for chaining.
     */
    public NewsletterPage open() {
        openUrl(PAGE_URL);
        return this;
    }

    /**
     * Enters the email address in the sign-up form.
     *
     * @param email Email address to use.
     * @return Current page object for chaining.
     */
    public NewsletterPage enterEmail(String email) {
        type(emailInput, email);
        return this;
    }

    /**
     * Submits the sign-up form.
     *
     * @return Current page object for chaining.
     */
    public NewsletterPage submit() {
        click(submitButton);
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
        return getText(errorMessage);
    }

    /**
     * Checks whether the error message is displayed.
     *
     * @return True when the error message is visible.
     */
    public boolean isErrorVisible() {
        return isDisplayed(errorMessage);
    }

    /**
     * Checks whether the sign-up container is displayed.
     *
     * @return True when the sign-up container is visible.
     */
    public boolean isSignupVisible() {
        return isDisplayed(signupContainer);
    }

    /**
     * Checks whether the form is displayed.
     *
     * @return True when the form is visible.
     */
    public boolean isFormVisible() {
        return isDisplayed(newsletterForm);
    }

    /**
     * Checks whether the success container is displayed.
     *
     * @return True when the success container is visible.
     */
    public boolean isSuccessVisible() {
        return isDisplayed(successContainer);
    }

    /**
     * Reads the success title text.
     *
     * @return Success title content.
     */
    public String getSuccessTitle() {
        return getText(successTitle);
    }

    /**
     * Reads the success message text.
     *
     * @return Success message content.
     */
    public String getSuccessMessage() {
        return getText(successMessage);
    }

    /**
     * Reads the email displayed in the success message.
     *
     * @return Email value shown after subscription.
     */
    public String getSuccessEmail() {
        return getText(successEmail);
    }

    /**
     * Dismisses the success message dialog.
     *
     * @return Current page object for chaining.
     */
    public NewsletterPage dismissSuccess() {
        click(dismissButton);
        return this;
    }
}
