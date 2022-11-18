package org.example;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.example.steps.UserSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

@ExtendWith(SerenityJUnit5Extension.class)
public abstract class BaseSetup {
    @Managed(driver = "firefox")
    WebDriver browser;

    @Steps(actor = "Fluffy Rabbit")
    UserSteps steps;

    @BeforeEach
    public void setup() throws IOException {
        steps.userOpensTodoMVCApp();
    }

}
