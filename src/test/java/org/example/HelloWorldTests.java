package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloWorldTests {

    @Test
    public void browserTest() throws InterruptedException {
        var browser = new FirefoxDriver();
        browser.get("http://www.google.com");
        Thread.sleep(5000);
        browser.close();
    }


    @Test
    public void systemPropsExample() {
        var cos = System.getProperty("cos");
        System.out.println(cos);
    }
}
