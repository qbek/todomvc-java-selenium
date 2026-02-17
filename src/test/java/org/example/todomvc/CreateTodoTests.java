package org.example.todomvc;


import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateTodoTests {

    private By newTodoInputSelector =  By.cssSelector("#new-todo");
    private By todoListSelector = By.cssSelector("#todo-list");
    private String TodoMVC_URL = "https://todomvc.com/examples/jquery/dist/#/all";


    @Test
    public void userCanCreateANewTodo() {
        var todoName = "Moje zadanie żółć";

        var browser = new FirefoxDriver();
        browser.get(TodoMVC_URL);

        var newTodoInput = browser.findElement(newTodoInputSelector);
        newTodoInput.sendKeys(todoName);
        newTodoInput.sendKeys(Keys.RETURN);

        var todoList = browser.findElement(todoListSelector);

        MatcherAssert.assertThat("Todo exists on the list",
                todoList.isDisplayed(),
                Matchers.equalTo(true));

        MatcherAssert.assertThat("Todo has correct name",
                todoList.getText(),
                Matchers.equalTo(todoName));

        browser.close();

    }
}
