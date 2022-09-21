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

    @Steps
    protected UserSteps step;

    @Managed(driver = "firefox")
    WebDriver browser;

    @BeforeEach
    public void setup() {
        step.userOpensTodoMVCApp();
    }

    @AfterEach
    public void cleanUp() {
        step.userClosesTodoMVCApp();
    }

}
