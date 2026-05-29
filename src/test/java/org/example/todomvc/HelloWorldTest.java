package org.example.todomvc;

import com.github.javafaker.Faker;
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


    @Test
    public void fakerExample() {
        var numerify = Faker.instance().numerify("EL ####G");
        System.out.println(numerify);

        var str = Faker.instance().letterify("?? 1234?", true);
        System.out.println(str);

        var both = Faker.instance().bothify("?? ####?", true);
        System.out.println(both);
    }
}
