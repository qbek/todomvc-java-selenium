package org.example;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloWorld {

    @Test
    public void helloWorld () {
        System.out.println("hello world!!!! I'm alive.....");
    }

    @Test
    public void browserPuppeter() throws InterruptedException {
//        WebDriver browser = new ChromeDriver();
        WebDriver browser = new FirefoxDriver();
        browser.get("http://google.com");
        Thread.sleep(2000);
        browser.close();
    }


    @Test
    public void fakerExamples() {
        Faker gen = new Faker();

        String result = gen.numerify("###########");

        System.out.println(result);

    }
}
