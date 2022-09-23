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
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(SerenityJUnit5Extension.class)
public abstract class BaseSetup {

    @Steps(shared = true)
    protected UserSteps step;

    @Managed
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
