package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetUp {
    protected static WebDriver driver;

    public static void setUp() {
        driver = new ChromeDriver();
        driver.get("https://danewsletter.netlify.app/");
        System.out.println(driver.getTitle());
    }
}
