package com.automation.tests;

import com.automation.base.SetUp;
import com.automation.pages.NewsletterPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for the newsletter sign-up flow.
 */
public class NewsletterTest extends SetUp {
    /**
     * Starts the browser once before all tests.
     */
    @BeforeAll
    public static void beforeAll() {
        setUp();
    }

    /**
     * Quits the browser once after all tests.
     */
    @AfterAll
    public static void afterAll() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Opens the newsletter page before each test.
     */
    @BeforeEach
    public void beforeEach() {
        new NewsletterPage(driver).open();
    }

    /**
     * Verifies a valid email results in a success message.
     */
    @Test
    public void shouldSubscribeWithValidEmail() {
        NewsletterPage page = new NewsletterPage(driver);
        String email = "testuser@example.com";

        page.submitWithEmail(email);

        assertEquals("Thanks for subscribing!", page.getSuccessTitle());
        assertEquals(email, page.getSuccessEmail());
    }

    /**
     * Verifies an invalid email shows an error message.
     */
    @Test
    public void shouldShowErrorForInvalidEmail() {
        NewsletterPage page = new NewsletterPage(driver);

        page.submitWithEmail("invalid");

        assertTrue(page.isErrorVisible());
        assertEquals("Valid email required", page.getErrorMessage());
    }

    /**
     * Verifies error when email is empty.
     */
    @Test
    public void shouldShowErrorWhenEmailIsEmpty() {
        NewsletterPage page = new NewsletterPage(driver);

        page.submit();

        assertTrue(page.isErrorVisible());
        assertEquals("Valid email required", page.getErrorMessage());
    }

    /**
     * Verifies error when username contains whitespace.
     */
    @Test
    public void shouldShowErrorWhenUsernameContainsWhitespace() {
        NewsletterPage page = new NewsletterPage(driver);

        page.submitWithEmail("john doe@example.com");

        assertTrue(page.isErrorVisible());
        assertEquals("Valid email required", page.getErrorMessage());
    }

    /**
     * Verifies valid subscription when username contains numbers.
     */
    @Test
    public void shouldSubscribeWhenUsernameContainsNumbers() {
        NewsletterPage page = new NewsletterPage(driver);
        String email = "user123@example.com";

        page.submitWithEmail(email);

        assertEquals("Thanks for subscribing!", page.getSuccessTitle());
        assertEquals(email, page.getSuccessEmail());
    }

    /**
     * Verifies valid subscription when username contains allowed special characters.
     */
    @Test
    public void shouldSubscribeWhenUsernameContainsSpecialCharacters() {
        NewsletterPage page = new NewsletterPage(driver);
        String email = "user_test@example.com";

        page.submitWithEmail(email);

        assertEquals("Thanks for subscribing!", page.getSuccessTitle());
        assertEquals(email, page.getSuccessEmail());
    }

    /**
     * Verifies error when username is empty.
     */
    @Test
    public void shouldShowErrorWhenUsernameIsEmpty() {
        NewsletterPage page = new NewsletterPage(driver);

        page.submitWithEmail("@example.com");

        assertTrue(page.isErrorVisible());
        assertEquals("Valid email required", page.getErrorMessage());
    }

    /**
     * Verifies error when mail server contains numbers.
     */
    @Test
    public void shouldShowErrorWhenMailServerContainsNumbers() {
        NewsletterPage page = new NewsletterPage(driver);

        page.submitWithEmail("user@exam123ple.com");

        assertTrue(page.isErrorVisible());
        assertEquals("Valid email required", page.getErrorMessage());
    }

    /**
     * Verifies error when mail server contains special characters.
     */
    @Test
    public void shouldShowErrorWhenMailServerContainsSpecialCharacters() {
        NewsletterPage page = new NewsletterPage(driver);

        page.submitWithEmail("user@exam-ple.com");

        assertTrue(page.isErrorVisible());
        assertEquals("Valid email required", page.getErrorMessage());
    }

    /**
     * Verifies error when mail server contains whitespace.
     */
    @Test
    public void shouldShowErrorWhenMailServerContainsWhitespace() {
        NewsletterPage page = new NewsletterPage(driver);

        page.submitWithEmail("user@exam ple.com");

        assertTrue(page.isErrorVisible());
        assertEquals("Valid email required", page.getErrorMessage());
    }

    /**
     * Verifies error when mail server is empty.
     */
    @Test
    public void shouldShowErrorWhenMailServerIsEmpty() {
        NewsletterPage page = new NewsletterPage(driver);

        page.submitWithEmail("user@.com");

        assertTrue(page.isErrorVisible());
        assertEquals("Valid email required", page.getErrorMessage());
    }

    /**
     * Verifies error when domain contains numbers.
     */
    @Test
    public void shouldShowErrorWhenDomainContainsNumbers() {
        NewsletterPage page = new NewsletterPage(driver);

        page.submitWithEmail("user@example.c0m");

        assertTrue(page.isErrorVisible());
        assertEquals("Valid email required", page.getErrorMessage());
    }

    /**
     * Verifies error when domain contains special characters.
     */
    @Test
    public void shouldShowErrorWhenDomainContainsSpecialCharacters() {
        NewsletterPage page = new NewsletterPage(driver);

        page.submitWithEmail("user@example.c-om");

        assertTrue(page.isErrorVisible());
        assertEquals("Valid email required", page.getErrorMessage());
    }

    /**
     * Verifies error when domain contains whitespace.
     */
    @Test
    public void shouldShowErrorWhenDomainContainsWhitespace() {
        NewsletterPage page = new NewsletterPage(driver);

        page.submitWithEmail("user@example.c om");

        assertTrue(page.isErrorVisible());
        assertEquals("Valid email required", page.getErrorMessage());
    }

    /**
     * Verifies error when domain is empty.
     */
    @Test
    public void shouldShowErrorWhenDomainIsEmpty() {
        NewsletterPage page = new NewsletterPage(driver);

        page.submitWithEmail("user@example.");

        assertTrue(page.isErrorVisible());
        assertEquals("Valid email required", page.getErrorMessage());
    }

    /**
     * Verifies error when @ symbol is missing.
     */
    @Test
    public void shouldShowErrorWhenAtSymbolIsMissing() {
        NewsletterPage page = new NewsletterPage(driver);

        page.submitWithEmail("userexample.com");

        assertTrue(page.isErrorVisible());
        assertEquals("Valid email required", page.getErrorMessage());
    }

    /**
     * Verifies error when dot before domain is missing.
     */
    @Test
    public void shouldShowErrorWhenDotBeforeDomainIsMissing() {
        NewsletterPage page = new NewsletterPage(driver);

        page.submitWithEmail("user@examplecom");

        assertTrue(page.isErrorVisible());
        assertEquals("Valid email required", page.getErrorMessage());
    }
}
