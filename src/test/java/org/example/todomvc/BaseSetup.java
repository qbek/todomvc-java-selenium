package org.example.todomvc;

import org.example.todomvc.steps.UserActions;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseSetup {
    WebDriver browser = new ChromeDriver();
    UserActions step = new UserActions(browser);

    @AfterEach
    public void cleanup() {
        browser.close();
    }
}
