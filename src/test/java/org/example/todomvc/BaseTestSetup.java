package org.example.todomvc;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.example.todomvc.data.RandomDataProvider;
import org.example.todomvc.steps.GivenSteps;
import org.example.todomvc.steps.ThenSteps;
import org.example.todomvc.steps.WhenSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(SerenityJUnit5Extension.class)
abstract public class BaseTestSetup {

    @Managed(driver = "firefox")
    protected WebDriver browser;

    @Steps
    protected GivenSteps given;

    @Steps
    protected WhenSteps when;

    @Steps
    protected ThenSteps then;

    @Steps
    protected RandomDataProvider testData;

    @AfterEach
    public void closeBrowser() {
        browser.close();
    }

}
