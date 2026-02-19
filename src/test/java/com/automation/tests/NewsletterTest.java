package com.automation.tests;

import com.automation.base.BaseTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for the newsletter sign-up flow.
 */
public class NewsletterTest extends BaseTest {
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
        tearDown();
    }

    /**
     * Opens the newsletter page before each test.
     */
    @BeforeEach
    public void beforeEach() {
        newsletterPage.open();
    }

    /**
     * Verifies a valid email results in a success message.
     */
    @Test
    @DisplayName("TC001: Validate sign up succeeds with valid email")
    public void shouldSubscribeWithValidEmail() {
        String email = "testuser@example.com";

        newsletterPage.submitWithEmail(email);

        assertEquals("Thanks for subscribing!", newsletterPage.getSuccessTitle());
        assertEquals(email, newsletterPage.getSuccessEmail());
    }

    /**
     * Verifies an invalid email shows an error message.
     */
    @Test
    @DisplayName("TC002: Validate sign up fails with invalid email")
    public void shouldShowErrorForInvalidEmail() {
        newsletterPage.submitWithEmail("invalid");

        assertTrue(newsletterPage.isErrorVisible());
        assertEquals("Valid email required", newsletterPage.getErrorMessage());
    }

    /**
     * Verifies error when email is empty.
     */
    @Test
    @DisplayName("TC003: Validate sign up fails with empty email")
    public void shouldShowErrorWhenEmailIsEmpty() {
        newsletterPage.submit();

        assertTrue(newsletterPage.isErrorVisible());
        assertEquals("Valid email required", newsletterPage.getErrorMessage());
    }

    /**
     * Verifies error when username contains whitespace.
     */
    @Test
    @DisplayName("TC004: Validate sign up fails when username has whitespace")
    public void shouldShowErrorWhenUsernameContainsWhitespace() {
        newsletterPage.submitWithEmail("john doe@example.com");

        assertTrue(newsletterPage.isErrorVisible());
        assertEquals("Valid email required", newsletterPage.getErrorMessage());
    }

    /**
     * Verifies valid subscription when username contains numbers.
     */
    @Test
    @DisplayName("TC005: Validate sign up succeeds when username has numbers")
    public void shouldSubscribeWhenUsernameContainsNumbers() {
        String email = "user123@example.com";

        newsletterPage.submitWithEmail(email);

        assertEquals("Thanks for subscribing!", newsletterPage.getSuccessTitle());
        assertEquals(email, newsletterPage.getSuccessEmail());
    }

    /**
     * Verifies valid subscription when username contains allowed special characters.
     */
    @Test
    @DisplayName("TC006: Validate sign up succeeds when username has special characters")
    public void shouldSubscribeWhenUsernameContainsSpecialCharacters() {
        String email = "user_test@example.com";

        newsletterPage.submitWithEmail(email);

        assertEquals("Thanks for subscribing!", newsletterPage.getSuccessTitle());
        assertEquals(email, newsletterPage.getSuccessEmail());
    }

    /**
     * Verifies error when username is empty.
     */
    @Test
    @DisplayName("TC007: Validate sign up fails with empty username")
    public void shouldShowErrorWhenUsernameIsEmpty() {
        newsletterPage.submitWithEmail("@example.com");

        assertTrue(newsletterPage.isErrorVisible());
        assertEquals("Valid email required", newsletterPage.getErrorMessage());
    }

    /**
     * Verifies error when mail server contains numbers.
     */
    @Test
    @DisplayName("TC008: Validate sign up fails when mail server has numbers")
    public void shouldShowErrorWhenMailServerContainsNumbers() {
        newsletterPage.submitWithEmail("user@exam123ple.com");

        assertTrue(newsletterPage.isErrorVisible());
        assertEquals("Valid email required", newsletterPage.getErrorMessage());
    }

    /**
     * Verifies error when mail server contains special characters.
     */
    @Test
    @DisplayName("TC009: Validate sign up fails when mail server has special characters")
    public void shouldShowErrorWhenMailServerContainsSpecialCharacters() {
        newsletterPage.submitWithEmail("user@exam-ple.com");

        assertTrue(newsletterPage.isErrorVisible());
        assertEquals("Valid email required", newsletterPage.getErrorMessage());
    }

    /**
     * Verifies error when mail server contains whitespace.
     */
    @Test
    @DisplayName("TC010: Validate sign up fails when mail server has whitespace")
    public void shouldShowErrorWhenMailServerContainsWhitespace() {
        newsletterPage.submitWithEmail("user@exam ple.com");

        assertTrue(newsletterPage.isErrorVisible());
        assertEquals("Valid email required", newsletterPage.getErrorMessage());
    }

    /**
     * Verifies error when mail server is empty.
     */
    @Test
    @DisplayName("TC011: Validate sign up fails when mail server is empty")
    public void shouldShowErrorWhenMailServerIsEmpty() {
        newsletterPage.submitWithEmail("user@.com");

        assertTrue(newsletterPage.isErrorVisible());
        assertEquals("Valid email required", newsletterPage.getErrorMessage());
    }

    /**
     * Verifies error when domain contains numbers.
     */
    @Test
    @DisplayName("TC012: Validate sign up fails when domain has numbers")
    public void shouldShowErrorWhenDomainContainsNumbers() {
        newsletterPage.submitWithEmail("user@example.c0m");

        assertTrue(newsletterPage.isErrorVisible());
        assertEquals("Valid email required", newsletterPage.getErrorMessage());
    }

    /**
     * Verifies error when domain contains special characters.
     */
    @Test
    @DisplayName("TC013: Validate sign up fails when domain has special characters")
    public void shouldShowErrorWhenDomainContainsSpecialCharacters() {
        newsletterPage.submitWithEmail("user@example.c-om");

        assertTrue(newsletterPage.isErrorVisible());
        assertEquals("Valid email required", newsletterPage.getErrorMessage());
    }

    /**
     * Verifies error when domain contains whitespace.
     */
    @Test
    @DisplayName("TC014: Validate sign up fails when domain has whitespace")
    public void shouldShowErrorWhenDomainContainsWhitespace() {
        newsletterPage.submitWithEmail("user@example.c om");

        assertTrue(newsletterPage.isErrorVisible());
        assertEquals("Valid email required", newsletterPage.getErrorMessage());
    }

    /**
     * Verifies error when domain is empty.
     */
    @Test
    @DisplayName("TC015: Validate sign up fails when domain is empty")
    public void shouldShowErrorWhenDomainIsEmpty() {
        newsletterPage.submitWithEmail("user@example.");

        assertTrue(newsletterPage.isErrorVisible());
        assertEquals("Valid email required", newsletterPage.getErrorMessage());
    }

    /**
     * Verifies error when @ symbol is missing.
     */
    @Test
    @DisplayName("TC016: Validate sign up fails when @ symbol is missing")
    public void shouldShowErrorWhenAtSymbolIsMissing() {
        newsletterPage.submitWithEmail("userexample.com");

        assertTrue(newsletterPage.isErrorVisible());
        assertEquals("Valid email required", newsletterPage.getErrorMessage());
    }

    /**
     * Verifies error when dot before domain is missing.
     */
    @Test
    @DisplayName("TC017: Validate sign up fails when dot before domain is missing")
    public void shouldShowErrorWhenDotBeforeDomainIsMissing() {
        newsletterPage.submitWithEmail("user@examplecom");

        assertTrue(newsletterPage.isErrorVisible());
        assertEquals("Valid email required", newsletterPage.getErrorMessage());
    }
}
