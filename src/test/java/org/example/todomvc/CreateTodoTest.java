package org.example.todomvc;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateTodoTest {

    private final static String TODO_URL = "https://todomvc.com/examples/jquery/dist/#/all";

    private final static By NEW_TODO_INPUT_SELECTOR =  By.cssSelector("#new-todo");
    private final static By TODO_LIST = By.cssSelector("#todo-list");

    private WebDriver browser = new FirefoxDriver();

    @AfterEach
    public void closeBrowser() {
        browser.close();
    }

    @Test
    public void userCanCreateATodo() {
        var todoName = "Moje pierwsze Todo ze szkolenia";

        browser.get(TODO_URL);

        var newTodoInput = browser.findElement(NEW_TODO_INPUT_SELECTOR);
        newTodoInput.sendKeys(todoName);
        newTodoInput.sendKeys(Keys.ENTER);

        var todoLabel = browser.findElement(TODO_LIST);
        MatcherAssert.assertThat("Created todo has valid name",
                todoLabel.getText(),
                Matchers.equalTo(todoName));
    }

    @Test
    public void userCanCompleteATodo() {
        var todoName = "Zadanie do zakończenia";
        browser.get(TODO_URL);

        var newTodoInput = browser.findElement(NEW_TODO_INPUT_SELECTOR);
        newTodoInput.sendKeys(todoName);
        newTodoInput.sendKeys(Keys.ENTER);

        var todoCompleteToggle = browser.findElement(By.cssSelector(".toggle"));
        todoCompleteToggle.click();

        var todoElement = browser.findElement(By.cssSelector("#todo-list li"));
        MatcherAssert.assertThat("Todo is marked as completed",
                todoElement.getAttribute("class"),
                Matchers.containsString("completed")
        );

        var activeTodosFilter = browser.findElement(By.cssSelector("[href=\"#/active\"]"));
        activeTodosFilter.click();

        var todosList = browser.findElement(TODO_LIST);
        MatcherAssert.assertThat("Todos list is emtpy",
                todosList.getText(),
                Matchers.emptyString());

        var completedTodosFilter = browser.findElement(By.cssSelector("[href=\"#/completed\"]"));
        completedTodosFilter.click();

        var todoLabel = browser.findElement(TODO_LIST);
        MatcherAssert.assertThat("Todo is marked as completed",
                todoLabel.getText(),
                Matchers.equalTo(todoName)
        );
    }
}
