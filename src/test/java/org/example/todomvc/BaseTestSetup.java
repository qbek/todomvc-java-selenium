package org.example.todomvc;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.example.todomvc.steps.UserActions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(SerenityJUnit5Extension.class)
public class BaseTestSetup {

    @Managed(driver = "firefox")
    WebDriver browser;

    @Steps(shared = true)
    UserActions userActions;

}
