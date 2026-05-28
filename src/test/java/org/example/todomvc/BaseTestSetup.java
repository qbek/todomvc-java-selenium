package org.example.todomvc;

import org.example.todomvc.steps.GivenSteps;
import org.example.todomvc.steps.ThenSteps;
import org.example.todomvc.steps.WhenSteps;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

abstract public class BaseTestSetup {
    protected WebDriver browser = new FirefoxDriver();
    protected GivenSteps given = new GivenSteps(browser);
    protected WhenSteps when = new WhenSteps(browser);
    protected ThenSteps then = new ThenSteps(browser);

    @AfterEach
    public void closeBrowser() {
        browser.close();
    }

}
