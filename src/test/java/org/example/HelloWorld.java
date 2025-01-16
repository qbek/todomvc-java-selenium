package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloWorld {

    @Test
    public void browserTest() throws InterruptedException {
        WebDriver browser = new FirefoxDriver();
        browser.get("http://www.google.com");
        Thread.sleep(5000);
        browser.close();
    }
}
