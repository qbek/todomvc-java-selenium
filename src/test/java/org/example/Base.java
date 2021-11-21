package org.example;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.example.steps.UserActions;
import org.junit.After;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class Base {

    @Managed
    WebDriver browser;

    @Steps
    UserActions steps;

    @After
    public void finishTest() {
        browser.close();
    }
}
