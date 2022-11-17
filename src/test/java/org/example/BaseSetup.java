package org.example;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.example.steps.UserSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(SerenityJUnit5Extension.class)
public abstract class BaseSetup {
    @Managed(driver = "firefox")
    WebDriver browser;

    @Steps
    UserSteps steps;

    @BeforeEach
    public void setup() {
        steps.setDriver(browser);
        steps.userOpensTodoMVCApp();
    }


    @AfterEach
    public void cleanup() {
        browser.close();
    }
}
