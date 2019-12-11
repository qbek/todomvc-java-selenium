package com.github.qbek;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void helloWorld() {
        System.out.println("Hello world!!!");
    }

    @Test
    public void browserPuppeteer() throws InterruptedException {
//        WebDriver browser = new ChromeDriver();
        WebDriver browser = new FirefoxDriver();
        browser.get("http://google.com");
        browser.manage().window().maximize();
        Thread.sleep(2000);
        browser.quit();
    }
}
