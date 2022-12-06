package org.example;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.example.steps.UserActions;
import org.example.steps.UserVerifications;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(SerenityJUnit5Extension.class)
public class CreationTodoTests {

    @Managed(driver="firefox")
    private WebDriver browser;

    @Steps
    UserActions when;

    @Steps
    UserVerifications then;

    @Test
    public void userCanCreateANewTodo() {
        var todoName = "Moje zadanie";
        when.userOpensTodoMVCapp();
        when.userCreatesNewTodo(todoName);
        then.userChecksIfTodoWasCreated(todoName);
    }

    @Test
    public void userCanCompleteATodo() {
        var todoName = "Complete me";
        when.userOpensTodoMVCapp();
        when.userCreatesNewTodo(todoName);
        when.userCompletesTodo();
        then.userChecksIfTodoMarkedAsCompleted();
        then.userChecksIfCompletedTodoNotOnActiveTab(todoName);
        then.userChecksIfCompletedTodoOnCompletedTab(todoName);
    }

}
