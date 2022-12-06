package org.example.steps;

import org.example.pageobjects.TodoInput;
import org.example.pageobjects.TodoMVCApp;
import org.example.pageobjects.TodosList;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.cssSelector;

public class UserActions {

    TodoInput todoInput;
    TodosList todosList;
    TodoMVCApp mvcApp;

    public UserActions(WebDriver browser) {
        todoInput = new TodoInput(browser);
        todosList = new TodosList(browser);
        mvcApp = new TodoMVCApp(browser);
    }

    public void userCompletesTodo() {
        todosList.completeTodo();
    }

    public void userCreatesNewTodo(String todoName) {
        todoInput.createNewTodo(todoName);
    }


    public void userOpensTodoMVCapp() {
        mvcApp.openTodoMVCapp();
    }
}
