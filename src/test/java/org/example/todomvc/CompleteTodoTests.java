package org.example.todomvc;

import org.example.pageobjects.TodoFilters;
import org.example.pageobjects.TodoInput;
import org.example.pageobjects.TodosList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CompleteTodoTests {

    private String TodoMVC_URL = "https://todomvc.com/examples/jquery/dist/#/all";

    WebDriver browser = new FirefoxDriver();
    TodoInput todoInput = new TodoInput(browser);
    TodosList todoList = new TodosList(browser);
    TodoFilters todoFilters = new TodoFilters(browser);

    @BeforeEach
    public void openApp() {
        browser.get(TodoMVC_URL);
    }

    @AfterEach
    public void closeApp() {
        browser.close();
    }

    @Test
    public void userCanCompleteTheTodo() {
        var todoName = "Zadanie do zakończenia";
        todoInput.enterTodoName(todoName);
        todoInput.submitTodo();

        todoList.completeTodo();
        todoList.checkIsTodoMarkedAsCompleted();
    }

    @Test
    public void userCanFilterActiveTodos() {
        var todoName = "Zadanie do zakończenia kolejne";
        todoInput.enterTodoName(todoName);
        todoInput.submitTodo();
        todoList.completeTodo();
        todoFilters.gotoActive();
        todoList.checkTodoListIsEmpty();
    }


    @Test
    public void userCanFilterCompltedTodos() {
        var todoName = "Zadanie do zakończenia żółć";
        todoInput.enterTodoName(todoName);
        todoInput.submitTodo();
        todoList.completeTodo();
        todoFilters.gotoCompleted();
        todoList.checkTodoHasCorrectName(todoName);
    }
}
