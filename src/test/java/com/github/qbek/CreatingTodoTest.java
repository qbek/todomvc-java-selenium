package com.github.qbek;

import com.github.qbek.steps.SetupAndTeardownSteps;
import com.github.qbek.steps.TodoSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
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

import java.util.ArrayList;
import java.util.List;

@RunWith(SerenityRunner.class)
public class CreatingTodoTest {

    @Managed(driver = "firefox")
    WebDriver browser;


    @Steps
    SetupAndTeardownSteps setup;

    @Steps
    TodoSteps step;

    @Before
    public void setup() {
        setup.userOpensTodoMvcApp();
    }

    @Test
    @WithTag("smoke")
    public void userCanCreateATodo() {
        String todoName = "Learn Selenium + JAVA";
        step.userCreatesANewTodo(todoName);
        step.userChecksIfTodoIsListed(todoName);
    }


    @Test
    public void userCanCreateMultipleTodos() {
        List<String> todoNames = new ArrayList<>();
        todoNames.add("First todo");
        todoNames.add("Second todo");
        step.userCreatesFewTodos(todoNames);
//        step.userChecksIfAllTodosAreCreated();
    }

    @After
    public void cleanUp() {
        setup.userClosesAplication();
    }
}
