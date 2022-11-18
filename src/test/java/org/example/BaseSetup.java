package org.example;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.example.steps.PreconditionSteps;
import org.example.steps.UserActionSteps;
import org.example.steps.UserVerificationSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Objects;


@ExtendWith(SerenityJUnit5Extension.class)
public abstract class BaseSetup {
    @Managed
    WebDriver browser;

    @Steps
    PreconditionSteps given;

    @Steps
    UserActionSteps when;

    @Steps
    UserVerificationSteps then;

    @BeforeEach
    public void setup() throws IOException {
        if (Objects.isNull(System.getProperty("td"))) {
            throw new RuntimeException("Missing td parameter in execution command");
        }
        when.userOpensTodoMVCApp();
    }

}
