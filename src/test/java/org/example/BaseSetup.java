package org.example;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.example.steps.UserActions;
import org.example.steps.UserPreconditions;
import org.example.steps.UserVerifications;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(SerenityJUnit5Extension.class)
public abstract class BaseSetup {

    @Managed
    WebDriver browser;

    @Steps
    UserPreconditions given;

    @Steps
    UserActions when;

    @Steps
    UserVerifications then;

}
