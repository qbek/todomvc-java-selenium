package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloWorld {

    @Test
    public void browserPuppeteer() throws InterruptedException {
        WebDriver browser = new FirefoxDriver();
        browser.get("https://google.com");
        Thread.sleep(2000);
        browser.close();
    }
}
