package org.example;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloWorldTest {

    @Test
    public void browserPuppeter() throws InterruptedException {
        WebDriver browser = new FirefoxDriver();
        browser.get("http://google.pl");
        Thread.sleep(1000);
        browser.close();
    }

    @Test
    public void testSystemProperties() {
        String testValue = System.getProperty("key");
        System.out.println(testValue);
    }

}
