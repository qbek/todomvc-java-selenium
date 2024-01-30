package org.example.todomvc;

import org.example.todomvc.steps.UserSteps;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTestSetup {

    WebDriver browser = new FirefoxDriver();
    UserSteps steps = new UserSteps(browser);

    @AfterEach
    public void cleanup() {
        browser.close();
    }
}
