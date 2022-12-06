package org.example.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.example.pageobjects.TodoInput;
import org.example.pageobjects.TodoMVCApp;
import org.example.pageobjects.TodosList;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.cssSelector;

public class UserActions {

    @Steps
    TodoInput todoInput;
    @Steps
    TodosList todosList;
    @Steps
    TodoMVCApp mvcApp;

    @Step
    public void userCompletesTodo() {
        todosList.completeTodo();
    }

    @Step
    public void userCreatesNewTodo(String todoName) {
        todoInput.createNewTodo(todoName);
    }

    @Step
    public void userOpensTodoMVCapp() {
        mvcApp.openTodoMVCapp();
    }
}
