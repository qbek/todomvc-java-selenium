package org.example;

import com.github.javafaker.Faker;
import io.cucumber.java.tr.Fakat;
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

    @Managed(driver = "chrome")
    WebDriver browser;

    protected static Faker dataGenerator = new Faker();


    @BeforeEach
    public void setup() {
        step.userOpensTodoMVCApp();
    }

    @AfterEach
    public void cleanUp() {
//        step.userClosesTodoMVCApp();
    }

}
