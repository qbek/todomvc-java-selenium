package org.example;

import com.github.javafaker.Faker;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.example.steps.UserSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(SerenityJUnit5Extension.class)
public class BaseSetup {

    @Managed(driver = "firefox")
    WebDriver browser;

    @Steps
    UserSteps step;

    Faker dataGenerator = new Faker();

    @BeforeEach
    public void setup() {
        step.userOpenTodoMVC();
    }

    @AfterEach
    public void cleanup() {
        browser.close();
    }
}
