package org.example;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.example.steps.UserActions;
import org.junit.After;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(SerenityRunner.class)
public class Base {

    @Managed(driver = "chrome")
    WebDriver browser;

    @Steps
    UserActions steps;

    @After
    public void finishTest() {
        browser.close();
    }
}
