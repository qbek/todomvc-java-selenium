package org.example;

import net.serenitybdd.core.annotations.findby.By;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class HelloWorld {

    @Test
    public void browserPuppeteer() throws InterruptedException {
        var browser = new FirefoxDriver();
        browser.get("http://google.pl");
        Thread.sleep(2000);
        browser.close();

    }

}
