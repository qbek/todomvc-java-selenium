package com.github.qbek.steps;

import com.github.qbek.aux.WaitForAnElement;
import com.github.qbek.pageobjects.TodoInput;
import com.github.qbek.pageobjects.TodoItem;
import com.github.qbek.pageobjects.TodosList;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.awaitility.Awaitility;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class TodoSteps {
    TodoInput todoInput = new TodoInput();

    TodosList todoList = new TodosList();

    TodoItem todo = new TodoItem();

    @Step
    public void userChecksIfTodoNotExist() {
        String allTodos = todoList.getAllTodos();
        Assert.assertEquals("There should not be a completed TODO on active tab", "", allTodos);
    }

    @Step
    public void userChecksIfTodoIsCompleted() {
        String todoClasses = todo.getTodoClasses();
        Assert.assertEquals("This todo shall be completed", "completed", todoClasses);
    }

    @Step
    public void userCompletesATodo() {
        todo.completeATodo();
    }

    @Step
    public void userCreatesANewTodo(String todoToCreate) {
        userEnterATodoName(todoToCreate);
        userPressEnter();
    }

    @Step
    public void userEnterATodoName(String todoToCreate) {
        todoInput.enterText(todoToCreate);
    }

    @Step
    public void userPressEnter() {
        todoInput.pressEnter();
    }

    @Step
    public void userChecksIfTodoIsListed(String expectedTodo) {
        String allTodos = todoList.getAllTodos();
        userSeesATodoWithName(expectedTodo, allTodos);
    }

    @Step("User sees a todo: {0} on the todo list")
    public void userSeesATodoWithName(String expectedTodo, String allTodos) {
        Assert.assertEquals("User todo should be created", expectedTodo, allTodos);
    }

    @Step
    public void userCreatesFewTodos(List<String> todoNames) {
        for (String name : todoNames) {
            userCreatesANewTodo(name);
        }
    }

    public void userWaitsForATodoToBeCreated() {
        //lets code a waiting function
        WaitForAnElement elementIsFound = new WaitForAnElement(todo);
        System.out.println("Starting to wait:");
        Awaitility.await()
                .atMost(Duration.ofSeconds(30))
                .pollInterval(Duration.ofSeconds(1))
                .until(elementIsFound);
        System.out.println("Waiting has finished!");


    }
}
