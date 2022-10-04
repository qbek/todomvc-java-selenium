package org.example;

import org.example.steps.UserSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseSetup {

    WebDriver browser = new FirefoxDriver();
    UserSteps step = new UserSteps(browser);

    @BeforeEach
    public void setup() {
        step.userOpenTodoMVC();
    }

    @AfterEach
    public void cleanup() {
        browser.close();
    }
}
