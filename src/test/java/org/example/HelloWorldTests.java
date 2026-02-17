package org.example;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class HelloWorldTests {

    @Test
    public void test() {
        System.out.println("Hello world");
    }

    @Test
    public void testSelenium() {
        WebDriver browser = new FirefoxDriver();
        browser.get("http://google.com");
        browser.close();
    }

}
