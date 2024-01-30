package org.example.todomvc;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.example.todomvc.steps.UserSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@ExtendWith(SerenityJUnit5Extension.class)
public class BaseTestSetup {

    @Managed(driver = "firefox")
    WebDriver browser;

    UserSteps steps = new UserSteps();

}
