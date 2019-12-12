package com.github.qbek.steps;

import com.github.qbek.pageobjects.TodoInput;
import com.github.qbek.pageobjects.TodosList;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TodoSteps {
    TodoInput todoInput = new TodoInput();

    TodosList todoList = new TodosList();

//    public void userChecksIfTodoNotExist() {
//        WebElement todos = browser.findElement(todoList);
//        String allTodos = todos.getText();
//        Assert.assertEquals("There should not be a completed TODO on active tab", "", allTodos);
//    }
//
//    public void userChecksIfTodoIsCompleted() {
//        WebElement todo = browser.findElement(todoItemSelector);
//        String todoClasses = todo.getAttribute("class");
//        Assert.assertEquals("This todo shall be completed", "completed", todoClasses);
//    }
//
//    public void userCompletesATodo() {
//        WebElement toggleCheckbox = browser.findElement(todoCompleteToggleSelector);
//        toggleCheckbox.click();
//    }

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
}
