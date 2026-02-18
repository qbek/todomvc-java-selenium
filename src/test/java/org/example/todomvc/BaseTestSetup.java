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

import java.io.IOException;
import java.util.Properties;

@ExtendWith(SerenityJUnit5Extension.class)
public abstract class BaseTestSetup {

    @Managed(driver = "firefox")
    WebDriver browser;

    @Steps
    PreconditionSteps preconditions;

    @Steps
    UserSteps steps;

    @BeforeEach
    public void openApp() throws IOException {
        var envName = System.getProperty("env");
        var configFile = this.getClass().getResourceAsStream("/" + envName + "_env.properties");
        var config = new Properties();
        config.load(configFile);

        browser.get(config.getProperty("todoMVC_url"));
    }

    @AfterEach
    public void closeApp() {
        browser.close();
    }
}
