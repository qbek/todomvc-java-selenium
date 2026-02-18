package org.example.todomvc;

import jdk.jfr.MemoryAddress;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.example.pageobjects.TodoInput;
import org.example.pageobjects.TodosList;
import org.example.steps.PreconditionSteps;
import org.example.steps.UserSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@ExtendWith(SerenityJUnit5Extension.class)
public abstract class BaseTestSetup {

    String TodoMVC_URL = "https://todomvc.com/examples/jquery/dist/#/all";

    @Managed(driver = "firefox")
    WebDriver browser;

    @Steps
    PreconditionSteps preconditions;

    @Steps
    UserSteps steps;

    @BeforeEach
    public void openApp() {
        browser.get(TodoMVC_URL);
    }

    @AfterEach
    public void closeApp() {
        browser.close();
    }
}
