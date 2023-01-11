package org.example.todomvc;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.example.todomvc.steps.UserActions;
import org.example.todomvc.steps.UserAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(SerenityJUnit5Extension.class)
public class BaseSetup {

    @Managed
    WebDriver browser;

    @Steps
    UserActions step;

    @Steps
    UserAssertions validateStep;

    
    @AfterEach
    public void cleanup() {
        browser.close();
    }
}
