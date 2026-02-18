package org.example;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;


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

    @Test
    public void sysProperties() {
        var env = System.getProperty("wajcha");
        System.out.println(env);
    }

    @Test
    public void fakerTests() {
        System.out.println(Faker.instance().numerify("31 1234 #### #### ####"));
        System.out.println(Faker.instance().letterify("?? 12345", true));
        System.out.println(Faker.instance().bothify("?? ####"));
        System.out.println(Faker.instance(Locale.ENGLISH).name().fullName());
        System.out.println(Faker.instance(Locale.GERMAN).name().fullName());
    }

}
