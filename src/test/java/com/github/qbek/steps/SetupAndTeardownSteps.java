package com.github.qbek.steps;

import com.github.qbek.pageobjects.TodoMvcApp;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SetupAndTeardownSteps {

    TodoMvcApp app = new TodoMvcApp();

    @Step
    public void userOpensTodoMvcApp() {
        app.startApplication();
    }

    public void userClosesAplication() {
        app.stopApplication();
    }
}
