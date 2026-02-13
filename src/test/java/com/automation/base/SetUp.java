package com.newsletter.base;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetUp {
    protected static WebDriver driver;

    public static void setUp() {
        driver = new ChromeDriver();
        driver.get("https://danewsletter.netlify.app/");
        System.out.println(driver.getTitle());
        driver.quit();
    }

    public static void main (String[] args) {
        SetUp test = new SetUp();

        test.setUp();
    }
}
