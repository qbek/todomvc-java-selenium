package org.example.todomvc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public class WebDriverSingleton {

    private static WebDriver browser;

    public WebDriver getDriver() {
        if (Objects.isNull(browser)) {
            browser = new FirefoxDriver();
        }
        return browser;
    }
}


