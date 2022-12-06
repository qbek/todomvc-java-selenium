package org.example;

import com.sun.xml.bind.v2.TODO;
import jxl.common.AssertionFailed;
import org.example.steps.UserActions;
import org.example.steps.UserVerifications;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.openqa.selenium.By.cssSelector;

public class CreationTodoTests {

    private WebDriver browser = new FirefoxDriver();

    UserActions when = new UserActions(browser);
    UserVerifications then = new UserVerifications(browser);

    @AfterEach
    public void closeTodoMVCapp() {
        browser.close();
    }

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
