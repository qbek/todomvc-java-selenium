package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloWorld {

    @Test
    public void browserPuppeter() throws InterruptedException {
        var browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/basic_form.html");
        var nameInput = browser.findElement(By.cssSelector("#firstname"));
        nameInput.sendKeys("Jakub");
        Thread.sleep(2000);
        browser.close();
    }
}
