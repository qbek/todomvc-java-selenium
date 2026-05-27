package org.example.todomvc;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloWorldTest {

    @Test
    public void helloWorld() {
        System.out.println("Hello Wrold!!! I'm Jakub!");
    }

    @Test
    public void browserPuppetter() throws InterruptedException {
        var browser = new FirefoxDriver();
        browser.get("https://google.com");
        Thread.sleep(3000);
        browser.close();
    }
}
