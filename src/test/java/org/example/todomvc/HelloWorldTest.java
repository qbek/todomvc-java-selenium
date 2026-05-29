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

    @Test
    public void envValue() {
        System.out.println("A teraz pokaze wam");
        System.out.println("Trochę magiii.....");
        System.out.println("mam na imie: " + System.getProperty("name"));
    }
}
