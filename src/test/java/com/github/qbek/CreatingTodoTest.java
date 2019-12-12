package com.github.qbek;

import com.github.qbek.steps.SetupAndTeardownSteps;
import com.github.qbek.steps.TodoSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(SerenityRunner.class)
public class CreatingTodoTest {

    @Managed(driver = "firefox")
    WebDriver browser;

    By todoCompleteToggleSelector = By.cssSelector(".todo-list input.toggle");
    By todoItemSelector = By.cssSelector(".todo-list li");
    By activeTabSelector = By.cssSelector(".filters [href=\"#/active\"]");
    By completedTabSelector = By.cssSelector(".filters [href=\"#/completed\"]");

    @Steps
    SetupAndTeardownSteps setup;

    @Steps
    TodoSteps step;

    @Before
    public void setup() {
        setup.userOpensTodoMvcApp();
    }

    @Test
    public void userCanCreateATodo() {
        String todoName = "Learn Selenium + JAVA";
        step.userCreatesANewTodo(todoName);
        step.userChecksIfTodoIsListed(todoName);
    }

    @After
    public void cleanUp() {
        setup.userClosesAplication();
    }
}
