package org.example;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.example.steps.UserActions;
import org.example.steps.UserPreconditions;
import org.example.steps.UserVerifications;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(SerenityJUnit5Extension.class)
public abstract class BaseSetup {

    @Managed(driver="firefox")
    private WebDriver browser;

    @Steps
    UserPreconditions given;

    @Steps
    UserActions when;

    @Steps
    UserVerifications then;

}
