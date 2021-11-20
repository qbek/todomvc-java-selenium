package org.example;

import org.example.steps.UserActions;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

    WebDriver browser = new FirefoxDriver();
    UserActions steps = new UserActions(browser);

    @After
    public void finishTest() {
        browser.close();
    }
}
