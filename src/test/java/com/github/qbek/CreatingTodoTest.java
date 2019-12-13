package com.github.qbek;

import com.github.javafaker.Faker;
import com.github.qbek.aux.DataGenerator;
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

    @Steps
    DataGenerator data;

    @Before
    public void setup() {
        setup.userOpensTodoMvcApp();
    }

    @Test
    @WithTag("smoke")
    public void userCanCreateATodo() {
        String todoName = data.generateTodoName();
        step.userCreatesANewTodo(todoName);
        step.userChecksIfTodoIsListed(todoName);
    }

    @Test
    public void userCanCreateATodoAndWaitForIt() {
        String todoName = data.generateTodoName();
        step.userCreatesANewTodo(todoName);
        step.userWaitsForATodoToBeCreated();
        step.userChecksIfTodoIsListed(todoName);
    }


    @Test
    public void userCanCreateMultipleTodos() throws InterruptedException {
        List<String> todoNames = data.generateFewTodos();
        String todoToComplete = data.generateTodoName();
        System.out.println("Todo to complete: " + todoToComplete);
        step.userCreatesFewTodos(todoNames);
        step.userCreatesANewTodo(todoToComplete);
        step.userCreatesFewTodos(todoNames);
        step.userCompletesATodoWithName(todoToComplete);
        Thread.sleep(5000);
    }

    @After
    public void cleanUp() {
        setup.userClosesAplication();
    }
}
